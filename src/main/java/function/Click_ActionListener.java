package function;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.Gui_Design;

import javax.swing.*;

public class Click_ActionListener implements ActionListener {
    Gui_Design design = new Gui_Design();
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        btn.setBackground(design.getBtnClickColor());
        System.out.println(btn.getText());
    }

    public void actionPerformed_re(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        btn.setBackground(design.getBtnColor());
        System.out.println(btn.getText() + " 취소");
    }
}
