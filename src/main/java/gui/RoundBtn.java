/**
 * RoundBtn 클래스는 둥근 모서리를 가진 커스터마이즈된 JButton입니다.
 * 이 클래스는 버튼의 배경을 둥글게 그리며, 버튼에 텍스트나 HTML을 렌더링할 수 있도록 합니다.
 * 버튼이 선택되었거나 마우스를 올렸을 때 색상이 달라지는 효과도 제공합니다.
 *
 * <p>RoundBtn은 기본적으로 둥근 배경을 그리고, 텍스트나 HTML을 중앙에 배치하여 버튼의 텍스트를 표시합니다.</p>
 *
 * <p><b>사용 예:</b>
 * <pre>
 * RoundBtn button = new RoundBtn("클릭");
 * button.setBackground(Color.BLUE);
 * </pre>
 * </p>
 */
package gui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicHTML;
import javax.swing.text.View;
import java.awt.*;

public class RoundBtn extends JButton {

    /**
     * 버튼을 그릴 때 호출되는 메서드입니다. 버튼의 배경을 둥근 모서리로 그리며, 
     * 텍스트가 있을 경우 중앙에 위치시킵니다.
     *
     * @param g 그래픽 객체
     */
    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        Graphics2D graphics = (Graphics2D) g;

        // 안티앨리어싱 설정으로 부드러운 그래픽을 적용
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 버튼의 상태에 따라 배경색을 설정
        if (getModel().isArmed()) {
            graphics.setColor(getBackground().darker()); // 버튼이 눌렸을 때
        } else if (getModel().isRollover()) {
            graphics.setColor(getBackground().brighter()); // 마우스를 올렸을 때
        } else {
            graphics.setColor(getBackground()); // 기본 배경색
        }

        // 둥근 버튼 배경 그리기
        graphics.fillRoundRect(0, 0, width, height, 10, 10);

        // 텍스트 렌더링
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

    /**
     * 기본 생성자입니다. 버튼을 생성하고 기본 설정을 적용합니다.
     */
    public RoundBtn() {
        super();
        decorate();
    }

    /**
     * 텍스트를 포함하는 RoundBtn을 생성합니다.
     *
     * @param text 버튼에 표시할 텍스트
     */
    public RoundBtn(String text) {
        super(text);
        decorate();
    }

    /**
     * Action 객체를 사용하여 RoundBtn을 생성합니다.
     *
     * @param action 버튼에 대한 Action 객체
     */
    public RoundBtn(Action action) {
        super(action);
        decorate();
    }

    /**
     * 아이콘을 포함하는 RoundBtn을 생성합니다.
     *
     * @param icon 버튼에 표시할 아이콘
     */
    public RoundBtn(Icon icon) {
        super(icon);
        decorate();
    }

    /**
     * 텍스트와 아이콘을 모두 포함하는 RoundBtn을 생성합니다.
     *
     * @param text 버튼에 표시할 텍스트
     * @param icon 버튼에 표시할 아이콘
     */
    public RoundBtn(String text, Icon icon) {
        super(text, icon);
        decorate();
    }

    /**
     * 버튼의 스타일을 설정하는 메서드입니다.
     * 버튼에 테두리 색을 제거하고, 배경을 투명하게 설정합니다.
     */
    protected void decorate() {
        setBorderPainted(false);  // 테두리 색 없애기
        setOpaque(false);          // 투명 배경 설정
    }
}
