package function;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gui.Gui_Design;
import data.Data_read;
import javax.swing.*;

/**
 * Click_ActionListener 클래스는 시간표에 과목을 추가하거나 제거하는 작업을 처리하는 ActionListener
 *
 * @author jiwoo-hongb(홍지우, jwhong48 @ gmail.com)
 * @create 2024-11-18
 * @lastModified 2024-12-26
 *
 * @changelog
 * <ul>
 *  <li>2024-11-18: 최초 생성</li>
 *  <li>2024-11-19: 전공/교필 선택시 시간표에 추가 기능</li>
 *  <li>2024-11-26: 데이터 처리</li>
 *  <li>2024-12-23: 오류 수정</li>
 *  <li>2024-12-25: 오류 수정</li>
 *  <li>2024-12-26: 최종 수정</li>
 *  </ul>
 *
 * <p><b>주요 기능:</b>
 * <ul>
 * <li>사용자가 버튼을 클릭했을 때 발생하는 이벤트를 처리하여, 시간표에 과목을 추가하거나 기존에 추가된 과목을 제거하는 기능</li>
 * <li>교과목 필드만 추출하여 별도의 리스트에 저장</li>
 * <li>각 버튼 클릭 시, HTML 형식으로 담겨 있는 과목 정보를 추출하여, 시간표에 반영하는 방식으로 동작</li>
 * </ul>
 * </p>
 *
 */
public class Click_ActionListener implements ActionListener {

    /**
     * <ul><li>디자인 관련 객체 </li></ul>
     */
    Gui_Design design = new Gui_Design();

    /**
     * <ul><li> 데이터 읽기 관련 객체 </li></ul>
     */
    Data_read data = new Data_read();

    /**
     * <ul><li>데이터 입력/출력 관련 객체</li></ul>
     */
    Data_TF dataTF = new Data_TF();

    /**
     * <ul><li>현재 JFrame을 저장하는 변수</li></ul>
     */
    JFrame currentFrame;

    /**
     * <ul><li>시간표 관련 객체 </li></ul>
     */
    TimeTable timeTable;

    /**
     * <ul>
     * <li>Click_ActionListener 클래스의 생성자</li>
     * <li>시간표 객체를 받아서 해당 객체와 관련된 작업을 처리</li>
     * </ul>
     *
     * @param timeTable 시간표 객체
     */
    public Click_ActionListener(TimeTable timeTable) {
        this.timeTable = timeTable;
    }

    /**
     * <ul>
     * <li>버튼을 클릭했을 때 호출되는 메서드로, 과목을 시간표에 추가하는 기능을 수행</li>
     * </ul>
     *
     * @param e ActionEvent 객체, 버튼 클릭 이벤트
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();  // 클릭된 버튼을 가져옴
        btn.setBackground(design.getBtnClickColor());  // 버튼 색상 변경

        // 버튼 텍스트에서 HTML을 파싱하여 과목명을 추출
        Document doc = Jsoup.parse(btn.getText());
        String subject = doc.selectFirst(".title").text();

        // 시간표에 과목을 추가
        if (timeTable.addSubjectToTimetable(subject)) {
            System.out.println(subject + " added to the timetable.");
        } else {
            System.out.println(subject + " could not be added (conflict or not found).");
        }

        timeTable.printTimetable();  // 시간표 출력
    }

    /**
     * <ul>
     * <li>버튼을 클릭했을 때 호출되는 메서드로, 시간표에서 과목을 제거하는 기능을 수행</li>
     * </ul>
     *
     * @param e ActionEvent 객체, 버튼 클릭 이벤트
     */
    public void actionPerformed_re(ActionEvent e) {
        JButton btn = (JButton) e.getSource();  // 클릭된 버튼을 가져옴
        btn.setBackground(design.getBtnColor());  // 버튼 색상 원래대로 변경

        // 버튼 텍스트에서 HTML을 파싱하여 과목명을 추출
        Document doc = Jsoup.parse(btn.getText());
        String subject = doc.selectFirst(".title").text();

        // 시간표에서 과목을 제거
        if (timeTable.removeSubjectFromTimetable(subject)) {
            System.out.println(subject + " removed from the timetable.");
        } else {
            System.out.println(subject + " could not be removed (not found in timetable).");
        }

        timeTable.printTimetable();  // 시간표 출력
    }
}
