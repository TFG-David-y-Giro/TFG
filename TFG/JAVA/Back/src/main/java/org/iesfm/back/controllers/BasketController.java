package org.iesfm.back.controllers;

import org.iesfm.model.pojos.Basket;
import org.iesfm.model.services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class BasketController {

    @Autowired
    private BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @PostMapping("/cart")
    @ResponseStatus(HttpStatus.CREATED)
    public Basket postBasket(@RequestBody Basket basket) {
        if (basketService.getBasket(basket.getId()) != null) {
            return null;
        } else {
            basketService.postBasket(basket);
            return basket;
        }
    }

    @GetMapping("/cart")
    public List<Basket> getAllCarts() {
        return basketService.getAllBaskets();
    }

    @GetMapping("/cart/{id}")
    public Basket getCart(@PathVariable int id) {
        if (basketService.getBasket(id) == null) {
            return null;
        } else {
            return basketService.getBasket(id);
        }
    }

    @PutMapping("/cart/{id}")
    public Basket putBasket(@PathVariable int id, @RequestBody Basket updatedBasket) {
        if (basketService.getBasket(id) == null) {
            return null;
        } else {
            basketService.updateBasket(id, updatedBasket);
            return updatedBasket;
        }
    }

}
