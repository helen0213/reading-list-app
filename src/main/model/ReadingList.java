package model;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

// a reading list
public class ReadingList {
    private List<Book> readingList;

    //EFFECTS: contructs an empty reading list
    public ReadingList() {
        this.readingList = new LinkedList<>();
    }

    //EFFECTS: add a book to the reading list
    public void addBook(Book b) {
        this.readingList.add(b);
    }

    //EFFECTS: remove a book from the list
    public void removeBook(Book b) {
        this.readingList.remove(b);
    }

    //EFFECTS: returns the size of the readinglist
    public int getSize() {
        return this.readingList.size();
    }

    //REQUIRES: i >= 0
    //EFFECTS: returns the book at the given index in the readinglist
    public Book get(int i) {
        return readingList.get(i);
    }

    //EFFECTS: return true if b is in the readinglist
    public boolean contains(Book b) {
        return readingList.contains(b);
    }

    //REQUIRES: title has to have a length greater than zero
    //EFFECTS: if a book with the given title is in the list, return the position of the book
    //         otherwise return -1
    public int getBookByTitle(String title) {
        int position = -1;
        for (int i = 0; i < this.readingList.size(); i++) {
            if (title.equals(this.readingList.get(i).getTitle())) {
                position = i;
            }
        }
        return position;
    }

    //REQUIRES: author has to have a length greater than zero
    //EFFECTS: if a book with the given author is in the list, return the position of the book
    //         otherwise return -1
    public int getBookByAuthor(String author) {
        int position = -1;
        int occurence = 0;
        for (int i = 0; i < this.readingList.size(); i++) {
            if (author.equals(this.readingList.get(i).getAuthor())) {
                position = i;
                occurence++;
            }
        }
        if (occurence < 2) {
            return position;
        }
        return -10;
    }

    //REQUIRES: position >= 0, currentPageNumber > 0, time > 0
    //MODIFIES: the currentPageNumber and readingTime of the book at the given position
    //EFFECTS: update the reading progress of the book at given position
    public void updateProgress(int position, int currentPageNumber, int time) {
        this.readingList.get(position).updateReadingProgress(currentPageNumber, time);
    }

    //EFFECTS:return a String representing the reading list
    public String printList() {
        StringBuilder booklist = new StringBuilder();
        for (Book book : this.readingList) {
            booklist.append(book.getTitle()).append(" by ").append(book.getAuthor()).append(" ")
                    .append("progress: ").append(book.getReadingProgress()).append("%").append("\n");
        }
        return booklist.toString();
    }

    //EFFECTS: returns the genre that the reader's most interested in(based on number of pages read)
    public String getMostInterestedGenre() {
        String pickedGenre = "You haven't read any books yet";
        String previousGenre = "";
        int previousPageCount = 0;
        int pageCount = 0;
        for (Book book : this.readingList) {
            if (!pickedGenre.equals(book.getGenre())) {
                if (pageCount > previousPageCount) {
                    previousGenre = pickedGenre;
                    previousPageCount = pageCount;
                }
                pickedGenre = book.getGenre();
            }
            pageCount = book.getCurrentPageNumber();
        }
        if (previousPageCount > pageCount) {
            return previousGenre;
        }
        return pickedGenre;
    }

}
