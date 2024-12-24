package gui;

import data.Data_read2;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import function.TimeTable2;

public class Main_Gui2 extends JFrame {
    private String[][] timetable;
    private Data_read2 dataReader;

    public Main_Gui2(String[][] timetable) {
        this.timetable = timetable;
        this.dataReader = new Data_read2(); // CSV 데이터 읽기

        // JFrame 설정
        setTitle("TimeTable 처리");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 요일별 추천 리스트 처리
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        // 요일별 리스트 생성 및 데이터 추가
        List<String> mondayList = TimeTable2.getEmptySlotsAndFill(timetable, dataReader, "월");
        List<String> tuesdayList = TimeTable2.getEmptySlotsAndFill(timetable, dataReader, "화");
        List<String> wednesdayList = TimeTable2.getEmptySlotsAndFill(timetable, dataReader, "수");
        List<String> thursdayList = TimeTable2.getEmptySlotsAndFill(timetable, dataReader, "목");
        List<String> fridayList = TimeTable2.getEmptySlotsAndFill(timetable, dataReader, "금");

        // 추천 시간표 출력
        StringBuilder sb = new StringBuilder();
        sb.append("요일별 추천 과목:\n");
        sb.append("월요일: ").append(mondayList).append("\n");
        sb.append("화요일: ").append(tuesdayList).append("\n");
        sb.append("수요일: ").append(wednesdayList).append("\n");
        sb.append("목요일: ").append(thursdayList).append("\n");
        sb.append("금요일: ").append(fridayList).append("\n");

        resultArea.setText(sb.toString());
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
    }
}
