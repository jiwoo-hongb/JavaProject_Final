package function;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import data.CourseLoader;

public class CourseSelector implements ActionListener {
    private CourseLoader courseLoader;  // CourseLoader 객체

    public CourseSelector(CourseLoader courseLoader) {
        this.courseLoader = courseLoader;  // CourseLoader 객체를 받아옴
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        // 버튼 텍스트에서 과목명만 정확하게 추출 (공백을 기준으로 첫 번째 부분만 가져옴)
        String courseName = btn.getText().split(" ")[0].trim();  // 공백을 기준으로 첫 번째 부분만 가져오고 trim()으로 앞뒤 공백 제거

        // CourseLoader에서 해당 과목의 정보를 가져옴
        String courseDetails = courseLoader.getCourseDetails(courseName);

        // 콘솔에 출력 (GUI에서 보여주려면 JOptionPane 등으로 띄울 수 있음)
        System.out.println(courseDetails);

        // 예: 학점 정보만 보여주는 팝업
        JOptionPane.showMessageDialog(null, courseDetails, courseName + " 정보", JOptionPane.INFORMATION_MESSAGE);
    }

    public void actionPerformed_re(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        System.out.println(btn.getText() + " 취소");
    }
}
