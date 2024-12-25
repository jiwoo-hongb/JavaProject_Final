/**
 * RoundPanel 클래스는 둥근 모서리를 가진 JPanel을 구현한 클래스입니다.
 * 이 클래스는 지정된 반지름(radius)을 사용하여 패널의 모서리를 둥글게 처리하며,
 * 배경색과 테두리도 둥근 모서리 형태로 그려집니다.
 *
 * <p>RoundPanel은 패널에 둥근 모서리를 적용하여 사용자 인터페이스의 디자인을 보다 부드럽고 현대적인 느낌으로 만듭니다.</p>
 *
 * <p><b>사용 예:</b>
 * <pre>
 * RoundPanel panel = new RoundPanel(20);
 * panel.setBackground(Color.BLUE);
 * </pre>
 * </p>
 */
package gui;

import javax.swing.*;
import java.awt.*;

public class RoundPanel extends JPanel {

    /** 둥근 모서리의 반지름 */
    private int radius;

    /**
     * RoundPanel 생성자입니다.
     * 지정된 반지름을 사용하여 둥근 모서리를 설정하고, 배경을 투명하게 만듭니다.
     *
     * @param radius 둥근 모서리의 반지름
     */
    public RoundPanel(int radius) {
        this.radius = radius;
        setOpaque(false);  // 배경을 투명하게 설정
    }

    /**
     * 패널의 배경을 둥근 모서리 형태로 그립니다.
     * 안티앨리어싱을 적용하여 부드럽게 그려지도록 합니다.
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
     * 패널의 테두리를 둥근 모서리 형태로 그립니다.
     * 안티앨리어싱을 적용하여 부드럽게 그려지도록 합니다.
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
