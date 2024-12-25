package gui;

import function.MyButton;
import function.TimeTable2;
import data.Data_read2;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class Main_Gui2 extends JFrame {

    private JComboBox<String> dayComboBox;
    private JList<String> subjectList;
    private TimeTable2 timetable;
    private Data_read2 dataReader; // Data_read2 참조 추가
    Gui_Design design = new Gui_Design();
    String[][] timetableArray;

    public Main_Gui2(String[][] timetableArray, Data_read2 dataReader) {
        this.dataReader = dataReader;
        this.timetableArray = timetableArray;

        // GUI 초기화
        setTitle("시간표 마법사 💫");
        setSize(355, 770);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        showNorth();
        showCenter();
    }

    void showNorth() {
        // 상단 패널: 요일 선택 콤보박스
        MyPanel panel = new MyPanel();
        RoundPanel panel_Background = new RoundPanel(20);
        panel_Background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        panel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        panel_Background.setBackground(design.getPanelColor());

        JLabel label = new JLabel("요일 선택: ");
        dayComboBox = new JComboBox<>(new String[]{"월", "화", "수", "목", "금"});
        MyButton showButton = new MyButton("보기");

        // 버튼 클릭 이벤트 처리
        showButton.addActionListener(e -> {
            String selectedDay = (String) dayComboBox.getSelectedItem();
            showRecommendations(timetableArray, selectedDay);
        });

        panel_Background.add(label);
        panel_Background.add(dayComboBox);
        panel_Background.add(showButton);
        panel.add(panel_Background);
//        panel.setLayout(new FlowLayout());
        add(panel, BorderLayout.NORTH);
    }

    void showCenter() {
        // 중앙 패널: 추천 과목 표시 영역
        subjectList = new JList<>();
        JScrollPane scrollPane = new JScrollPane(subjectList);
        add(scrollPane, BorderLayout.CENTER);
    }

    // 추천 과목을 리스트에 표시하는 메서드
    private void showRecommendations(String[][] timetableArray, String day) {
        // TimeTable2에서 추천 과목 데이터 가져오기
        Map<String, List<String>> recommendations = TimeTable2.getRecommendations(timetableArray, dataReader);

        // 선택한 요일에 해당하는 추천 과목 가져오기
        List<String> subjects = recommendations.get(day);

        if (subjects != null && !subjects.isEmpty()) {
            subjectList.setListData(subjects.toArray(new String[0]));
        } else {
            subjectList.setListData(new String[]{"추천 과목이 없습니다."});
        }
    }
}
