package com.datagrokr.books.controller;

import com.datagrokr.books.dto.BookDTO;
import com.datagrokr.books.model.Book;
import com.datagrokr.books.model.Employee;
import com.datagrokr.books.exception.ResourceNotFound;
import com.datagrokr.books.model.Sales;
import com.datagrokr.books.repository.EmployeeRepoImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.websocket.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.datagrokr.books.repository.EmployeeRepo;

@RestController
@RequestMapping("/api/")
public class EmployeeController {
    
    @Autowired
    EmployeeRepoImpl employeeRepo;
   
    //retrieve
    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return employeeRepo.getAll();  
    }
    
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return employeeRepo.getOne(id);
    }

    //store
    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepo.saveOne(employee);
    }

    //update
    @PutMapping("/employee/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return employeeRepo.updateOne(id, employee);
    }

    //delete
    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable Long id){
        return employeeRepo.deleteOne(id);
    }


    @GetMapping("/mostsold")
    public List<BookDTO> mostBroughtBook(){
        return employeeRepo.mostSoldBook();
    }

}
