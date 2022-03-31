package com.datagrokr.books.repository;

import com.datagrokr.books.dto.BookDTO;
import com.datagrokr.books.model.Book;
import com.datagrokr.books.model.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.datagrokr.books.model.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepo {
 
    List<Employee> getAll();
    Employee getOne(Long id);
    Employee saveOne(Employee employee);
    String updateOne(Long id, Employee employee);
    String deleteOne(Long id);

    public List<BookDTO> mostSoldBook();
    
}
