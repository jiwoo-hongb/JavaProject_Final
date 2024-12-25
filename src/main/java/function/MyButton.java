package function;

import gui.RoundBtn;

/**
 * MyButton 클래스는 커스터마이즈된 둥근 버튼 클래스입니다.
 * 이 클래스는 버튼 클릭 시 과목을 시간표에 추가하거나 제거하는 기능을 처리하며,
 * 버튼의 상태를 토글하여 해당 작업을 반복적으로 수행할 수 있도록 합니다.
 *
 * <p>이 버튼은 Click_ActionListener 객체를 사용하여 시간표에 과목을 추가하거나 제거합니다.</p>
 * <p>또한, 버튼의 텍스트를 과목 이름과 교수명으로 구성하여, HTML 형식으로 표시할 수 있습니다.</p>
 *
 * <p><b>사용 예:</b>
 * <pre>
 * MyButton button = new MyButton("수학");
 * button.setButtonTitle("수학", "홍길동");
 * </pre>
 * </p>
 */

public class MyButton extends RoundBtn {

    /** 버튼 클릭 이벤트를 처리하는 Click_ActionListener */
    private final Click_ActionListener clickActionListener;

    /** 버튼의 토글 상태 (과목 추가/제거 상태) */
    private boolean isToggled = false;

    /**
     * 기본 생성자입니다.
     * Click_ActionListener를 사용하여 시간표에 과목을 추가하거나 제거하는 기능을 초기화합니다.
     */
    public MyButton() {
        super();
        this.clickActionListener = new Click_ActionListener(TimeTable.getInstance()); // 싱글톤 사용
        initButton();
    }

    /**
     * 텍스트를 받는 생성자입니다.
     * Click_ActionListener를 사용하여 시간표에 과목을 추가하거나 제거하는 기능을 초기화합니다.
     *
     * @param text 버튼에 표시할 텍스트
     */
    public MyButton(String text) {
        super(text);
        this.clickActionListener = new Click_ActionListener(TimeTable.getInstance()); // 싱글톤 사용
        initButton();
    }

    /**
     * 버튼의 클릭 이벤트를 초기화합니다.
     * 버튼이 클릭되면, 현재 버튼의 상태에 따라 과목을 추가하거나 제거하는 작업을 수행합니다.
     * 상태는 버튼 클릭마다 토글됩니다.
     */
    private void initButton() {
        addActionListener(e -> {
            if (isToggled) {
                clickActionListener.actionPerformed_re(e);  // 과목 제거
            } else {
                clickActionListener.actionPerformed(e);  // 과목 추가
            }
            isToggled = !isToggled; // 상태 토글
        });
    }

    /**
     * 버튼의 텍스트를 HTML 형식으로 설정합니다.
     * 과목 이름과 교수명을 포함하여 버튼에 표시할 HTML 형식의 문자열을 생성합니다.
     *
     * @param title 과목 이름
     * @param professor 교수명
     * @return HTML 형식으로 구성된 과목 버튼의 텍스트
     */
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
