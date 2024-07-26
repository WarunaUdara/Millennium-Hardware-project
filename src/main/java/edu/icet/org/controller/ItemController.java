package edu.icet.org.controller;

import edu.icet.org.dto.Customer;
import edu.icet.org.dto.Item;
import edu.icet.org.service.CustomerService;
import edu.icet.org.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/item")
@CrossOrigin
@RequiredArgsConstructor
public class ItemController {
    private final ItemService service;
    @PostMapping("/add")
    Item addItem(@RequestBody Item item){
        return service.addItem(item);
    }
    @GetMapping("/get-all")
    List<Item> getItems(){
        return service.getItems();
    }
    @PutMapping("/update")
    Item update(@RequestBody Item item){
        return service.update(item);
    }
    @DeleteMapping("/{id}")
    Map<String, Boolean> removeById(@PathVariable Long id){
        return service.removeById(id);
    }
}
