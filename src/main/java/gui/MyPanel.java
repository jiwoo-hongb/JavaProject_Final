package gui;


import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    Gui_Design design = new Gui_Design();
    public MyPanel() {
        super();
        setBackground(design.getBackgroundColor());

    }
}
