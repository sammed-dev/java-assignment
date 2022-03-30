
package com.datagrokr.multitenant.controller;

import com.datagrokr.multitenant.dto.BooksDTO;
import com.datagrokr.multitenant.entity.primary.PrimaryBook;
import com.datagrokr.multitenant.service.primary.PrimaryDBService;
import com.datagrokr.multitenant.service.primary.PrimaryDBServiceImpl;
import com.datagrokr.multitenant.service.secondary.SecondaryDBServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/")
public class MultiDBController {
    
    
    @Autowired
    private PrimaryDBServiceImpl primaryDBServiceImpl;
    
    @Autowired
    private SecondaryDBServiceImpl secondaryDBServiceImpl;
    
    
    @GetMapping("/all/{t_id}")
    List<BooksDTO> getAllBooksPrimary(@PathVariable Integer t_id){
        if(t_id >=1 && t_id<1000)
            return primaryDBServiceImpl.getAllBooks();
        else
            return secondaryDBServiceImpl.getAllBooks();
    }

    @GetMapping("/book/{id}/{t_id}")
    BooksDTO getBookById(@PathVariable Integer id, @PathVariable Integer t_id){
        if(t_id >=1 && t_id<1000)
            return primaryDBServiceImpl.getBookById(id);
        else
            return secondaryDBServiceImpl.getBookById(id);
    }


    @PostMapping("/register/{t_id}")
    BooksDTO saveBookPrimary(@RequestBody BooksDTO booksDTO, @PathVariable Integer t_id){
        if(t_id >=1 && t_id<1000)
            return primaryDBServiceImpl.saveBook(booksDTO);
        else
            return secondaryDBServiceImpl.saveBook(booksDTO);
    }


    @DeleteMapping("/remove/{id}/{t_id}")
    void deleteBookPrimary(@PathVariable Integer id, @PathVariable Integer t_id){
        if(t_id >=1 && t_id<1000)
            primaryDBServiceImpl.deleteBookById(id);
        else
            secondaryDBServiceImpl.deleteBookById(id);
    }
    
}
