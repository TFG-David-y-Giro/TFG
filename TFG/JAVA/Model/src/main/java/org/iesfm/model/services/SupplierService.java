package org.iesfm.model.services;

import org.iesfm.model.pojos.Supplier;
import org.iesfm.model.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getSuppliers() {
        return supplierRepository.findAll();
    }

    public List<String> getSupplierNames() { return supplierRepository.getSuppliersNames();}

    public Supplier getSupplier(int id) {
        if (!supplierRepository.existsById(id)) {
            return null;
        } else {
            return supplierRepository.findById(id).get();
        }
    }
    public List<Supplier> getSupplierByCountry(String country) {
        return supplierRepository.getSuppliersByCountry(country);
    }

    public Supplier createSupplier(Supplier newSupplier) {
        if (supplierRepository.existsById(newSupplier.getId())) {
            return null;
        } else {
            supplierRepository.save(newSupplier);
            return newSupplier;
        }
    }

    public Supplier putSupplier(int id, Supplier updatedSupplier) {
        if (!supplierRepository.existsById(id)) {
            return null;
        } else {
            Supplier existingSupplier = supplierRepository.findById(id).get();
            existingSupplier.setName(updatedSupplier.getName());
            existingSupplier.setCountry(updatedSupplier.getCountry());
            supplierRepository.save(existingSupplier);
            return existingSupplier;
        }
    }
    public void deleteSupplier(int id) {
        supplierRepository.deleteById(id);
    }

}
