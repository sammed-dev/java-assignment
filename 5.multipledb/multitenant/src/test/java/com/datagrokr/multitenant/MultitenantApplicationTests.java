//package com.datagrokr.multitenant;
//
//import com.datagrokr.multitenant.entity.primary.PrimaryBook;
//import com.datagrokr.multitenant.entity.primary.PrimarySales;
//import com.datagrokr.multitenant.entity.primary.PrimaryUser;
//import com.datagrokr.multitenant.entity.secondary.Book;
//import com.datagrokr.multitenant.entity.secondary.Sales;
//import com.datagrokr.multitenant.entity.secondary.User;
//import com.datagrokr.multitenant.repository.primary.PrimaryBookRepository;
//import com.datagrokr.multitenant.repository.primary.PrimarySalesRepository;
//import com.datagrokr.multitenant.repository.primary.PrimaryUserRepository;
//import com.datagrokr.multitenant.repository.secondary.BookRepository;
//import com.datagrokr.multitenant.repository.secondary.SalesRepository;
//import com.datagrokr.multitenant.repository.secondary.UserRepository;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Optional;
//
//@SpringBootTest
//class MultitenantApplicationTests {
//
//	@Autowired
//	PrimaryBookRepository primaryBookRepository;
//
//	@Autowired
//	PrimarySalesRepository primarySalesRepository;
//
//	@Autowired
//	PrimaryUserRepository primaryUserRepository;
//
//	@Autowired
//	BookRepository bookRepository;
//
//	@Autowired
//	SalesRepository salesRepository;
//
//	@Autowired
//	UserRepository userRepository;
//
//
////	private static PrimaryBook primaryBook;
////	private static PrimarySales primarySales;
////	private static PrimaryUser primaryUser;
////
////	private static Book book;
////	private static Sales sales;
////	private static User user;
//
//
////	@BeforeAll
////	public static void initilizeObjects(){
////		primaryBook = PrimaryBook.builder().bookname("complete python").genre("software").author("linus").build();
////		primarySales = PrimarySales.builder().user_id(100).book_id(1).build();
////		primaryUser = PrimaryUser.builder().username("sammed").build();
////
////		book = Book.builder().bookname("CN").genre("theory").author("john").build();
////		sales = Sales.builder().user_id(200).book_id(101).build();
////		user = User.builder().username("kavya").build();
////	}
//
//	@Test
//	void contextLoads() {
//	}
//
//
//
//	//   PRIMARY DATABASE TESTING :
////	@Test
////	void primaryBookTest(){
////		PrimaryBook savedBook = primaryBookRepository.save(primaryBook);
////		Optional<PrimaryBook> bookById = primaryBookRepository.findById(savedBook.getBook_id());
////		assert (bookById.isPresent());
////	}
////
////	@Test
////	void primarySalesTest(){
////		PrimarySales savedSales = primarySalesRepository.save(primarySales);
////		Optional<PrimarySales> salesById = primarySalesRepository.findById(savedSales.getSalesid());
////		assert (salesById.isPresent());
////	}
////
////	@Test
////	void primaryUserTest(){
////		PrimaryUser savedUser = primaryUserRepository.save(primaryUser);
////		Optional<PrimaryUser> userById = primaryUserRepository.findById(savedUser.getUser_id());
////		assert (userById.isPresent());
////	}
//
//
//	//SECONDARY DATABASE TESTING :
//
////	@Test
////	void bookTest(){
////		Book savedBook = bookRepository.save(book);
////		Optional<Book> bookById = bookRepository.findById(savedBook.getBook_id());
////		assert (bookById.isPresent());
////	}
////
////	@Test
////	void salesTest(){
////		Sales savedSales =  salesRepository.save(sales);
////		Optional<Sales> salesById = salesRepository.findById(savedSales.getSales_id());
////		assert (salesById.isPresent());
////	}
////
////	@Test
////	void userTest(){
////		User savedUser = userRepository.save(user);
////		Optional<User> userById = userRepository.findById(savedUser.getUser_id());
////		assert (userById.isPresent());
////	}
//
//
//
//
//
//
//
//	@Test
//	void primaryBookTest1(){
//		PrimaryBook primaryBook = new PrimaryBook();
//		primaryBook.setBookname("java");
//		primaryBook.setGenre("software");
//		primaryBook.setAuthor("linus");
//		primaryBook = primaryBookRepository.save(primaryBook);
//		Optional result = primaryBookRepository.findById(primaryBook.getBook_id());
//		Assertions.assertThat(result.isPresent()).isTrue();
//
//	}
//
//	@Test
//	void primarySalesTest1(){
//		PrimarySales primarySales1 = new PrimarySales();
//		primarySales1.setBook_id(100);
//		primarySales1.setUser_id(1);
//		primarySales1 = primarySalesRepository.save(primarySales1);
//		Optional result = primarySalesRepository.findById(primarySales1.getSales_id());
//		Assertions.assertThat(result.isPresent()).isTrue();
//
//	}
//
//	@Test
//	void primaryUserTest1(){
//		PrimaryUser primaryUser1 = new PrimaryUser();
//		primaryUser1.setUser_name("sourabh");
//		primaryUser1 = primaryUserRepository.save(primaryUser1);
//		Optional result = primarySalesRepository.findById(primaryUser1.getUser_id());
//		Assertions.assertThat(result.isPresent()).isTrue();
//
//	}
//
//
//
//
//	//  SECONDARY DATABASE TESTS :
//
//	@Test
//	void bookTest1(){
//		Book book1 = new Book();
//		book1.setBookname("OS");
//		book1.setGenre("concepts");
//		book1.setAuthor("torvalds");
//		book1 = bookRepository.save(book1);
//		Optional result = primaryBookRepository.findById(book1.getBook_id());
//		Assertions.assertThat(result.isPresent()).isTrue();
//
//	}
//
//	@Test
//	void salesTest1(){
//		Sales sales1 = new Sales();
//		sales1.setBook_id(1729);
//		sales1.setUser_id(17);
//		sales1 = salesRepository.save(sales1);
//		Optional result = primarySalesRepository.findById(sales1.getSales_id());
//		Assertions.assertThat(result.isPresent()).isTrue();
//
//	}
//
//	@Test
//	void userTest1(){
//		User user = new User();
//		user.setUsername("ramanujan");
//		user = userRepository.save(user);
//		Optional result = primarySalesRepository.findById(user.getUser_id());
//		Assertions.assertThat(result.isPresent()).isTrue();
//
//	}
//
//
//}
