package gui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicHTML;
import javax.swing.text.View;
import java.awt.*;

public class RoundBtn extends JButton {

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        Graphics2D graphics = (Graphics2D) g;


        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (getModel().isArmed()) {
            graphics.setColor(getBackground().darker());
        } else if (getModel().isRollover()) {
            graphics.setColor(getBackground().brighter());
        } else {
            graphics.setColor(getBackground());
        }

        // 둥근 버튼 배경 그리기
        graphics.fillRoundRect(0, 0, width, height, 10, 10);

        String text = getText();
        if (text != null) {
            graphics.setColor(getForeground());
            graphics.setFont(getFont());

            if (text.trim().startsWith("<html>")) {
                // HTML 텍스트 렌더링
                View view = BasicHTML.createHTMLView(this, text);
                view.paint(graphics, new Rectangle(10, 10, width - 20, height - 20));
            } else {
                // 일반 텍스트 렌더링
                FontMetrics fontMetrics = graphics.getFontMetrics();
                Rectangle stringBounds = fontMetrics.getStringBounds(text, graphics).getBounds();

                int textX = (width - stringBounds.width) / 2;
                int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();

                graphics.drawString(text, textX, textY);
            }
        }

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
