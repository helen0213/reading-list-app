package ui.windows;

import ui.AppData;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//a window that displays the reading list
public class ReadingListWindow extends Display {

    private AppData list;

    //EFFECTS: construct a ReadingListWindow in booklist
    public ReadingListWindow(AppData booklist) {
        super();
        list = booklist;
        setBackground(Color.WHITE);
        displayReadingList();
    }

    //draws the reading list
    public void displayReadingList() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("./data/readinglist.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel icon = new JLabel(new ImageIcon(image));
        add(icon);
        add(new JLabel(" "));
        add(new JLabel("Your Reading List"));
        this.add(Box.createVerticalStrut(30));
        String info;
        for (int i = 0; i < list.booksList.getSize(); i++) {
            info = "";
            info += "title:  " + list.booksList.get(i).getTitle() + "  author:  " + list.booksList.get(i).getAuthor()
                    + "  progress:  " + list.booksList.get(i).getReadingProgress() + "%";
            add(new JLabel(info));
            add(new JLabel(" "));
        }
    }
}
