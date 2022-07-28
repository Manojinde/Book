package BookStoreTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.example.demo.ControllerLayer.BookController;
import com.example.demo.ModelLayer.Book;
import com.example.demo.ServiceLayer.BookService;


public class ControllerTest {
	
	@Test
	public void getBookTest() throws Exception {
		BookService bookService = mock(BookService.class);
		BookController controller = new BookController(bookService); 
		List<Book> list = new ArrayList<Book>();
		list.add(new Book(101,"Spring Boot","Manoj"));
		when(bookService.getBook()).thenReturn(list);
		assertEquals(list,controller.getBook());		
	}
	
	@Test
	void updatebookTest() throws Exception{
		BookService bookService = mock(BookService.class);
		BookController controller = new BookController(bookService); 
		Book book = new Book(101,"spring boot","manoj");
		when(bookService.updatebook(101, book)).thenReturn("book updated");
		String result = controller.updatebook( 101, book);
		assertEquals("book updated", result);
		
	}

	@Test
	void deletebookTest() throws Exception{
		BookService bookService = mock(BookService.class);
		BookController controller = new BookController(bookService); 
		when(bookService.deletebook( 101)).thenReturn("book deleted");
		String result = controller.deletebook( 101);
		assertEquals("book deleted",result );
		
		
	}





}
