
package com.datagrokr.multitenant.service.secondary;

import com.datagrokr.multitenant.dto.BooksDTO;

import java.util.List;

import java.util.List;

public interface SecondaryDBService<T> {

    public List<T> getAllBooks();
    public T getBookById(Integer id);
    public T saveBook(T book);
    public void deleteBookById(Integer id);

}
