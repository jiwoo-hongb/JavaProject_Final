package function;

import gui.RoundBtn;

/**
 * MyButton 클래스는 커스터마이즈된 둥근 버튼 클래스
 *
 * @author jiwoo-hongb(홍지우, jwhong48 @ gmail.com)
 *
 * @create 2024-11-18
 * @lastModified 2024-12-26
 *
 * @changelog
 *  <ul>
 *  <li>2024-11-18: 최초 생성</li>
 *  <li>2024-11-19: 전공, 교필 데이터 처리를 위한 기능 추가</li>
 *  <li>2024-11-22: 오류 수정</li>
 *  <li>2024-11-26: 오류 수정</li>
 *  <li>2024-12-26: Javadoc 수정</li>
 *  </ul>
 *
 * <p><b>주요 기능:</b>
 * <ul>
 * <li>버튼 클릭 시 과목을 시간표에 추가하거나 제거하는 기능을 처리</li>
 * <li>버튼의 상태를 토글하여 해당 작업을 반복적으로 수행할 수 있도록 기능 제공</li>
 * <li>버튼의 텍스트를 과목 이름과 교수명으로 구성하여, HTML 형식으로 표시함</li>
 * </ul>
 * </p>
 */
public class MyButton extends RoundBtn {

    /**
     * <ul><li>버튼 클릭 이벤트를 처리하는 Click_ActionListener</li></ul>
     */
    private final Click_ActionListener clickActionListener;

    /**
     * <ul><li>버튼의 토글 상태 (과목 추가/제거 상태)</li></ul>
     */
    private boolean isToggled = false;

    /**
     * <ul>
     * <li>기본 생성자</li>
     * <li>Click_ActionListener를 사용하여 시간표에 과목을 추가하거나 제거하는 기능을 초기화</li>
     * </ul>
     */
    public MyButton() {
        super();
        this.clickActionListener = new Click_ActionListener(TimeTable.getInstance()); // 싱글톤 사용
        initButton();
    }

    /**
     * <ul>
     * <li>텍스트를 받는 생성자</li>
     * <li>Click_ActionListener를 사용하여 시간표에 과목을 추가하거나 제거하는 기능을 초기화</li>
     * </ul>
     *
     * @param text 버튼에 표시할 텍스트
     */
    public MyButton(String text) {
        super(text);
        this.clickActionListener = new Click_ActionListener(TimeTable.getInstance()); // 싱글톤 사용
        initButton();
    }

    /**
     * <ul>
     * <li>버튼의 클릭 이벤트를 초기화</li>
     * <li>버튼이 클릭시, 현재 버튼의 상태에 따라 과목을 추가하거나 제거하는 작업을 수행</li>
     * <li>상태는 버튼 클릭마다 토글</li>
     * </ul>
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
     * <ul>
     * <li>버튼의 텍스트를 HTML 형식으로 설정</li>
     * <li>과목 이름과 교수명을 포함하여 버튼에 표시할 HTML 형식의 문자열을 생성</li>
     * </ul>
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
