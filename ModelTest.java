package BookStoreTest;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.demo.ModelLayer.Book;

public class ModelTest {

	@Test
	void TestValuesByConstructor() {
			Book book = new Book(101, "spring boot", "manoj");
			assertEquals("spring boot", book.getName());
			assertEquals(101,book.getId());
		
		}

	/*@Test
	void TestValuesByGetterAndSetter() {
		Book book = new Book();
		book.setId(101);
		book.setName("spring");;
		System.out.println("Current info: "+book);
	    assertEquals("Id: 101 Name: spring ",book);	
	}*/
	
	@Test
    public void testGetterSetter() {
        int Id = 101;
        String Name = "Spring Boot";
        Book book = new Book();
        book.setId(101);
        book.setName("Spring Boot");
        Assert.assertEquals(book.getId(), Id);
        Assert.assertEquals(book.getName(), Name);
    }


	}


