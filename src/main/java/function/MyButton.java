package function;

import gui.RoundBtn;

public class MyButton extends RoundBtn {
    private final Click_ActionListener clickActionListener;
    private boolean isToggled = false;

    public MyButton() {
        super();
        this.clickActionListener = new Click_ActionListener(TimeTable.getInstance()); // 싱글톤 사용
        initButton();
    }

    public MyButton(String text) {
        super(text);
        this.clickActionListener = new Click_ActionListener(TimeTable.getInstance()); // 싱글톤 사용
        initButton();
    }

    private void initButton() {
        addActionListener(e -> {
            if (isToggled) {
                clickActionListener.actionPerformed_re(e);
            } else {
                clickActionListener.actionPerformed(e);
            }
            isToggled = !isToggled; // 상태 토글
        });
    }

    // 과목 버튼 타이틀 생성 -> 과목 이름 / 교수명
    public String setButtonTitle(String title, String professor) {
        return "<html><style>" +
                ".title { font-size: 20px; text-align: center } " +
                ".professor { font-size: 10px; text-align: center; }" +
                "</style><body>" +
                "<p class='title'>" + title + "</p>" +
                "<p class='professor'>" + professor + "</p>" +
                "</body></html>";
    }
}
