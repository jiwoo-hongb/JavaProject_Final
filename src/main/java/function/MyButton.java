package function;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.Gui_Design;

public class MyButton extends JButton {
    Click_ActionListener click_ActionListener = new Click_ActionListener(new TimeTable());
    private boolean isToggled = false;

    public MyButton() {
        super();
        initButton();
    }

    public MyButton(String text) {
        super(text);
        initButton();
    }

    private void initButton() {
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isToggled) {
                    click_ActionListener.actionPerformed_re(e);
                } else {
                    click_ActionListener.actionPerformed(e);
                }
                isToggled = !isToggled; // 상태 토글
            }
        });
    }


}
