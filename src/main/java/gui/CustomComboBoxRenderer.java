package gui;

import javax.swing.*;
import java.awt.*;

/**
 * CustomComboBoxRenderer 클래스는 JComboBox의 항목을 커스터마이징하여 렌더링하는 데 사용됩니다.
 * 이 클래스는 JLabel을 확장하고 ListCellRenderer<String> 인터페이스를 구현합니다.
 *
 * <p>이 클래스는 항목의 텍스트, 정렬, 폰트 및 배경색/글자색을 설정합니다.
 * 선택된 항목과 기본 상태의 항목을 다르게 렌더링할 수 있습니다.</p>
 *
 * <p><b>사용 예:</b>
 * <pre>
 * JComboBox<String> comboBox = new JComboBox<>(new String[] {"항목1", "항목2", "항목3"});
 * comboBox.setRenderer(new CustomComboBoxRenderer());
 * </pre>
 * </p>
 *
 * <p>디자인 색상은 외부 Gui_Design 클래스에서 정의된 값을 참조합니다.</p>
 */

class CustomComboBoxRenderer extends JLabel implements ListCellRenderer<String> {

    /** Gui_Design 인스턴스를 생성하여 색상 설정을 참조합니다. */
    Gui_Design design = new Gui_Design();

    /**
     * 리스트 항목의 렌더링을 처리하는 메서드입니다.
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
