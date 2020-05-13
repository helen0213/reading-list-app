package persistence;

import model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class WriterTest {
    private static final String TEST_FILE = "./data/testBooks.txt";
    private Writer testWriter;
    private Book book1;
    private Book book2;

    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        testWriter = new Writer(new File(TEST_FILE));
        book1 = new Book("a","b","c",100,20,20);
        book2 = new Book("aa","bb","cc",200,30,25);

    }

    @Test
    void testWriteBooks(){
        testWriter.write(book1);
        testWriter.write(book2);
        testWriter.close();

        try {
            List<Book> books = Reader.readBooks(new File(TEST_FILE));
            Book book1 = books.get(0);
            assertEquals("a",book1.getTitle());
            assertEquals("b",book1.getAuthor());
            assertEquals("c",book1.getGenre());
            assertEquals(100,book1.getTotalPageNumber());
            assertEquals(20,book1.getCurrentPageNumber());
            assertEquals(20,book1.getReadingTime());

            Book book2 = books.get(1);
            assertEquals("aa",book2.getTitle());
            assertEquals("bb",book2.getAuthor());
            assertEquals("cc",book2.getGenre());
            assertEquals(200,book2.getTotalPageNumber());
            assertEquals(30,book2.getCurrentPageNumber());
            assertEquals(25,book2.getReadingTime());
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }
}
