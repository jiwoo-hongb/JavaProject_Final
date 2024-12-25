/**
 * CustomListCellRenderer 클래스는 JList의 항목을 커스터마이즈하여 렌더링하는 데 사용됩니다.
 * DefaultListCellRenderer를 확장하여 텍스트 정렬, 폰트, 여백, 배경색 및 글자색을 설정할 수 있습니다.
 *
 * <p>이 클래스는 선택된 항목과 비선택 상태의 항목을 다르게 렌더링하며,
 * Gui_Design 클래스를 사용하여 디자인 색상을 참조합니다.</p>
 *
 * <p><b>사용 예:</b>
 * <pre>
 * JList<String> list = new JList<>(new String[] {"항목1", "항목2", "항목3"});
 * list.setCellRenderer(new CustomListCellRenderer());
 * </pre>
 * </p>
 */
package gui;

import javax.swing.*;
import java.awt.*;

// 커스터마이즈된 렌더러 클래스
class CustomListCellRenderer extends DefaultListCellRenderer {

    /** Gui_Design 인스턴스를 생성하여 색상 설정을 참조합니다. */
    Gui_Design design = new Gui_Design();

    /**
     * 리스트 항목의 렌더링을 처리하는 메서드입니다.
     *
     * @param list        JList 컴포넌트
     * @param value       렌더링할 항목의 값
     * @param index       항목의 인덱스
     * @param isSelected  항목이 선택되었는지 여부
     * @param cellHasFocus 항목이 포커스를 가지고 있는지 여부
     * @return 렌더링된 컴포넌트
     */
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        // 기본 렌더링 컴포넌트를 가져옵니다.
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        // 텍스트 정렬 설정
        label.setHorizontalAlignment(SwingConstants.CENTER); // 텍스트 가운데 정렬

        // 선택된 항목의 색상 설정
        if (isSelected) {
            label.setBackground(design.getBtnColor()); // 선택된 항목 배경색
            label.setForeground(Color.BLACK);         // 선택된 항목 글자색
        } else {
            label.setBackground(design.getBackgroundColor()); // 기본 배경색
            label.setForeground(Color.WHITE);                 // 기본 글자색
        }

        // 폰트 및 여백 설정
        label.setFont(new Font("Pretendard", Font.BOLD, 14)); // 맑은 고딕 폰트
        label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // 여백 추가

        // 렌더링된 컴포넌트를 반환
        return label;
    }
}
