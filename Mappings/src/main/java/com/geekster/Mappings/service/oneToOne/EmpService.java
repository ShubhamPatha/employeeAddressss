package com.geekster.Mappings.service.oneToOne;

import com.geekster.Mappings.model.oneToOne.Address;
import com.geekster.Mappings.model.oneToOne.Employee;
import com.geekster.Mappings.repo.oneToOne.IEmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

    @Autowired

    IEmpRepo iEmpRepo;

    public  Iterable<Employee> getAllEmployee() {
        return iEmpRepo.findAll();
    }

    public  Employee getAddressbyid(Integer id) {
        return iEmpRepo.getAllAddressbyid(id);
    }

    public void addEmp(Employee emp) {
        iEmpRepo.save(emp);
    }

    public String deleteAddressById(Integer id) {
        iEmpRepo.deleteById(Long.valueOf(id));
        return "Employee deleted successfully of id "+id;
    }
}
