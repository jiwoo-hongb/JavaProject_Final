package function;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.Gui_Design;

import data.Data_read;

import javax.swing.*;

public class Click_ActionListener implements ActionListener {
    Gui_Design design = new Gui_Design();
    Data_read data = new Data_read();
    Data_TF dataTF = new Data_TF();

    TimeTable timeTable;

    public Click_ActionListener(TimeTable timeTable) {
        this.timeTable = timeTable;
    }

    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        btn.setBackground(design.getBtnClickColor());

        String subject = btn.getText();
        System.out.println(btn.getText());

        // 시간표에 과목 추가
        if (timeTable.addSubjectToTimetable(subject)) {
            System.out.println(subject + " added to the timetable.");
        } else {
            System.out.println(subject + " could not be added (conflict or not found).");
        }

        timeTable.printTimetable();

    }

    public void actionPerformed_re(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        btn.setBackground(design.getBtnColor()); // 버튼 색상 원래대로 변경

        String subject = btn.getText(); // 클릭된 버튼의 텍스트 (과목 이름)

        // 시간표에서 과목 제거
        if (timeTable.removeSubjectFromTimetable(subject)) {
            System.out.println(subject + " removed from the timetable.");
        } else {
            System.out.println(subject + " could not be removed (not found in timetable).");
        }
    }
}
