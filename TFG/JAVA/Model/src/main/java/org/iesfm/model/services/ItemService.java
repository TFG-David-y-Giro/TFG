
package org.iesfm.model.services;

import org.iesfm.model.pojos.Item;
import org.iesfm.model.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item postItem(Item newItem){
        if (itemRepository.existsById(newItem.getId())){
            return null;
        }else{
            itemRepository.save(newItem);
            return newItem;
        }
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public Item getItem(Integer id) {
        if (!itemRepository.existsById(id)) {
            return null;
        }else {
            return itemRepository.getById(id);
        }
    }

    public Item putItem(Integer id, Item itemUpdated) {
            Item item = getItem(id);
            itemRepository.delete(item);
            itemUpdated.setId(id);
            itemRepository.save(itemUpdated);
            return itemUpdated;
    }

    public Item deleteItem(Integer id) {
        Item itemDeleted = getItem(id);
        itemRepository.delete(itemDeleted);
        return itemDeleted;
    }

}
