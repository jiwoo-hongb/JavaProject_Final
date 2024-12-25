package gui;

import javax.swing.*;
import java.awt.*;

// 커스터마이즈된 렌더러 클래스
class CustomListCellRenderer extends DefaultListCellRenderer {
    Gui_Design design = new Gui_Design();
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        // 기본 렌더링 컴포넌트를 가져옵니다.
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        // 텍스트 정렬 설정
        label.setHorizontalAlignment(SwingConstants.CENTER); // 텍스트 가운데 정렬

        // 선택된 항목의 색상 설정
        if (isSelected) {
            label.setBackground(design.getBtnColor()); // 선택된 항목 배경색
            label.setForeground(Color.BLACK); // 선택된 항목 글자색
        } else {
            label.setBackground(design.getBackgroundColor()); // 기본 배경색
            label.setForeground(Color.WHITE); // 기본 글자색
        }

        // 폰트 및 여백 설정
        label.setFont(new Font("Malgun Gothic", Font.PLAIN, 14)); // 맑은 고딕 폰트
        label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // 여백 추가

        return label;
    }
}
