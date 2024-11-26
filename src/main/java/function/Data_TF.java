package function;
import java.util.List;
import data.Data_read;
public class Data_TF {
    private List<String> subjects;
    public Data_TF() {
        // Data_read를 통해 교과목 데이터 로드
        Data_read dataRead = new Data_read();
        this.subjects = dataRead.getSubjects();
    }
    public boolean isSubjectMatched(String buttonText) {
        return subjects.contains(buttonText.trim());
    }
}