package com.fullstack.controller;

import com.fullstack.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    List<Employee> employeeList = Stream.of(new Employee(121, "SWARA", 97000.99),
            new Employee(122, "POOJA", 87000.99),
            new Employee(123, "RUTUJA", 77000.99),
            new Employee(124, "RAJESH", 47000.99),
            new Employee(125, "APARNA", 67000.99)
    ).toList();

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("WELCOME TO FULL STACK JAVA DEVELOPER PUNE");
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Employee>> sortbyname() {
        return ResponseEntity.ok(employeeList.stream().sorted(Comparator.comparing(Employee::getEmpName)).toList());
    }

    @GetMapping("/sortbysalary")
    public ResponseEntity<List<Employee>> sortbysalary() {
        return ResponseEntity.ok(employeeList.stream().sorted(Comparator.comparing(Employee::getEmpSalary)).toList());
    }

    @GetMapping("/searchbyname")
    public ResponseEntity<List<Employee>> searchByName(@RequestParam String empName) {
        return ResponseEntity.ok(employeeList.stream().filter(emp -> emp.getEmpName().equals(empName)).toList());
    }

    @GetMapping("/userinfo")
    public Principal getUserDetails(Principal principal){
        return principal;
    }


}
