package org.iesfm.back.controllers;

import org.iesfm.model.pojos.Supplier;
import org.iesfm.model.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping("/supplier")
    @ResponseStatus(HttpStatus.CREATED)
    public Supplier postSupplier(@RequestBody Supplier newSupplier) {
        if (supplierService.getSupplier(newSupplier.getId()) == null) {
            supplierService.createSupplier(newSupplier);
            return newSupplier;
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existía");
        }
    }

    @GetMapping("/supplier")
    public List<Supplier> getSuppliers(){
        return supplierService.getSuppliers();
    }

    @GetMapping("/supplier/{supplier_id}")
    public Supplier getSupplier(@PathVariable int id) {
        if (supplierService.getSupplier(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No encontrado");
        } else {
            return supplierService.getSupplier(id);
        }
    }
}
