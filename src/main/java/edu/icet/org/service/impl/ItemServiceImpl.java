package edu.icet.org.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.org.dto.Customer;
import edu.icet.org.dto.Item;
import edu.icet.org.entity.CustomerEntity;
import edu.icet.org.entity.ItemEntity;
import edu.icet.org.repository.CustomerJpaRepository;
import edu.icet.org.repository.ItemJpaRepository;
import edu.icet.org.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemJpaRepository jpaRepository;
    @Override
    public Item addItem(Item item) {
        ObjectMapper mapper=new ObjectMapper();
        ItemEntity itemEntity = mapper.convertValue(item, ItemEntity.class);
        ItemEntity saved = jpaRepository.save(itemEntity);
        return mapper.convertValue(saved, Item.class);
    }

    @Override
    public List<Item> getItems() {
        List<Item> itemList=new ArrayList<>();
        ObjectMapper mapper=new ObjectMapper();
        for (ItemEntity itemEntity : jpaRepository.findAll()) {
            itemList.add(mapper.convertValue(itemEntity,Item.class));
        }
        return itemList;
    }

    @Override
    public Item update(Item item) {
        if(jpaRepository.existsById(item.getId())){
            ObjectMapper mapper=new ObjectMapper();
            return mapper.convertValue(jpaRepository.save(
                    mapper.convertValue(item, ItemEntity.class)),Item.class);
        }
        return null;
    }

    @Override
    public Map<String, Boolean> removeById(Long id) {
        if(jpaRepository.existsById(id)) {
            jpaRepository.deleteById(id);
            return Collections.singletonMap("isDeletedSuccessful",true);

        }
        return Collections.singletonMap("isDeletedSuccessful",false);
    }
}
