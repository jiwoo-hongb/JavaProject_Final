package function;

import javax.swing.*;
import java.awt.*;

public class SubjectInfoPopup {

    public static void showSubjectInfo(Component parent, String subjectName, String professor, String time, String location, String credits, String category) {
        // 팝업 창 생성
        JFrame popup = new JFrame("교과목 정보");
        popup.setSize(300, 200);
        popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        popup.setLayout(new GridLayout(6, 1));

        // 교과목 정보를 JLabel로 추가
        popup.add(new JLabel("교과목: " + subjectName));
        popup.add(new JLabel("교수: " + professor));
        popup.add(new JLabel("시간: " + time));
        popup.add(new JLabel("장소: " + location));
        popup.add(new JLabel("학점: " + credits));
        popup.add(new JLabel("영역: " + category));

        // 팝업 창을 부모 컴포넌트 근처에 표시
        popup.setLocationRelativeTo(parent);
        popup.setVisible(true);
    }
}
