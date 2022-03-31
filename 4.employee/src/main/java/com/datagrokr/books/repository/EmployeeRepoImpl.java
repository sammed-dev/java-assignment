
package com.datagrokr.books.repository;

import com.datagrokr.books.dto.BookDTO;
import com.datagrokr.books.model.Book;
import com.datagrokr.books.model.Employee;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.transaction.Transactional;

import com.datagrokr.books.model.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class EmployeeRepoImpl implements EmployeeRepo{
    
    @Autowired
    EntityManager em;
   

    @Override
    public List<Employee> getAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);
        cq.select(root);
        List<Employee> results = em.createQuery(cq).getResultList();
        return results;
    }
        

    @Override
    public Employee getOne(Long id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);
        cq.select(root);
        cq.where(cb.equal(root.get("user_id"), id));
        Employee results = em.createQuery(cq).getSingleResult();
        return results;
    }

    @Override
    public Employee saveOne(Employee employee) {
        Query query = em.createNativeQuery("INSERT INTO employees values(?,?)")
                .setParameter(1, employee.getUser_id())
                .setParameter(2, employee.getUser_name());
        query.executeUpdate();
        return employee;
    }

    @Override
    public String updateOne(Long id, Employee employee) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<Employee> update = cb.createCriteriaUpdate(Employee.class);
        Root<Employee> root = update.from(Employee.class);
        update.set("user_name", employee.getUser_name());
        update.where(root.get("user_id").in(id));
        this.em.createQuery(update).executeUpdate();
        return "Employee updated with id :"+id;
    }

    @Override
    public String deleteOne(Long id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<Employee> delete = cb.createCriteriaDelete(Employee.class);
        Root<Employee> root = delete.from(Employee.class);
        
//      criteriaDelete.where(cb.equal(root.get("user_id"), id));
        delete.where(root.get("user_id").in(id));
        this.em.createQuery(delete).executeUpdate();
        return "deleted employee with id :"+id;
    }

//    @Override
//    public List<Book> mostSoldBook() {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Sales> most_sold = cb.createQuery(Sales.class);
//        Root<Sales> root = most_sold.from(Sales.class);
//        Join<Object, Object> sales = root.join("books");  // bcz @Table(name = "books")
//        most_sold.select(sales.get("book_name")).where(cb.like(sales.get("genre"), "software")).groupBy(sales.get("book_id")).orderBy(cb.desc(cb.count(most_sold.from(Sales.class))));

//        return em.createQuery(most_sold).getResultList();



//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Book> most_sold = cb.createQuery(Book.class);
//        Root<Book> root = most_sold.from(Book.class);
//        most_sold.multiselect(root.get("book_name"), cb.count(root.get("book_name")));
//        most_sold.where(cb.like(root.get("genre"), "software"));
//        most_sold.groupBy(root.get("book_name"));
//        most_sold.orderBy(cb.desc(cb.count(root.get("book_name"))));
//
//        List<Book> results = em.createQuery(most_sold).getResultList();
//        return  results;
//    }

//    @Override
//    public List<Tuple> mostSoldBook() {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Tuple> cq = cb.createQuery(Tuple.class);
//        Root<Book> root = cq.from(Book.class);
//        Predicate p = cb.equal(root.get("genre"),"software");
//        cq.where(p);
//        cq.groupBy(root.get("book_name"));
//        cq.multiselect(root.get("book_name"), cb.count(root));
//        List<Tuple> tuples = em.createQuery(cq).getResultList();
//
//        return tuples;
//    }


    @Override
    public List<BookDTO> mostSoldBook() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> cq = cb.createQuery(Tuple.class);
        // there were lot of errors as bcz of using Book entity
        // results received were only book_name and count(this is completely diff field compared to Book) and using book class which is incompatible in type
        Root<Book> root = cq.from(Book.class);
        Predicate p = cb.equal(root.get("genre"),"software");
        cq.where(p);
        cq.groupBy(root.get("book_name"));
        cq.orderBy(cb.desc(cb.count(root)));
        cq.multiselect(root.get("book_name"),cb.count(root));

        List<Tuple> tuples = em.createQuery(cq).setMaxResults(1).getResultList();  //setMaxResults(n) acts as Limit n;
        List<BookDTO> bookDTOs= new ArrayList<>();
        for (Tuple tp : tuples){
            BookDTO bookDTO = new BookDTO();
            bookDTO.setBook_name((String) tp.get(0));
            bookDTO.setCount((Long) tp.get(1));
            bookDTOs.add(bookDTO);
        }
        System.out.println(tuples);
        return bookDTOs;
    }



//    @Override
//    public List<Book> mostSoldBook() {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
//        Metamodel m = em.getMetamodel();
//        EntityType<Book> Book_ = m.entity(Book.class);
//        Root<Book> root = cq.from(Book_);
//        List<Book> res = em.createQuery(cq).getResultList();
//        return res;
//    }



//    @Override
//    public List<Book> mostSoldBook() {
//        Query query = em.createNativeQuery("SELECT book_name, count(book_name)  FROM books WHERE genre =? group by book_name", Book.class) //you know the difference of not writting Book.class
//                .setParameter(1,"software");
//        return query.getResultList();
//    }



}
