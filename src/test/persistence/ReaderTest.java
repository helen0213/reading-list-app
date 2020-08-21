package persistence;

import model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ReaderTest {
    private Reader testReader;

    @BeforeEach
    void runBefore(){
        testReader = new Reader();
    }

    @Test
    void testParseBookFile1(){
        try {
            List<Book> books = Reader.readBooks(new File("./data/testBookFile1.txt"));
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

    @Test
    void testParseBookFile2(){
        try {
            List<Book> books = Reader.readBooks(new File("./data/testBookFile2.txt"));

            Book book1 = books.get(0);
            assertEquals("q",book1.getTitle());
            assertEquals("w",book1.getAuthor());
            assertEquals("e",book1.getGenre());
            assertEquals(1000,book1.getTotalPageNumber());
            assertEquals(200,book1.getCurrentPageNumber());
            assertEquals(200,book1.getReadingTime());

            Book book2 = books.get(1);
            assertEquals("qq",book2.getTitle());
            assertEquals("ww",book2.getAuthor());
            assertEquals("ee",book2.getGenre());
            assertEquals(2000,book2.getTotalPageNumber());
            assertEquals(300,book2.getCurrentPageNumber());
            assertEquals(250,book2.getReadingTime());
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testIOException() {
        try {
            Reader.readBooks(new File("./path/does/not/exist/testBooks.txt"));
        } catch (IOException e) {
            // expected
        }
    }
}
