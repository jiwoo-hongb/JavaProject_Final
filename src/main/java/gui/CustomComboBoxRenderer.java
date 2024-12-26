package gui;

import javax.swing.*;
import java.awt.*;

/**
 * CustomComboBoxRenderer 클래스는 JComboBox의 항목을 커스터마이징하여 렌더링하는 데 사용
 *
 * @author jiwoo-hongb(홍지우, jwhong48 @ gmail.com)
 *
 * @create 2024-12-25
 * @lastModified 2024-12-26
 *
 * @changelog
 * <ul>
 *  <li>2024-12-25: 최초 생성</li>
 *  <li>2024-12-26: Javadoc 수정</li>
 *  </ul>
 *
 * <p><b>주요 기능:</b>
 * <ul>
 * <li> JLabel을 확장하고 ListCellRenderer<String> 인터페이스를 구현</li>
 * <li> 항목의 텍스트, 정렬, 폰트 및 배경색/글자색을 설정</li>
 * </ul>
 * </p>
 *
 * @see <a href="https://stackoverflow.com/questions/39385345/jcombobox-custom-listcellrenderer">CustomComboBoxRenderer 활용 참고</a>
 */
class CustomComboBoxRenderer extends JLabel implements ListCellRenderer<String> {

    /**
     * <ul><li>Gui_Design 인스턴스를 생성하여 색상 설정을 참조</li></ul>
     */
    Gui_Design design = new Gui_Design();

    /**
     * <ul><li>리스트 항목의 렌더링을 처리하는 메서드</li></ul>
     *
     * @param list        JList 컴포넌트 (JComboBox에서 사용됨)
     * @param value       렌더링할 항목의 값
     * @param index       항목의 인덱스
     * @param isSelected  항목이 선택되었는지 여부
     * @param cellHasFocus 항목이 포커스를 가지고 있는지 여부
     * @return 렌더링된 컴포넌트
     */
    @Override
    public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
        // 항목 텍스트 설정
        setText(value);

        // 텍스트를 가운데 정렬
        setHorizontalAlignment(CENTER);

        // 폰트 설정
        setFont(new Font("Pretendard", Font.BOLD, 14));

        // 선택 상태와 비선택 상태에 따라 색상 설정
        if (isSelected) {
            setBackground(design.getPanelColor()); // 선택된 항목 배경색
            setForeground(Color.WHITE);           // 선택된 항목 글자색
        } else {
            setBackground(design.getBackgroundColor()); // 기본 배경색
            setForeground(Color.WHITE);                 // 기본 글자색
        }

        // 배경색 적용을 위해 Opaque 설정
        setOpaque(true);

        // 렌더링된 컴포넌트를 반환
        return this;
    }
}
