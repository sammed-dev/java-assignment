package com.datagrokr.multitenant.service.primary;

import com.datagrokr.multitenant.dto.BooksDTO;

import java.util.List;

public interface PrimaryDBService<T> {
    
    public List<T> getAllBooks();
    public T getBookById(Integer id);
    public T saveBook(T book);
    public void deleteBookById(Integer id);
    
    
}
