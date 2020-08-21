package ui.windows;

import model.Book;
import ui.AppData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//a window that displays instructions to add a book
public class NewBookWindow extends Display implements ActionListener {

    private JLabel title = new JLabel("title");
    private JLabel author = new JLabel("author");
    private JLabel genre = new JLabel("genre");
    private JLabel totalPageNumber = new JLabel("page number");
    private JLabel currentPage = new JLabel("current page");
    private JLabel readingTime = new JLabel("reading time");
    private JTextField titleText;
    private JTextField authorText;
    private JTextField genreText;
    private JTextField totalPageNumberText;
    private JTextField currentPageText;
    private JTextField readingTimeText;
    private JButton add = new JButton("add");
    private AppData list;


    //EFFECTS: construct a NewBookWindow in booklist
    public NewBookWindow(AppData booklist) {
        super();
        list = booklist;
        setBackground(Color.WHITE);
        displayNewBookPage();
        add.setActionCommand("add");
        add.addActionListener(this);
    }

    //EFFECTS: draws the page of adding new book
    protected void displayNewBookPage() {
        init();
        add(Box.createVerticalStrut(40));
        add(new JLabel("please enter the information of the book"));
        add(Box.createVerticalStrut(20));
        add(title);
        add(titleText);
        add(Box.createVerticalStrut(20));
        add(author);
        add(authorText);
        add(Box.createVerticalStrut(20));
        add(genre);
        add(genreText);
        add(Box.createVerticalStrut(20));
        add(totalPageNumber);
        add(totalPageNumberText);
        add(Box.createVerticalStrut(20));
        add(currentPage);
        add(currentPageText);
        add(Box.createVerticalStrut(20));
        add(readingTime);
        add(readingTimeText);
        add(add);
        add(Box.createVerticalStrut(400));
    }

    //MODIFIES: this
    //EFFECTS: initialize fields
    protected void init() {
        titleText = new JTextField();
        authorText = new JTextField();
        genreText = new JTextField();
        totalPageNumberText = new JTextField();
        currentPageText = new JTextField();
        readingTimeText = new JTextField();
    }


    @Override
    //This is the method that is called when the the JButton btn is clicked
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("add")) {
            String title = titleText.getText();
            String author = authorText.getText();
            String genre = genreText.getText();
            int totalPageNumber = Integer.parseInt(totalPageNumberText.getText());
            int currentPage = Integer.parseInt(currentPageText.getText());
            int readingTime = Integer.parseInt(readingTimeText.getText());
            list.booksList.addBook(new Book(title,author,genre,totalPageNumber,currentPage,readingTime));
        }
    }

}
