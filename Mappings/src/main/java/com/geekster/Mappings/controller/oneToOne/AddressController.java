package com.geekster.Mappings.controller.oneToOne;

import com.geekster.Mappings.model.oneToOne.Address;
import com.geekster.Mappings.service.oneToOne.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;


    @GetMapping("address")
    public Iterable<Address> getAllAddress()
    {

        return addressService.getAllAddress();
    }


    @PostMapping("address")
    public void addAddress(@RequestBody Address address)
    {
        addressService.addAddress(address);
    }



    @GetMapping("address/{id}")
    public Address getAddressById(@PathVariable Integer id){
        return addressService.getAddressbyid(id);
    }

    @DeleteMapping("address/{id}")
    public String deleteRoomById(@PathVariable Integer id){
        return addressService.deleteAddressById(id);
    }

}
