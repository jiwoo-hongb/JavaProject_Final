package function;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.Gui_Design;

import javax.swing.*;

import data.Test_majorDataRead;

public class Click_ActionListener implements ActionListener {
    Gui_Design design = new Gui_Design();
    Test_majorDataRead testMajorDataRead = new Test_majorDataRead();  // CourseSchedule 객체 생성 **

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        btn.setBackground(design.getBtnClickColor());

        // **********************
        // 버튼에 설정된 텍스트(과목명)을 가져옴
        String courseName = btn.getText();

        // CourseSchedule에서 해당 과목의 정보를 가져옴
        String courseDetails = testMajorDataRead.getCourseDetails(courseName);

        // 콘솔에 출력 (GUI에서 보여주려면 JOptionPane 등으로 띄울 수 있음)
        System.out.println(courseDetails);

        // 예: 학점 정보만 보여주는 팝업
        JOptionPane.showMessageDialog(null, courseDetails, courseName + " 정보", JOptionPane.INFORMATION_MESSAGE);
    }

    public void actionPerformed_re(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        btn.setBackground(design.getBtnColor());
        System.out.println(btn.getText() + " 취소");
    }
}
