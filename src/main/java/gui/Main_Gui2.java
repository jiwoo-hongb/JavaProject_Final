package gui;

import data.Data_read2;
import function.TimeTable2;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class Main_Gui2 extends JFrame {
    public Main_Gui2(String[][] timetable) {
        setTitle("추천 과목 리스트");
        setSize(400, 600);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Data_read2 dataReader = new Data_read2();

        // 추천 과목 얻기
        Map<String, List<String>> recommendations = TimeTable2.getRecommendations(timetable, dataReader);

        // 추천 과목 출력
        JTextArea textArea = new JTextArea();
        recommendations.forEach((day, subjects) -> {
            textArea.append(day + "요일 추천 과목: " + subjects + "\n");
        });

        add(new JScrollPane(textArea), BorderLayout.CENTER);
        setVisible(true);
    }
}
