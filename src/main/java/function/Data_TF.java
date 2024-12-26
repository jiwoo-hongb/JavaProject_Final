package function;

import java.util.List;
import data.Data_read;

/**
 * Data_TF 클래스는 교과목 데이터를 처리하는 클래스
 *
 * @author jiwoo-hongb(홍지우, jwhong48 @ gmail.com)
 *
 * @create 2024-11-12
 * @lastModified 2024-12-26
 *
 * @changelog
 * <ul>
 *  <li>2024-11-19: 최초 생성</li>
 *  <li>2024-11-26: 전공 및 교필 데이터를 처리하기 위한 메서드 추가</li>
 *  <li>2024-12-25: Javadoc 작성</li>
 *  <li>2024-12-26: Javadoc 최종 수정</li>
 *  </ul>
 *
 * <p><b>주요 기능:</b>
 * <ul>
 * <li>Data_read 객체를 통해 교과목 데이터를 로드</li>
 * <li>주어진 버튼 텍스트와 교과목 목록을 비교하는 기능을 제공</li>
 * </ul>
 * </p>
 */
public class Data_TF {

    /**
     * <ul><li>교과목 목록 </li></ul>
     */
    private List<String> subjects;

    /**
     * <ul>
     * <li>Data_TF 클래스의 생성자</li>
     * <li>Data_read 객체를 사용하여 교과목 데이터를 로드</li>
     * </ul>
     */
    public Data_TF() {
        // Data_read를 통해 교과목 데이터 로드
        Data_read dataRead = new Data_read();
        this.subjects = dataRead.getSubjects();
    }

    /**
     * <ul>
     * <li>주어진 버튼 텍스트가 교과목 목록에 포함되어 있는지 확인하는 메서드</li>
     * </ul>
     *
     * @param buttonText 버튼 텍스트
     * @return 주어진 텍스트가 교과목 목록에 포함되면 true, 그렇지 않으면 false
     */

    public boolean isSubjectMatched(String buttonText) {
        return subjects.contains(buttonText.trim());
    }
}
