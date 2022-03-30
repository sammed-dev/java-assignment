package com.datagrokr.multitenant.service.primary;

import com.datagrokr.multitenant.entity.secondary.Book;
import org.modelmapper.ModelMapper;
import com.datagrokr.multitenant.dto.BooksDTO;
import com.datagrokr.multitenant.entity.primary.PrimaryBook;
import com.datagrokr.multitenant.exceptions.ResourceNotFoundException;
import com.datagrokr.multitenant.repository.primary.PrimaryBookRepository;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PrimaryDBServiceImpl implements PrimaryDBService<BooksDTO>{
    
    @Autowired
    PrimaryBookRepository primaryBookRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<BooksDTO> getAllBooks() {
        List<PrimaryBook> books = primaryBookRepository.findAll();
        return books.stream().map(this::allBooksDTOMapper).collect(Collectors.toList());
    }

    private BooksDTO allBooksDTOMapper(PrimaryBook primaryBook){
        BooksDTO booksDTO = new BooksDTO();
        booksDTO = modelMapper.map(primaryBook, BooksDTO.class);
        return booksDTO;
    }

//    @Override
//    public PrimaryBook getBookById(Integer id) {
//        return primaryBookRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("book dosen't exist"));
//    }

    @Override
    public BooksDTO getBookById(Integer id) {
        PrimaryBook primaryBook = primaryBookRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("book dosen't exist"));
        return booksDTOMapper(primaryBook);
    }



    private BooksDTO booksDTOMapper(PrimaryBook primaryBook){
        BooksDTO booksDTO = new BooksDTO();

        booksDTO = modelMapper.map(primaryBook, BooksDTO.class);
        booksDTO.setDtoId(100);
//        booksDTO.setBook_id(primaryBook.getBook_id());
//        booksDTO.setBookname(primaryBook.getBookname());
//        booksDTO.setGenre(primaryBook.getGenre());
//        booksDTO.setAuthor(primaryBook.getAuthor());
//        booksDTO.setDtoId(primaryBook.getBook_id()+1000);
        return booksDTO;
    }

//    @Override
//    public BooksDTO saveBook(PrimaryBook book) {
//        return primaryBookRepository.save(book);
//    }

    @Override
    public BooksDTO saveBook(BooksDTO book) {
        PrimaryBook primaryBook = modelMapper.map(book, PrimaryBook.class);
        primaryBookRepository.save(primaryBook);
        book.setBook_id(primaryBook.getBook_id());
        book.setDtoId(primaryBook.getBook_id()+100);
        return book;
    }

    @Override
    public void deleteBookById(Integer id) {
         primaryBookRepository.deleteById(id);
    }
}
