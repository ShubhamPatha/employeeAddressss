package com.geekster.Mappings.service.oneToOne;

import com.geekster.Mappings.model.oneToOne.Address;
import com.geekster.Mappings.repo.oneToOne.IAddRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired

    IAddRepo iAddRepo;

    public  Address getAddressbyid(Integer id) {
        return iAddRepo.getAllAddressbyid(id);
    }

    public  String deleteAddressById(Integer id) {
        iAddRepo.deleteById(Long.valueOf(id));
        return "Address deleted successfully of id "+id;
    }


    public void addAddress(Address address) {
        iAddRepo.save(address);
    }
    public Iterable<Address> getAllAddress() {
       return iAddRepo.findAll();
    }

}
