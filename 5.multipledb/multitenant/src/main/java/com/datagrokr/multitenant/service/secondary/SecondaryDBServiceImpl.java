
package com.datagrokr.multitenant.service.secondary;

import com.datagrokr.multitenant.dto.BooksDTO;
import com.datagrokr.multitenant.entity.primary.PrimaryBook;
import com.datagrokr.multitenant.entity.secondary.Book;
import com.datagrokr.multitenant.exceptions.ResourceNotFoundException;
import com.datagrokr.multitenant.repository.secondary.BookRepository;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SecondaryDBServiceImpl implements SecondaryDBService<BooksDTO> {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<BooksDTO> getAllBooks() {
        List<Book> books =  bookRepository.findAll();
        return books.stream().map(this::allBooksDTOMapper).collect(Collectors.toList());
    }

    private BooksDTO allBooksDTOMapper(Book book){
        BooksDTO booksDTO = new BooksDTO();
        booksDTO = modelMapper.map(book, BooksDTO.class);
        booksDTO.setDtoId(book.getBook_id()+100);
        return booksDTO;
    }

//    @Override
//    public Book getBookById(Integer id) {
//        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("book dosen't exist"));
//    }

    @Override
    public BooksDTO getBookById(Integer id) {
        Book book = bookRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("book dosen't exist"));
        return booksDTOMapper(book);
    }
    private BooksDTO booksDTOMapper(Book book){
        BooksDTO booksDTO = new BooksDTO();
        booksDTO = modelMapper.map(book, BooksDTO.class);
        booksDTO.setDtoId(book.getBook_id()+200);
        return booksDTO;
    }

//    @Override
//    public Book saveBook(Book book) {
//        return bookRepository.save(book);
//    }

    @Override
    public BooksDTO saveBook(BooksDTO book) {
        Book secondaryBook = modelMapper.map(book, Book.class);
        bookRepository.save(secondaryBook);
        return book;
    }

    @Override
    public void deleteBookById(Integer id) {
        bookRepository.deleteById(id);
    }
    
}
