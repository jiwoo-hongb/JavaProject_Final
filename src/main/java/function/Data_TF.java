/**
 * Data_TF 클래스는 교과목 데이터를 처리하는 클래스입니다.
 * 이 클래스는 Data_read 객체를 통해 교과목 데이터를 로드하고, 주어진 버튼 텍스트와 교과목 목록을 비교하는 기능을 제공합니다.
 *
 * <p>주로 시간표에 과목을 추가할 때, 버튼 텍스트가 유효한 교과목인지 확인하는 용도로 사용됩니다.</p>
 *
 * <p><b>사용 예:</b>
 * <pre>
 * Data_TF dataTF = new Data_TF();
 * boolean isMatched = dataTF.isSubjectMatched("수학");
 * </pre>
 * </p>
 */
package function;

import java.util.List;
import data.Data_read;

public class Data_TF {

    /** 교과목 목록 */
    private List<String> subjects;

    /**
     * Data_TF 클래스의 생성자입니다.
     * Data_read 객체를 사용하여 교과목 데이터를 로드합니다.
     */
    public Data_TF() {
        // Data_read를 통해 교과목 데이터 로드
        Data_read dataRead = new Data_read();
        this.subjects = dataRead.getSubjects();
    }

    /**
     * 주어진 버튼 텍스트가 교과목 목록에 포함되어 있는지 확인하는 메서드입니다.
     *
     * @param buttonText 버튼 텍스트
     * @return 주어진 텍스트가 교과목 목록에 포함되면 true, 그렇지 않으면 false
     */
    public boolean isSubjectMatched(String buttonText) {
        return subjects.contains(buttonText.trim());
    }
}
