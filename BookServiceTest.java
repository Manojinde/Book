package BookStoreTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.example.demo.ModelLayer.Book;
import com.example.demo.RepositoryLayer.Repo;
import com.example.demo.ServiceLayer.BookService;

@SpringBootTest
public class BookServiceTest {
	
	@Mock
	Repo repo;
	
	@InjectMocks
	BookService bookService;
	
        @Test
	  	public void getBookTest() throws Exception {
	  		
	  		Repo repo = mock(Repo.class);
	  		List<Book> p = new ArrayList<>(); 
	  		p.add(new Book(101,"Spring Boot", "Manoj"));
	  		
	  		when(repo.findAll()).thenReturn(p);
	  		BookService bookService = new BookService(repo);

	  		List<Book> result = bookService.getBook();
	  		AssertJUnit.assertEquals(p, result);	
	  		
	  	}
	  	
	  	
	  	@Test
	  	public void updatebookTest() throws Exception {
	     Repo repo = mock(Repo.class);
	  	  BookService bookService = new BookService(repo);
	  	  when(repo.findById(101)).thenReturn(Optional.of(new Book(101,"Spring Boot","Manoj")));
	  	 // when(repo.save(null)).thenReturn("book updated successfully!!!....");
	  	  String result = bookService.updatebook(101, new Book(101,"Spring Boot","Manoj"));
	  	  Assert.assertEquals("book updated successfully!!!.... ",result);
	  	
	  	
	  	}
	  	@Test
	  	public void deletebookTest() throws Exception {
	  	  Repo repo = mock(Repo.class);
	      when(repo.findById(101)).thenReturn((Optional.of(new Book(101,"Spring Boot","Manoj"))));
	  	  BookService bookService = new BookService(repo);
	  	  String result = bookService.deletebook(101);
	  	  Assert.assertEquals("book deleted id no.",result);
	  		
	  		
	  	
	  	
	  	
	  	
	  	
	  	  
  }
}
