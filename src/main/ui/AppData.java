package ui;

import model.Book;
import model.ReadingList;
import persistence.Reader;
import persistence.Writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;


//the data stored in the path
public class AppData {

    private static final String BOOKS_FILE = "./data/books.txt";
    public ReadingList booksList;

    //EFFECTS: runs the reading app
    public AppData() {

        //runApp();
        booksList = new ReadingList();
        loadBooks();
    }

    // MODIFIES: this
    // EFFECTS: loads accounts from ACCOUNTS_FILE, if that file exists;
    // otherwise initializes accounts with default values
    public void loadBooks() {
        try {
            List<Book> books = Reader.readBooks(new File(BOOKS_FILE));
            for (Book book : books) {
                booksList.addBook(book);
            }
        } catch (IOException e) {
            init();
        }
    }

    // EFFECTS: saves the reading list to BOOKS_FILE
    public void saveBooks() {
        try {
            Writer writer = new Writer(new File(BOOKS_FILE));
            for (int i = 0; i < booksList.getSize(); i++) {
                writer.write(booksList.get(i));
            }
            writer.close();
            System.out.println("Books saved to file " + BOOKS_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save books to " + BOOKS_FILE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // this is due to a programming error
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes reading list
    private void init() {
    }


}
