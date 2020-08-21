package persistence;

import model.Book;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//a reader that can read reading list data from a file
public class Reader {
    public static final String DELIMITER = ",";

    //constructs a new reader
    public Reader(){
    }

    // EFFECTS: returns the reading list parsed from file; throws
    // IOException if an exception is raised when opening / reading from file
    public static List<Book> readBooks(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    // EFFECTS: returns content of file as a list of strings, each string
    // containing the content of one row of the file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns the reading list parsed from list of strings
    // where each string contains data for one book
    private static List<Book> parseContent(List<String> fileContent) {
        List<Book> readinglist = new ArrayList<>();

        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            readinglist.add(parseBook(lineComponents));
        }

        return readinglist;
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    // REQUIRES: components has size 6 where element 0 represents the
    // title of the book, element 1 represents the author of the book,
    // elements 2 represents the genre, element 3 represents
    // the total page number of the book, element 4 represents
    // the page number that the reader's at and element 5 represents
    // the amount of time that the reader spent on this book
    // EFFECTS: returns the book constructed from components
    private static Book parseBook(List<String> components) {
        String title = components.get(0);
        String author = components.get(1);
        String genre = components.get(2);
        int totalPageNumber = Integer.parseInt(components.get(3));
        int currentPageNumber = Integer.parseInt(components.get(4));
        int readingTime = Integer.parseInt(components.get(5));
        return new Book(title, author, genre, totalPageNumber, currentPageNumber, readingTime);
    }
}
