package gui;

import java.awt.*;

/**
 * Gui_Design 클래스는 GUI 디자인에서 사용되는 색상을 정의하고 관리하는 역할을 합니다.
 * 이 클래스는 다양한 컴포넌트에 적용할 수 있는 배경색, 패널색, 버튼색 등을 제공합니다.
 *
 * <p>각 색상은 고유의 `Color` 객체로 정의되며, getter 메서드를 통해 외부에서 접근할 수 있습니다.</p>
 *
 * <p><b>사용 예:</b>
 * <pre>
 * Gui_Design design = new Gui_Design();
 * Color backgroundColor = design.getBackgroundColor();
 * Color buttonColor = design.getBtnColor();
 * </pre>
 * </p>
 */

public class Gui_Design {

    /** 기본 배경색 (검은색 계열) */
    private Color backGroundColor = new Color(7, 11, 13);

    /** 패널의 반투명 배경색 */
    private Color panelColor = new Color(39, 57, 64, 95);

    /** 버튼 기본 색상 (주황색 계열) */
    private Color btnColor = new Color(242, 142, 19);

    /** 버튼 클릭 시 색상 (갈색 계열) */
    private Color btnClickColor = new Color(166, 98, 38);

    /**
     * 기본 배경색을 반환합니다.
     *
     * @return 기본 배경색
     */
    public Color getBackgroundColor() {
        return backGroundColor;
    }

    /**
     * 패널 배경색을 반환합니다.
     *
     * @return 패널 배경색
     */
    public Color getPanelColor() {
        return panelColor;
    }

    /**
     * 버튼 기본 색상을 반환합니다.
     *
     * @return 버튼 기본 색상
     */
    public Color getBtnColor() {
        return btnColor;
    }

    /**
     * 버튼 클릭 시의 색상을 반환합니다.
     *
     * @return 버튼 클릭 시 색상
     */
    public Color getBtnClickColor() {
        return btnClickColor;
    }
}
