package gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import function.TimeTable;

public class Main_Gui2 extends JFrame {
    private TimeTable timeTable; // 전달받은 TimeTable 객체를 저장

    public Main_Gui2(TimeTable timeTable) {
        this.timeTable = timeTable; // TimeTable 객체 저장
        setTitle("시간표 마법사 - 현재 시간표");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // UI 초기화
        initializeUI();
    }

    private void initializeUI() {
        // 타이틀
        JLabel title = new JLabel("현재 시간표", SwingConstants.CENTER);
        title.setFont(new Font("Pretendard", Font.BOLD, 24));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(title, BorderLayout.NORTH);

        // 시간표 데이터를 테이블로 표시
        JTable timetableTable = createTimetableTable();
        JScrollPane scrollPane = new JScrollPane(timetableTable);
        add(scrollPane, BorderLayout.CENTER);

        // 하단에 돌아가기 버튼 추가
        JButton backButton = new JButton("이전으로");
        backButton.setFont(new Font("Pretendard", Font.BOLD, 18));
        backButton.addActionListener(e -> {
            setVisible(false); // 현재 프레임 닫기
            new Main_Gui().setVisible(true); // 이전 화면(Main_Gui) 열기
        });
        add(backButton, BorderLayout.SOUTH);
    }

    private JTable createTimetableTable() {
        // 테이블의 컬럼명 설정
        String[] columnNames = {"요일", "1교시", "2교시", "3교시", "4교시", "5교시", "6교시", "7교시", "8교시", "9교시"};

        // 요일 데이터와 시간표 데이터를 조합
        String[][] data = new String[5][10];
        for (int i = 0; i < 5; i++) {
            data[i][0] = dayIndexToString(i); // 요일
            for (int j = 0; j < 9; j++) {
                data[i][j + 1] = timeTable.getTimetable()[i][j] == null ? "" : timeTable.getTimetable()[i][j];
            }
        }

        // JTable 생성
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        table.setFont(new Font("Pretendard", Font.PLAIN, 14));
        table.setRowHeight(30);
        return table;
    }

    // 인덱스 -> 요일 문자열 변환
    private String dayIndexToString(int dayIndex) {
        switch (dayIndex) {
            case 0: return "월";
            case 1: return "화";
            case 2: return "수";
            case 3: return "목";
            case 4: return "금";
            default: return "";
        }
    }
}
