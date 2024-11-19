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

//        // 버튼 텍스트와 CSV 교과목 비교
//        if (dataTF.isSubjectMatched(buttonText)) {
//            System.out.println(buttonText + "Matched");
//        } else {
//            System.out.println(buttonText + "Unmatched");
//        }
    }

    public void actionPerformed_re(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        btn.setBackground(design.getBtnColor());
        System.out.println(btn.getText() + " 취소");
    }
}
