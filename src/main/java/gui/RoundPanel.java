package gui;

import javax.swing.*;
import java.awt.*;

/**
 * RoundPanel 클래스는 둥근 모서리를 가진 JPanel을 구현한 클래스
 *
 * @author jiwoo-hongb(홍지우, jwhong48 @ gmail.com)
 *
 * @create 2024-11-22
 * @lastModified 2024-12-26
 *
 * @changelog
 * <ul>
 *  <li>2024-11-22: 최초 생성</li>
 *  <li>2024-12-26: Javadoc 수정</li>
 *  </ul>
 *
 * <p><b>주요 기능:</b>
 * <ul>
 * <li>이 클래스는 지정된 반지름(radius)을 사용하여 패널의 모서리를 둥글게 처리</li>
 * <li>배경색과 테두리도 둥근 모서리 형태로 그려짐</li>
 * </ul>
 * </p>
 */

public class RoundPanel extends JPanel {

    /**
     * <ul><li>둥근 모서리의 반지름</li></ul>
     */
    private int radius;

    /**
     * <ul>
     * <li>RoundPanel 생성자</li>
     * <li>지정된 반지름을 사용하여 둥근 모서리를 설정하고, 배경을 투명하게 만듬</li>
     * </ul>
     *
     * @param radius 둥근 모서리의 반지름
     */
    public RoundPanel(int radius) {
        this.radius = radius;
        setOpaque(false);  // 배경을 투명하게 설정
    }

    /**
     * <ul>
     * <li>패널의 배경을 둥근 모서리 형태로 그림</li>
     * <li>안티앨리어싱을 적용하여 부드럽게 그려짐</li>
     * </ul>
     *
     * @param g 그래픽 객체
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);

        super.paintComponent(g);
    }

    /**
     * <ul>
     * <li>패널의 테두리를 둥근 모서리 형태로 그림</li>
     * <li>안티앨리어싱을 적용하여 부드럽게 그림</li>
     * </ul>
     *
     * @param g 그래픽 객체
     */
    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
    }
}
