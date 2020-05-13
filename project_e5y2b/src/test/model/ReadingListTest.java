package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReadingListTest {
    ReadingList r1;
    Book b1;
    Book b2;
    Book b3;
    Book b4;

    @BeforeEach
    void runBefore(){
        r1 = new ReadingList();
        b1 = new Book("A Book","B","C",100,0,0);
        b2 = new Book("Another Book","D","E",200,0,0);
        b3 = new Book("other Book","F","E",200,0,0);
        b4 = new Book("book","B","C",100,0,0);
        r1.addBook(b1);
    }

    @Test
    void addBookTest(){
        assertEquals(1,r1.getSize());
        assertTrue(r1.contains(b1));
        r1.addBook(b2);
        assertEquals(2,r1.getSize());
        assertTrue(r1.contains(b2));
    }

    @Test
    void removeBookTest(){
        assertEquals(1,r1.getSize());
        assertTrue(r1.contains(b1));
        r1.removeBook(b1);
        assertEquals(0,r1.getSize());
        assertFalse(r1.contains(b1));
    }

    @Test
    void getBookTest(){
        r1.addBook(b2);
        r1.addBook(b3);
        r1.addBook(b4);
        assertEquals(0,r1.getBookByTitle("A Book"));
        assertEquals(1,r1.getBookByTitle("Another Book"));
        assertEquals(2,r1.getBookByAuthor("F"));
        assertEquals(1,r1.getBookByAuthor("D"));
        assertEquals(-10,r1.getBookByAuthor("B"));
    }

    @Test
    void updateProgressTest(){
        r1.updateProgress(0,20,30);
        assertEquals(20,r1.get(0).getCurrentPageNumber());
        assertEquals(30,r1.get(0).getReadingTime());
        assertEquals(20.0,r1.get(0).getReadingProgress());
    }

    @Test
    void toStringTest(){
        assertEquals("A Book by B progress: 0.0%\n",r1.printList());
    }

    @Test
    void getMostInterestedGenreTest(){
        r1.updateProgress(0,40,30);
        r1.addBook(b2);
        r1.updateProgress(1,30,30);
        assertEquals("C",r1.getMostInterestedGenre());
        r1.updateProgress(1,60,30);
        assertEquals("E",r1.getMostInterestedGenre());
        r1.addBook(b3);
        r1.updateProgress(2,50,30);
        assertEquals("E",r1.getMostInterestedGenre());
    }

}

