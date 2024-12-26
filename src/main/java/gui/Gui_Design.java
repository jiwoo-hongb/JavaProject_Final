package gui;

import java.awt.*;

/**
 * Gui_Design 클래스는 GUI 디자인에서 사용되는 색상을 정의하고 관리
 *
 * @author jiwoo-hongb(홍지우, jwhong48 @ gmail.com)
 *
 * @create 2024-11-11
 * @lastModified 2024-12-26
 *
 * @changelog
 * <ul>
 *  <li>2024-11-11: 최초 생성 및 색상 지정</li>
 *  <li>2024-12-26: Javadoc 수정</li>
 *  </ul>
 *
 * <p><b>주요 기능:</b>
 * <ul>
 * <li>각 색상은 고유의 `Color` 객체로 정의되며, getter 메서드를 통해 외부에서 접근 가능</li>
 * <li>컴포넌트에 적용할 수 있는 배경색, 패널색, 버튼색 등을 제공</li>
 * </ul>
 * </p>
 */
public class Gui_Design {

    /**
     * <ul><li>기본 배경색</li></ul>
     */
    private Color backGroundColor = new Color(7, 11, 13);

    /**
     * <ul><li>패널의 반투명 배경색 </li></ul>
     */
    private Color panelColor = new Color(39, 57, 64, 95);

    /**
     * <ul><li>버튼 기본 색상</li></ul>
     */
    private Color btnColor = new Color(242, 142, 19);

    /**
     * <ul><li>버튼 클릭 시 색상</li></ul>
     */
    private Color btnClickColor = new Color(166, 98, 38);

    /**
     * <ul><li>기본 배경색을 반환</li></ul>
     *
     * @return 기본 배경색
     */
    public Color getBackgroundColor() {
        return backGroundColor;
    }

    /**
     * <ul><li>패널 배경색을 반환</li></ul>
     *
     * @return 패널 배경색
     */
    public Color getPanelColor() {
        return panelColor;
    }

    /**
     * <ul><li>버튼 기본 색상을 반환</li></ul>
     *
     * @return 버튼 기본 색상
     */
    public Color getBtnColor() {
        return btnColor;
    }

    /**
     * <ul><li>버튼 클릭 시의 색상을 반환</li></ul>
     *
     * @return 버튼 클릭 시 색상
     */
    public Color getBtnClickColor() {
        return btnClickColor;
    }
}
