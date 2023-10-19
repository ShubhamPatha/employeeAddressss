package com.geekster.Mappings.controller.oneToOne;


import com.geekster.Mappings.model.oneToOne.Address;
import com.geekster.Mappings.model.oneToOne.Employee;
import com.geekster.Mappings.service.oneToOne.AddressService;
import com.geekster.Mappings.service.oneToOne.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpController {

    @Autowired
    EmpService empService;
    @GetMapping("Employee")
    public Iterable<Employee> getAllAddress()
    {

        return empService.getAllEmployee();
    }
    @PostMapping("Employee")
    public void addAddress(@RequestBody Employee employee)
    {
        empService.addEmp(employee);
    }




    @GetMapping("employee/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        return empService.getAddressbyid(id);
    }

    @DeleteMapping("employee/{id}")
    public String deleteEmployeeById(@PathVariable Integer id){
        return empService.deleteAddressById(id);
    }




}
