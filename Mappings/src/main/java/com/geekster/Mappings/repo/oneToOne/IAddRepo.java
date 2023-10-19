package com.geekster.Mappings.repo.oneToOne;

import com.geekster.Mappings.model.oneToOne.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddRepo extends CrudRepository<Address,Long> {

    @Query(value = "select * from address where addId = :id" , nativeQuery = true)
    Address getAllAddressbyid(Integer id);
}
