package gui;

import function.MyButton;
import function.SubjectInfoPopup;
import function.TimeTable2;
import data.Data_read2;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class Main_Gui2 extends JFrame {

    private JComboBox<String> dayComboBox;
    private JList<String> subjectList;
    private Data_read2 dataReader; // Data_read2 참조 추가
    private String[][] timetableArray;
    private Gui_Design design = new Gui_Design();

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
        panel_Background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        panel_Background.setBackground(design.getPanelColor());

        JLabel label = new JLabel("요일 선택: ");
        dayComboBox = new JComboBox<>(new String[]{"월", "화", "수", "목", "금"});
        MyButton showButton = new MyButton("보기");
        label.setForeground(Color.WHITE);

        // 버튼 클릭 이벤트 처리
        showButton.addActionListener(e -> {
            String selectedDay = (String) dayComboBox.getSelectedItem();
            showRecommendations(selectedDay);
        });

        panel_Background.add(label);
        panel_Background.add(dayComboBox);
        panel_Background.add(showButton);
        panel.add(panel_Background);
        add(panel, BorderLayout.NORTH);
    }

    void showCenter() {
        // 추천 과목 영역 패널
        MyPanel subjectPanel = new MyPanel();
        subjectPanel.setLayout(new BorderLayout());

        subjectList = new JList<>();
        subjectList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // 커스터마이즈된 렌더러 설정
        subjectList.setCellRenderer(new CustomListCellRenderer());
        subjectList.setBackground(design.getBackgroundColor()); // 연한 회색 배경

        // 리스트 선택 이벤트 추가
        subjectList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedSubject = subjectList.getSelectedValue();
                if (selectedSubject != null) {
                    showSubjectDetails(selectedSubject);
                }
            }
        });

        JScrollPane scrollPane = new JScrollPane(subjectList);

        subjectPanel.add(scrollPane, BorderLayout.CENTER);
        add(subjectPanel, BorderLayout.CENTER);
    }


    // 추천 과목을 리스트에 표시하는 메서드
    private void showRecommendations(String selectedDay) {
        // 추천 과목 가져오기
        Map<String, List<String>> recommendations = TimeTable2.getRecommendationsRefactored(timetableArray, dataReader);

        // 선택한 요일에 해당하는 과목 리스트 가져오기
        List<String> subjects = recommendations.get(selectedDay);

        if (subjects != null && !subjects.isEmpty()) {
            System.out.println("선택된 요일: " + selectedDay + ", 추천 과목: " + subjects);
            subjectList.setListData(subjects.toArray(new String[0]));
        } else {
            subjectList.setListData(new String[]{"추천 과목이 없습니다."});
        }
    }

    // 선택한 과목의 정보를 표시하는 메서드
    private void showSubjectDetails(String subject) {
        // 과목 정보 가져오기
        Map<String, String[]> detailedInfo = dataReader.getDetailedSubjectInfo();
        String[] info = detailedInfo.get(subject);

        if (info != null) {
            // 팝업으로 과목 정보를 표시
            // SubjectInfoPopup.showSubjectInfo(parent, subjectName, professor, time, location, credits, category)
            SubjectInfoPopup.showSubjectInfo(
                    this,  // 부모 컴포넌트 (Main_Gui2 인스턴스를 전달)
                    subject,  // 교과목 이름
                    info[1],  // 교수 이름
                    info[2],  // 시간
                    info[3],  // 장소
                    info[4],  // 학점
                    info[5]   // 영역
            );
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "해당 과목의 정보를 찾을 수 없습니다.",
                    "오류",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
