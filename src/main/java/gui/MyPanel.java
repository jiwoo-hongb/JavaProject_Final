package gui;

import javax.swing.*;
import java.awt.*;

/**
 * MyPanel 클래스는 기본 배경색을 설정한 JPanel을 확장한 클래스
 *
 * @author jiwoo-hongb(홍지우, jwhong48 @ gmail.com)
 *
 * @create 2024-11-11
 * @lastModified 2024-12-26
 *
 * @changelog
 * <ul>
 *  <li>2024-11-12: 최초 생성</li>
 *  <li>2024-12-26: Javadoc 수정</li>
 *  </ul>
 *
 * <p><b>주요 기능:</b>
 * <ul>
 * <li>Gui_Design 클래스에서 정의된 배경색을 사용</li>
 * <li>전체 GUI의 일관된 디자인을 유지하는 데 사용</li>
 * <li>MyPanel은 JPanel을 상속받아 배경색을 설정하고, 디자인을 통일하기 위해 사용</li>
 * </ul>
 * </p>
 */

public class MyPanel extends JPanel {

    /**
     * <ul><li>디자인 색상 객체</li></ul>
     */
    Gui_Design design = new Gui_Design();

    /**
     * <ul>
     * <li>MyPanel 생성자</li>
     * <li>기본 배경색을 설정</li>
     * </ul>
     */
    public MyPanel() {
        super();
        setBackground(design.getBackgroundColor());  // 배경색 설정
    }
}
