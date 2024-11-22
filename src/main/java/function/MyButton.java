package function;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.Gui_Design;
import gui.RoundBtn;

public class MyButton extends RoundBtn {
    //    Click_ActionListener click_ActionListener = new Click_ActionListener(new TimeTable());
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
//                    click_ActionListener.actionPerformed_re(e);
                } else {
//                    click_ActionListener.actionPerformed(e);
                }
                isToggled = !isToggled; // 상태 토글
            }
        });
    }

    //과목 버튼 타이틀 생성 -> 과목이름 / 교수명
    public String setButtonTitle(String title, String professor){
        StringBuilder btnStr = new StringBuilder();
        btnStr.append("<html><style>.title { font-size: 20px; text-align: center } .professor { font-size: 10px; text-align: center; }</style><body><p class='title'>");
        btnStr.append(title);
        btnStr.append("</p><p class='professor'>");
        btnStr.append(professor);
        btnStr.append("</p</body></html>");

        return btnStr.toString();
    }




}
