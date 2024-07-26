package edu.icet.org.service;

import edu.icet.org.dto.Item;

import java.util.List;
import java.util.Map;

public interface ItemService {
    Item addItem(Item item);

    List<Item> getItems();

    Item update(Item item);

    Map<String, Boolean> removeById(Long id);
}
