package gui;

import javax.swing.*;
import java.awt.*;

class CustomComboBoxRenderer extends JLabel implements ListCellRenderer<String> {
    Gui_Design design = new Gui_Design();
    @Override
    public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
        setText(value);
        setHorizontalAlignment(CENTER); // 가운데 정렬
        setFont(new Font("Pretendard", Font.BOLD, 14)); // 폰트 설정
        if (isSelected) {
            setBackground(design.getPanelColor()); // 선택된 항목 배경색
            setForeground(Color.WHITE); // 선택된 항목 글자색
        } else {
            setBackground(design.getBackgroundColor()); // 기본 배경색
            setForeground(Color.WHITE); // 기본 글자색
        }
        setOpaque(true); // 배경색이 적용되도록 설정
        return this;
    }
}