package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundBtn extends JButton {

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        Graphics2D graphics = (Graphics2D) g;

        // 안티앨리어싱 설정
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 버튼 상태에 따른 배경색 설정
        if (getModel().isArmed()) {
            graphics.setColor(getBackground().darker());
        } else if (getModel().isRollover()) {
            graphics.setColor(getBackground().brighter());
        } else {
            graphics.setColor(getBackground());
        }

        // 둥근 모서리를 가진 사각형으로 버튼 배경 채우기
        graphics.fillRoundRect(0, 0, width, height, 10, 10);

        // 텍스트 중앙 정렬을 위한 위치 계산
        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

        int textX = (width - stringBounds.width) / 2;
        int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();

        // 텍스트 색상 및 폰트 설정 후 그리기
        graphics.setColor(getForeground());
        graphics.setFont(getFont());
        graphics.drawString(getText(), textX, textY);
        graphics.dispose();

        super.paintComponent(g);
    }

    public RoundBtn() {
        super();
        decorate();
    }

    public RoundBtn(String text) {
        super(text);
        decorate();
    }

    public RoundBtn(Action action) {
        super(action);
        decorate();
    }

    public RoundBtn(Icon icon) {
        super(icon);
        decorate();
    }

    public RoundBtn(String text, Icon icon) {
        super(text, icon);
        decorate();
    }

    protected void decorate() {
        setBorderPainted(false);
        setOpaque(false);
    }
}
