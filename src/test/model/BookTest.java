package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book b1;

    @BeforeEach
    void runBefore(){
        b1 = new Book("A Book","B","C",100,0,0);
    }

    @Test
    void getterTest(){
        assertEquals("A Book", b1.getTitle());
        assertEquals("B",b1.getAuthor());
        assertEquals("C",b1.getGenre());
        assertEquals(100,b1.getTotalPageNumber());
        assertEquals(0,b1.getCurrentPageNumber());
        assertEquals(0,b1.getReadingProgress());
        assertEquals(0,b1.getReadingTime());
    }

    @Test
    void updateReadingProgressTest(){
        b1.updateReadingProgress(20,40);
        assertEquals(20,b1.getCurrentPageNumber());
        assertEquals(40,b1.getReadingTime());
        assertEquals(20.0,b1.getReadingProgress());
    }

}