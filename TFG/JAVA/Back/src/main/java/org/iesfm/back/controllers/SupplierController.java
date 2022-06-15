package org.iesfm.back.controllers;

import org.iesfm.model.pojos.Supplier;
import org.iesfm.model.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
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

    @GetMapping("/supplier/names")
    public List<String> getNames(){return supplierService.getSupplierNames();}

    @GetMapping(value ="/supplier", params = "country")
    public List<Supplier> getSuppliersByCountry(@RequestParam ("country") String country) {
        return  supplierService.getSupplierByCountry(country);
    }

    @GetMapping("/supplier/{id}")
    public Supplier getSupplier(@PathVariable int id) {
            return supplierService.getSupplier(id);
    }

    @PutMapping("/supplier/{id}")
    public Supplier putSupplier(@PathVariable int id, @RequestBody Supplier updatedSupplier) {
        if (supplierService.getSupplier(id) == null) {
            return null;
        } else {
            supplierService.putSupplier(id, updatedSupplier);
            return updatedSupplier;
        }
    }
    @DeleteMapping("/supplier/{id}")
    public void deleteSupplier(@PathVariable int id) {
        if (supplierService.getSupplier(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe");
        } else {
            deleteSupplier(id);
        }
    }
}
