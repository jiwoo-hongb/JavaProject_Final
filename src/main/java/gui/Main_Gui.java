package gui;

import data.Data_read2;
import function.MyButton;
import javax.swing.*;
import java.awt.*;
import function.MyButton;
import function.TimeTable;
import function.TimeTable2;

/**
 * Main_Gui는 시간표 마법사 애플리케이션의 주요 그래픽 사용자 인터페이스입니다.
 * 패널, 버튼, 라벨 등 GUI 구성 요소를 초기화하며, 애플리케이션의 다른 부분으로 이동할 수 있는 기능을 제공합니다.
 *  * Main_Gui는 시간표 마법사 애플리케이션의 메인 JFrame입니다.
 */

public class Main_Gui extends JFrame {
    private Gui_Design design = new Gui_Design();
    private MyButton myBtn = new MyButton();

    /**
     * Main_Gui 프레임을 생성합니다.
     * 프레임 속성을 설정하고 GUI 레이아웃을 초기화합니다.
     */
    public Main_Gui() {
        setTitle("시간표 마법사 🌟");
        setSize(355, 770);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        showNorth();
        showCenter();
        showSouth();

        setVisible(true);
    }

    /**
     * GUI의 상단(North) 섹션을 생성하고 표시합니다.
     * 이 섹션에는 헤더와 학점 정보가 포함됩니다.
     */
    private void showNorth() {
        MyPanel panel = new MyPanel();
        RoundPanel panel_Background_Color = new RoundPanel(20); // 배경 색상 패널
        panel_Background_Color.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        panel_Background_Color.setBackground(design.getPanelColor());

        JLabel credit = new JLabel("학점 : 18학점");
        credit.setBounds(12, 20, 367, 40);
        credit.setBorder(BorderFactory.createEmptyBorder(0, 75, 0, 75));
        credit.setFont(new Font("Pretendard", Font.BOLD, 24));
        credit.setForeground(Color.WHITE);

        panel_Background_Color.add(credit);
        panel.add(panel_Background_Color);

        add(panel, BorderLayout.NORTH);
    }

    /**
     * 버튼의 스타일과 속성을 설정합니다.
     *
     * @param button 스타일이 설정될 버튼.
     */
    private void setupButton(MyButton button) {
        button.setBackground(design.getBtnColor());
        button.setAlignmentX(Component.LEFT_ALIGNMENT); // 왼쪽 정렬
    }

    /**
     * GUI의 중앙(main content) 섹션을 생성하고 표시합니다.
     * 이 섹션에는 전공 및 교양 과목 버튼이 포함됩니다.
     */
    private void showCenter() {
        MyPanel panel1 = new MyPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JLabel major = new JLabel("전공");
        major.setFont(new Font("Pretendard", Font.BOLD, 26));
        major.setForeground(Color.WHITE);
        major.setAlignmentX(Component.LEFT_ALIGNMENT);

        RoundPanel panel2 = new RoundPanel(15);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel2.setBackground(design.getPanelColor());
        panel2.setBorder(BorderFactory.createEmptyBorder(3, 10, 3, 10));

        // 전공 과목 버튼
        String javaText = myBtn.setButtonTitle("JAVA프로그래밍2", "남수만");
        MyButton btn_Java = new MyButton(javaText);
        btn_Java.setFont(new Font("Pretendard", Font.BOLD, 0));
        setupButton(btn_Java);

        String guiText = myBtn.setButtonTitle("GUI프로그래밍", "우선미");
        MyButton btn_GUI = new MyButton(guiText);
        btn_GUI.setFont(new Font("Pretendard", Font.BOLD, 24));
        setupButton(btn_GUI);

        String algorithmText = myBtn.setButtonTitle("알고리즘설계", "최미경");
        MyButton btn_Algorithem = new MyButton(algorithmText);
        btn_Algorithem.setFont(new Font("Pretendard", Font.BOLD, 24));
        setupButton(btn_Algorithem);

        String bigDataText = myBtn.setButtonTitle("빅데이터처리", "송재숙");
        MyButton btn_BigData = new MyButton(bigDataText);
        btn_BigData.setFont(new Font("Pretendard", Font.BOLD, 24));
        setupButton(btn_BigData);

        String osText = myBtn.setButtonTitle("운영체제", "송재숙");
        MyButton btn_OS = new MyButton(osText);
        btn_OS.setFont(new Font("Pretendard", Font.BOLD, 24));
        setupButton(btn_OS);

        // 버튼을 panel2에 추가
        panel2.add(Box.createVerticalStrut(15));
        panel2.add(btn_Java);
        panel2.add(Box.createVerticalStrut(15));
        panel2.add(btn_GUI);
        panel2.add(Box.createVerticalStrut(15));
        panel2.add(btn_Algorithem);
        panel2.add(Box.createVerticalStrut(15));
        panel2.add(btn_BigData);
        panel2.add(Box.createVerticalStrut(15));
        panel2.add(btn_OS);
        panel2.add(Box.createVerticalStrut(15));

        RoundPanel panel3 = new RoundPanel(15);
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel3.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel3.setBackground(design.getPanelColor());
        panel3.setBorder(BorderFactory.createEmptyBorder(3, 10, 3, 10));

        JLabel culture = new JLabel("교양 필수");
        culture.setFont(new Font("Pretendard", Font.BOLD, 26));
        culture.setForeground(Color.WHITE);
        culture.setAlignmentX(Component.LEFT_ALIGNMENT);

        String english3Text = myBtn.setButtonTitle("English3", "boris");
        MyButton btn_English3 = new MyButton(english3Text);
        btn_English3.setFont(new Font("Pretendard", Font.BOLD, 24));
        setupButton(btn_English3);

        // 버튼을 panel3에 추가
        panel3.add(Box.createVerticalStrut(10));
        panel3.add(btn_English3);
        panel3.add(Box.createVerticalStrut(10));

        // panel1에 구성 요소 추가
        panel1.add(Box.createVerticalStrut(10));
        panel1.add(major);
        panel1.add(Box.createVerticalStrut(10));
        panel1.add(panel2);
        panel1.add(Box.createVerticalStrut(20));
        panel1.add(culture);
        panel1.add(Box.createVerticalStrut(10));
        panel1.add(panel3);

        add(panel1, BorderLayout.CENTER);
    }

    /**
     * GUI의 하단(South) 섹션을 생성하고 표시합니다.
     * 이 섹션에는 네비게이션 버튼이 포함됩니다.
     */
    private void showSouth() {
        MyPanel panel = new MyPanel();
        MyButton btn_next = new MyButton("\u25B7");
        btn_next.setFont(new Font("Pretendard", Font.BOLD, 24));
        btn_next.setBackground(design.getPanelColor());
        btn_next.setAlignmentX(Component.LEFT_ALIGNMENT);
        btn_next.setForeground(Color.WHITE);

        // 다음 프레임으로 이동
        btn_next.addActionListener(e -> {
            setVisible(false);
            String[][] timetable = TimeTable.getInstance().getTimetable();
            Data_read2 dataReader = new Data_read2();
            new Main_Gui2(timetable, dataReader).setVisible(true);
        });

        panel.add(btn_next);
        add(panel, BorderLayout.SOUTH);
    }

    /**
     * 애플리케이션을 실행하는 메인 메서드입니다.
     *
     * @param args 커맨드라인 인수 (사용되지 않음).
     */
    public static void main(String[] args) {
        Main_Gui frame = new Main_Gui();
    }
}
