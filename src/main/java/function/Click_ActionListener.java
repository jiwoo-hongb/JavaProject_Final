package function;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.Gui_Design;

import data.Data_read;
import javax.swing.*;

public class Click_ActionListener implements ActionListener {
    Gui_Design design = new Gui_Design();
    Data_read data = new Data_read();
    Data_TF dataTF = new Data_TF();
    JFrame currentFrame; // 현재 프레임을 저장하는 변수

    TimeTable timeTable;


    public Click_ActionListener(TimeTable timeTable) {
        this.timeTable = timeTable;
    }

    //timetable에 과목 추가
    public void actionPerformed(ActionEvent e) {
//        MyButton btn = (MyButton) e.getSource();
        JButton btn = (JButton) e.getSource();
        btn.setBackground(design.getBtnClickColor());

        Document doc = Jsoup.parse(btn.getText());

        String subject = doc.selectFirst(".title").text();
//        String subject = btn.getText();
        System.out.println(btn.getText());

        // 시간표에 과목 추가
        if (timeTable.addSubjectToTimetable(subject)) {
            System.out.println(subject + " added to the timetable.");
        } else {
            System.out.println(subject + " could not be added (conflict or not found).");
        }

        timeTable.printTimetable();

    }

    //기존 timetable에서 과목 제거
    public void actionPerformed_re(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        btn.setBackground(design.getBtnColor()); // 버튼 색상 원래대로 변경

        Document doc = Jsoup.parse(btn.getText());

        String subject = doc.selectFirst(".title").text();

        //String subject = btn.getText(); // 클릭된 버튼의 텍스트 (과목 이름)

        // 시간표에서 과목 제거
        if (timeTable.removeSubjectFromTimetable(subject)) {
            System.out.println(subject + " removed from the timetable.");
        } else {
            System.out.println(subject + " could not be removed (not found in timetable).");
        }
        timeTable.printTimetable();
    }

}