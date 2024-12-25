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

    public Main_Gui2(String[][] timetableArray, Data_read2 dataReader) {
        this.dataReader = dataReader;

        // GUI 초기화
        setTitle("교양 추천 과목");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 상단 패널: 요일 선택 콤보박스
        MyPanel topPanel = new MyPanel();
        topPanel.setLayout(new FlowLayout());

        JLabel label = new JLabel("요일 선택: ");
        dayComboBox = new JComboBox<>(new String[]{"월", "화", "수", "목", "금"});
        MyButton showButton = new MyButton("추천 과목 보기");

        topPanel.add(label);
        topPanel.add(dayComboBox);
        topPanel.add(showButton);
        add(topPanel, BorderLayout.NORTH);

        // 중앙 패널: 추천 과목 표시 영역
        subjectList = new JList<>();
        JScrollPane scrollPane = new JScrollPane(subjectList);
        add(scrollPane, BorderLayout.CENTER);

        // 하단 패널: 이전 화면으로 돌아가는 버튼
        MyPanel bottomPanel = new MyPanel();
        bottomPanel.setLayout(new FlowLayout());
        MyButton backButton = new MyButton("이전 화면으로");
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // 버튼 클릭 이벤트 처리
        showButton.addActionListener(e -> {
            String selectedDay = (String) dayComboBox.getSelectedItem();
            showRecommendations(timetableArray, selectedDay);
        });

        // 이전 화면으로 돌아가는 버튼 클릭 이벤트
        backButton.addActionListener(e -> {
            setVisible(false);
            new Main_Gui().setVisible(true); // Main_Gui 화면 표시
        });
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
