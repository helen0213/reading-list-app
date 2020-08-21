package ui.windows;

import ui.AppData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//a window that displays instructions to delete a book
public class DeleteWindow extends Display implements ActionListener {

    private JLabel title = new JLabel("title");
    private JLabel author = new JLabel("author");
    private JTextField titleText;
    private JTextField authorText;
    private JButton delete = new JButton("delete");
    private AppData list;

    //EFFECTS: construct a new DeleteWindow in booklist
    public DeleteWindow(AppData booklist) {
        super();
        list = booklist;
        setBackground(Color.WHITE);
        displayDeletePage();
        delete.setActionCommand("delete");
        delete.addActionListener(this);
    }

    //EFFECTS: draws the page of deleting a book
    private void displayDeletePage() {
        titleText = new JTextField();
        authorText = new JTextField();
        add(Box.createVerticalStrut(40));
        add(new JLabel("Please enter the title and author of the book you want to delete"));
        add(Box.createVerticalStrut(40));
        add(title);
        add(titleText);
        add(Box.createVerticalStrut(20));
        add(author);
        add(authorText);
        add(Box.createVerticalStrut(20));
        add(delete);
        add(Box.createVerticalStrut(600));
    }

    @Override
    //This is the method that is called when the the JButton btn is clicked
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("delete")) {
            String title = titleText.getText();
            String author = authorText.getText();
            list.booksList.removeBook(list.booksList.get(list.booksList.getBookByTitle(title)));
        }
    }
}
