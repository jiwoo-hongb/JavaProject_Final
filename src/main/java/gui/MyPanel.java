package gui;

import javax.swing.*;
import java.awt.*;

/**
 * MyPanel 클래스는 기본 배경색을 설정한 JPanel을 확장한 클래스입니다.
 * 이 클래스는 Gui_Design 클래스에서 정의된 배경색을 사용하여,
 * 전체 GUI의 일관된 디자인을 유지하는 데 사용됩니다.
 *
 * <p>MyPanel은 JPanel을 상속받아 배경색을 설정하고, 디자인을 통일하기 위해 사용됩니다.</p>
 *
 * <p><b>사용 예:</b>
 * <pre>
 * MyPanel panel = new MyPanel();
 * panel.setLayout(new BorderLayout());
 * </pre>
 * </p>
 */

public class MyPanel extends JPanel {

    /** 디자인 색상 객체 */
    Gui_Design design = new Gui_Design();

    /**
     * MyPanel 생성자입니다. 기본 배경색을 설정합니다.
     */
    public MyPanel() {
        super();
        setBackground(design.getBackgroundColor());  // 배경색 설정
    }
}
