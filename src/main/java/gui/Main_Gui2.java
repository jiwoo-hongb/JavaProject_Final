package gui;

import function.MyButton;
import function.SubjectInfoPopup;
import function.TimeTable2;
import data.Data_read2;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * Main_Gui2 클래스는 시간표 마법사의 메인 GUI를 구현합니다.
 * 이 클래스는 사용자에게 요일을 선택하고, 해당 요일에 추천된 과목을 표시하며,
 * 선택된 과목의 세부 정보를 팝업으로 보여주는 기능을 제공합니다.
 *
 * <p>이 GUI는 JComboBox를 사용하여 요일을 선택하고, JList를 사용하여 추천 과목을 나열합니다.
 * 각 과목을 선택하면 해당 과목의 세부 정보를 팝업으로 표시합니다.</p>
 *
 * <p><b>사용 예:</b>
 * <pre>
 * String[][] timetable = ...; // 시간표 데이터
 * Data_read2 dataReader = ...; // 과목 정보 읽기 객체
 * Main_Gui2 gui = new Main_Gui2(timetable, dataReader);
 * gui.setVisible(true);
 * </pre>
 * </p>
 */

public class Main_Gui2 extends JFrame {

    /** 요일 선택 콤보박스 */
    private JComboBox<String> dayComboBox;

    /** 추천 과목을 표시할 JList */
    private JList<String> subjectList;

    /** 데이터 읽기 객체 */
    private Data_read2 dataReader;

    /** 시간표 데이터 */
    private String[][] timetableArray;

    /** 디자인 색상 객체 */
    private Gui_Design design = new Gui_Design();

    /**
     * Main_Gui2 클래스의 생성자로, GUI 초기화를 수행합니다.
     *
     * @param timetableArray 시간표 데이터
     * @param dataReader 과목 정보 읽기 객체
     */
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

    /**
     * 상단 패널을 구성하는 메서드입니다.
     * 요일 선택 콤보박스와 '보기' 버튼을 배치합니다.
     */
    void showNorth() {
        // 상단 패널: 요일 선택 콤보박스
        MyPanel panel = new MyPanel();
        RoundPanel panel_Background = new RoundPanel(20);
        panel_Background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
        panel_Background.setBackground(design.getPanelColor());

        JLabel label = new JLabel("요일: ");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Pretendard", Font.BOLD, 20));
        label.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));

        dayComboBox = new JComboBox<>(new String[]{"월", "화", "수", "목", "금"});
        dayComboBox.setFont(new Font("Pretendard", Font.PLAIN, 18));
        dayComboBox.setRenderer(new CustomComboBoxRenderer());
        dayComboBox.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1)); // 테두리 설정

        MyButton showButton = new MyButton("보기");
        showButton.setFont(new Font("Pretendard", Font.BOLD, 20));
        showButton.setForeground(Color.WHITE);
        showButton.setBackground(design.getBtnColor());

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

    /**
     * 중앙 패널을 구성하는 메서드입니다.
     * 추천 과목 목록을 표시하는 JList와 JScrollPane을 배치합니다.
     */
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

    /**
     * 선택된 요일에 대해 추천 과목을 JList에 표시하는 메서드입니다.
     *
     * @param selectedDay 선택된 요일
     */
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

    /**
     * 선택된 과목의 세부 정보를 팝업으로 표시하는 메서드입니다.
     *
     * @param subject 선택된 과목
     */
    private void showSubjectDetails(String subject) {
        // 과목 정보 가져오기
        Map<String, String[]> detailedInfo = dataReader.getDetailedSubjectInfo();
        String[] info = detailedInfo.get(subject);

        if (info != null) {
            // 팝업으로 과목 정보를 표시
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
