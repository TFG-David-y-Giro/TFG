
package org.iesfm.model.services;

import org.iesfm.model.pojos.Category;
import org.iesfm.model.pojos.Item;
import org.iesfm.model.repositories.CategoryRepository;
import org.iesfm.model.repositories.ItemRepository;
import org.iesfm.model.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private SupplierRepository supplierRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item postItem(Item newItem) {
        if (itemRepository.existsById(newItem.getId())) {
            return null;
        } else if (categoryRepository.findByName(newItem.getCategory()) == null) {
            Category category = new Category(0, newItem.getCategory());
            categoryRepository.save(category);
            itemRepository.save(newItem);
            return newItem;
        } else if (supplierRepository.findByName(newItem.getSupplier()) == null) {
            return null;
        } else {
            itemRepository.save(newItem);
            return newItem;
        }
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public Item getItem(int id) {
        if (!itemRepository.existsById(id)) {
            return null;
        } else {
            return itemRepository.findById(id).get();
        }
    }

    public Item putItem(int id, Item itemUpdated) {
        if (!itemRepository.existsById(id)) {
            return null;
        } else {
            Item item = getItem(id);
            item.setName(itemUpdated.getName());
            item.setCategory(itemUpdated.getCategory());
            item.setSupplier(itemUpdated.getSupplier());
            item.setPrice(itemUpdated.getPrice());
            item.setQuantity(itemUpdated.getQuantity());
            itemRepository.save(item);
            return item;
        }
    }

    public void deleteItem(int id) {
        itemRepository.delete(itemRepository.findById(id).get());
    }

}
