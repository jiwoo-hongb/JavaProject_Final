package function;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MyButton extends JButton {
    Click_ActionListener click_ActionListener = new Click_ActionListener();
    public MyButton() {
        super();
        addActionListener(click_ActionListener);
    }

    public MyButton(String text) {
        super(text);
        addActionListener(click_ActionListener);
    }
}
