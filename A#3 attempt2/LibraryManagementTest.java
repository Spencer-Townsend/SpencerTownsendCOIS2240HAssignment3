import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertFalse;
import java.lang.reflect.Constructor;

import org.junit.Test;

public class LibraryManagementTest {
    
    Transaction transaction = Transaction.getTransaction();
    @Test
    public void testMain() {

    //todo add testing
    }

    @Test
    public void testBookIsValid() throws Exception
    {
        Book validEdgeBook1 = new Book(100, "Valid1");
        Book validEdgeBook2 = new Book(999, "Valid2");
        assertThrows(Exception.class, () -> new Book(0, "testBook1"));//found this style online, should check to see if this would throw an exception(it)
        assertThrows(Exception.class, () -> new Book(1000, "testBook2"));
        assertThrows(Exception.class, () -> new Book(5000, "testBook3"));
        assertEquals(new Book(100, "Valid1").getId(), validEdgeBook1.getId());
        assertEquals(new Book(999,"Valid2").getId(), validEdgeBook2.getId());
    }

    @Test
    public void testLibraryMangment()
    {
        try
        {
        Book book = new Book(100, "book");
        Member person = new Member(1,"person");
        assertEquals(true, book.isAvailable());
        transaction.borrowBook(book, person);
        assertEquals(false, book.isAvailable());
        assertFalse(transaction.borrowBook(book, person));
        assertEquals(true, transaction.returnBook(book, person));
        assertFalse(transaction.returnBook(book, person));
        }
        catch(Exception e)
        {}
    }

    @Test
    public void testsingletonTransaction()
    {
        try {
            Constructor<Transaction> constructor = Transaction.class.getDeclaredConstructor();
            assertEquals(2,constructor.getModifiers());//this means the constructor is private

        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
}

