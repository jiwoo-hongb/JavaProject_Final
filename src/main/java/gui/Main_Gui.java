package gui;

import function.MyButton;
import javax.swing.*;
import java.awt.*;
import function.MyButton;

public class Main_Gui extends JFrame {
    Gui_Design design = new Gui_Design();
    MyButton myBtn = new MyButton();

    Main_Gui() {

        setTitle("시간표 마법사 💫");
        setSize(355, 770);
        setLayout(new BorderLayout());

        showNorth();
        showCenter();
        showSouth();

        setVisible(true);
    }

    void showNorth(){
        MyPanel panel = new MyPanel();
        RoundPanel panel_Background_Color = new RoundPanel(20); // 배경을 위한 색상
        panel_Background_Color.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        panel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        panel_Background_Color.setBackground(design.getPanelColor());
        JLabel credit = new JLabel("학점 : 18학점");
        credit.setBounds(12, 20, 367, 40);
        credit.setBorder(BorderFactory.createEmptyBorder(0, 75,0,75));
        credit.setFont(new Font("Pretendard", Font.BOLD, 24));
        credit.setForeground(Color.WHITE);

        panel_Background_Color.add(credit);
        panel.add(panel_Background_Color);

        add(panel, BorderLayout.NORTH);
    }

    // 버튼 크기 및 스타일 설정 함수
    private void setupButton(MyButton button) {
        button.setBackground(design.getBtnColor());
//        button.setMaximumSize(size); // 버튼의 최대 크기 설정
//        button.setMinimumSize(size); // 버튼의 최소 크기 설정
//        button.setPreferredSize(size); // 버튼의 기본 크기 설정
        button.setAlignmentX(Component.LEFT_ALIGNMENT); // 왼쪽 정렬
    }

    void showCenter() {
        MyPanel panel1 = new MyPanel(); // 전체 테두리

        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS)); // 패널1의 레이아웃 설정
        panel1.setBorder(BorderFactory.createEmptyBorder(10,15,10,15));
        JLabel major = new JLabel("전공");
        major.setFont(new Font("Pretendard", Font.BOLD, 26));
        major.setForeground(Color.WHITE);
        major.setAlignmentX(Component.LEFT_ALIGNMENT); // 왼쪽 정렬

        RoundPanel panel2 = new RoundPanel(15); // 전공 버튼 담을 테두리
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel2.setBackground(design.getPanelColor());
        panel2.setBorder(BorderFactory.createEmptyBorder(3,10,3,10));


        // [전공 과목 버튼]
        String javaText = myBtn.setButtonTitle("JAVA프로그래밍", "남수만");
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

        // 버튼 추가
        panel2.add(Box.createVerticalStrut(15)); // 첫 번째 간격
        panel2.add(btn_Java);
        panel2.add(Box.createVerticalStrut(15)); // 버튼 간 간격
        panel2.add(btn_GUI);
        panel2.add(Box.createVerticalStrut(15));
        panel2.add(btn_Algorithem);
        panel2.add(Box.createVerticalStrut(15));
        panel2.add(btn_BigData);
        panel2.add(Box.createVerticalStrut(15));
        panel2.add(btn_OS);
        panel2.add(Box.createVerticalStrut(15)); // 마지막 간격

        RoundPanel panel3 = new RoundPanel(15); // 교양 버튼 담을 테두리
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel3.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel3.setBackground(design.getPanelColor());
        panel3.setBorder(BorderFactory.createEmptyBorder(3,10,3,10));

        JLabel culture = new JLabel("교양 필수");
        culture.setFont(new Font("Pretendard", Font.BOLD, 26));
        culture.setForeground(Color.WHITE);
        culture.setAlignmentX(Component.LEFT_ALIGNMENT); // 왼쪽 정렬

        String english3Text = myBtn.setButtonTitle("English3", "boris");
        MyButton btn_English3 = new MyButton(english3Text);
        btn_English3.setFont(new Font("Pretendard", Font.BOLD, 24));
        setupButton(btn_English3);

        // 버튼 추가
        panel3.add(Box.createVerticalStrut(10));
        panel3.add(btn_English3);
        panel3.add(Box.createVerticalStrut(10));

        // 전체 패널에 구성 요소 추가
        panel1.add(Box.createVerticalStrut(10)); // 상단 간격
        panel1.add(major);
        panel1.add(Box.createVerticalStrut(10)); // 제목과 버튼 사이 간격
        panel1.add(panel2);
        panel1.add(Box.createVerticalStrut(20)); // 전공과 교양 필수 사이 간격
        panel1.add(culture);
        panel1.add(Box.createVerticalStrut(10)); // 교양 제목과 버튼 사이 간격
        panel1.add(panel3);

        add(panel1, BorderLayout.CENTER);
    }

    void showSouth(){
        MyPanel panel = new MyPanel();
        MyButton btn_next = new MyButton("▷");
        btn_next.setFont(new Font("Pretendard", Font.BOLD, 24));
        btn_next.setBackground(design.getPanelColor());
        btn_next.setAlignmentX(Component.LEFT_ALIGNMENT); // 왼쪽 정렬
        btn_next.setForeground(Color.WHITE);

        panel.add(btn_next);
        add(panel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        Main_Gui frame = new Main_Gui();
    }
}
