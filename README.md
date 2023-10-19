# EmployeeAddress

## FRAMEWORK AND LANGUAGE USED
* JAVA 17
* MAVEN
* SPRINGBOOT 3.1.1
<!-- Headings -->   
## DATA FLOW

<!-- Code Blocks -->

  ### CONFIGURATION
  ``` 

```


 ### CONTROLLER one to one
 #### Address controller
  ``` 
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

```
#### Employee controller
  ```
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


```


 ### MODEL one to one
 #### Address
  ``` 

package com.geekster.Mappings.model.oneToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addId;
    private String addName;
}

```
 #### Employee
  ``` 

package com.geekster.Mappings.model.oneToOne;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;
    private String empName;

    @OneToOne
    @JoinColumn(name = "fk_addressId")
    Address address;
}


```

### REPO one to one
#### IAddRepo
  ``` 
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

```
#### IEmpRepo
  ``` 
package com.geekster.Mappings.repo.oneToOne;

import com.geekster.Mappings.model.oneToOne.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IEmpRepo extends CrudRepository<Employee,Long> {
    @Query(value = "select * from employee where empId = :id" , nativeQuery = true)
    Employee getAllAddressbyid(Integer id);
}


```


### SERVICE one to one
#### Employee Service
  ``` 
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

```
#### Address Service
  ``` 
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


```


### MAIN
  ``` 
package com.geekster.Mappings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingsApplication.class, args);
	}

}


```

#### Resource

```
spring.datasource.url=jdbc:mysql://localhost:3306/mappings
spring.datasource.username=root
spring.datasource.password=Shubham12@
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true
```



 ### POM
  ``` 
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.1.1</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.geekster</groupId>
	<artifactId>Mappings</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>Mappings</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.1.0</version>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>

</project>

```
## DATA STRUCTURE USED
* LIST 
* STRING
* LOCAL DATE
* INTEGER
* USER

# PROJECT SUMMARY

## USER MANAGEMENT SYSTEM Has been created with the following attribute
#### Employee:
* id 
* first name (String)
* lastName (String)
* address (Address)
#### Address:
*id (Long)
*street (String)
*City (String)
*state (String)
*Zipcode (String)
### Endpoint to be provided 
* AddUser 
* getUser/{userid}
* getAllUser
* updateUserInfo
* deleteUser









<!-- Headings -->   
# Author
SHUBHAM PATHAK
 <!-- UL -->
* Twitter <!-- Links -->
[@ShubhamPathak]( https://twitter.com/Shubham15022000)
* Github  <!-- Links -->
[@ShubhamPathak]( https://github.com/ShubhamPatha)
<!-- Headings -->   
