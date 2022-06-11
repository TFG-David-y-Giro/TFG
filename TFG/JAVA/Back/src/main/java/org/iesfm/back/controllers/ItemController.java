package org.iesfm.back.controllers;

import org.iesfm.model.pojos.Item;
import org.iesfm.model.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/item")
    @ResponseStatus(HttpStatus.CREATED)
    public Item postItem(@RequestBody Item newItem) {
        if (itemService.getItem(newItem.getId()) == null) {
            itemService.postItem(newItem);
            return newItem;
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existía");
        }
    }

    @GetMapping("/item/{id}")
    public Item getItem(@PathVariable int id) {
            return itemService.getItem(id);
    }

    @GetMapping("/item")
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @PutMapping("/item/{id}")
    public Item putItem(@PathVariable int id, @RequestBody Item itemUpdated) {
        return itemService.putItem(id, itemUpdated);
    }

    @DeleteMapping("/item/{id}")
    public Item deleteItem(@PathVariable int id) {
        if (itemService.getItem(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe");
        } else {
            itemService.deleteItem(id);
            return itemService.getItem(id);
        }
    }

}
