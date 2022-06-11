
package org.iesfm.model.services;

import org.iesfm.model.pojos.Basket;
import org.iesfm.model.repositories.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {

    @Autowired
    private BasketRepository basketRepository;

    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public Basket postBasket(Basket basket) {
        if (basketRepository.existsById(basket.getId())) {
            return null;
        } else {
            basketRepository.save(basket);
            return basket;
        }
    }

    public List<Basket> getAllBaskets() {
        return basketRepository.findAll();
    }

    public Basket getBasket(int id) {
        if (!basketRepository.existsById(id)) {
            return null;
        } else {
            return basketRepository.findById(id).get();
        }
    }

    public Basket updateBasket(int id, Basket updatedBasket) {
        if (!basketRepository.existsById(id)) {
            return null;
        } else {
                Basket basket = basketRepository.findById(id).get();
                basket.setUsername(updatedBasket.getUsername());
                basket.setPrice(updatedBasket.getPrice());
                basketRepository.save(basket);
                return basket;
        }
    }

    public void deleteBasket(int id) {
        basketRepository.delete(basketRepository.findById(id).get());
    }
}
