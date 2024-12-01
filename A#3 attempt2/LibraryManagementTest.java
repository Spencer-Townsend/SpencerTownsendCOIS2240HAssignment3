import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class LibraryManagementTest {


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
}

