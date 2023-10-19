package com.geekster.Mappings.repo.oneToOne;

import com.geekster.Mappings.model.oneToOne.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IEmpRepo extends CrudRepository<Employee,Long> {
    @Query(value = "select * from employee where empId = :id" , nativeQuery = true)
    Employee getAllAddressbyid(Integer id);
}
