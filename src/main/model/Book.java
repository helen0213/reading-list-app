package model;


import persistence.Reader;
import persistence.Saveable;

import java.io.PrintWriter;

//represents a book with title, author, total page number, the page number that the reader's at, the time that
//the reader spent
public class Book implements Saveable {
    private String title;                  //the title of the book
    private String author;                 //the author of the book
    private String genre;                  //the genre of the book
    private int totalPageNumber;           //the number of pages the book has
    private int currentPageNumber;         //the page number that the reader's at
    private int readingTime;               //the total time the reader spent on the book in minutes
    private double readingProgress;        //a percentage indicates how much of the book has been read

    //REQUIRES: title and author has non-zero length and totalPageNumber has to be > 0
    //EFFECTS: set the title to title, author to author, and totalPageNumber to totalPageNumber
    //         set currentPageNumber and readingTime to 0
    public Book(String title, String author, String genre, int totalPageNumber, int currentPageNumber, int time) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.totalPageNumber = totalPageNumber;
        this.currentPageNumber = currentPageNumber;
        this.readingTime = time;
        this.readingProgress = this.currentPageNumber * 100 / this.totalPageNumber;
    }

    //EFFECTS:returns the title of the book
    public String getTitle() {
        return title;
    }

    //EFFECTS:returns the author of the book
    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    //EFFECTS:returns the current page number that the reader's at
    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    //REQUIRES: currentPageNumber > 0 && time > 0
    //MODIFIES: this.currentPageNumber && this.readingProgress
    //EFFECTS: Update the current page number that the reader's at and add the time used to the total reading
    //         time. Also update the readingProgress.
    public void updateReadingProgress(int currentPageNumber, int time) {
        this.currentPageNumber = currentPageNumber;
        this.readingTime += time;
        this.readingProgress = this.currentPageNumber * 100 / this.totalPageNumber;
    }

    //EFFECTS: returns the total reading time on the book
    public int getReadingTime() {
        return readingTime;
    }

    //EFFECTS: returns the current reading progress on the book
    public double getReadingProgress() {
        return this.readingProgress;
    }

    //EFFECTS: returns the number of pages that the book has
    public int getTotalPageNumber() {
        return totalPageNumber;
    }

    @Override
    //EFFECTS: saves the book
    public void save(PrintWriter printWriter) {
        printWriter.print(title);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(author);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(genre);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(totalPageNumber);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(currentPageNumber);
        printWriter.print(Reader.DELIMITER);
        printWriter.println(readingTime);
    }
}
