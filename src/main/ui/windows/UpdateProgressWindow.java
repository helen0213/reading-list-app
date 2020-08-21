package ui.windows;

import ui.AppData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//a window that displays instructions to update reading progress
public class UpdateProgressWindow extends Display implements ActionListener {

    private JLabel title = new JLabel("title");
    private JLabel author = new JLabel("author");
    private JLabel currentPage = new JLabel("current page");
    private JLabel readingTime = new JLabel("reading time");
    private JTextField titleText;
    private JTextField authorText;
    private JTextField currentPageText;
    private JTextField readingTimeText;
    private JButton update = new JButton("update");
    private AppData list;

    //EFFECTS: construct a UpdateProgressWindow in booklist
    public UpdateProgressWindow(AppData booklist) {
        super();
        list = booklist;
        setBackground(Color.WHITE);
        displayUpdateProgressPage();
        update.setActionCommand("update");
        update.addActionListener(this);
    }

    //EFFECTS: draws the page of adding new book
    private void displayUpdateProgressPage() {
        titleText = new JTextField();
        authorText = new JTextField();
        currentPageText = new JTextField();
        readingTimeText = new JTextField();
        add(Box.createVerticalStrut(40));
        add(new JLabel("please enter the information of the book that you want to update"));
        add(Box.createVerticalStrut(40));
        add(title);
        add(titleText);
        add(Box.createVerticalStrut(20));
        add(author);
        add(authorText);
        add(Box.createVerticalStrut(20));
        add(currentPage);
        add(currentPageText);
        add(Box.createVerticalStrut(20));
        add(readingTime);
        add(readingTimeText);
        add(Box.createVerticalStrut(20));
        add(update);
        add(Box.createVerticalStrut(400));
    }

    @Override
    //This is the method that is called when the the JButton btn is clicked
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("update")) {
            String title = titleText.getText();
            String author = authorText.getText();
            int currentPage = Integer.parseInt(currentPageText.getText());
            int readingTime = Integer.parseInt(readingTimeText.getText());
            int titlePosition = list.booksList.getBookByTitle(title);
            int authorPosition = list.booksList.getBookByAuthor(author);
            if (titlePosition >= 0) {
                list.booksList.updateProgress(titlePosition,currentPage,readingTime);
            } else {
                list.booksList.updateProgress(authorPosition, currentPage, readingTime);
            }
        }
    }

}
