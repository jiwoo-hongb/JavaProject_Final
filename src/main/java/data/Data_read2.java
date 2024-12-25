/**
 * Data_read2 클래스는 교양 강의에 대한 CSV 파일을 읽고 데이터를 저장 및 반환하는 기능을 제공합니다.
 * 이 클래스는 CSV 파일에서 교과목, 교수, 시간, 장소, 학점, 영역에 대한 정보를 추출하고 이를 관리합니다.
 *
 * <p><b>주요 기능:</b>
 * <ul>
 * <li>CSV 파일에서 모든 데이터를 행 단위로 읽어와 저장</li>
 * <li>교과목 및 시간 정보를 저장하고 반환</li>
 * <li>교과목에 대한 상세 정보를 교과목명, 교수, 시간, 장소, 학점, 영역별로 반환</li>
 * </ul>
 * </p>
 *
 * <p><b>사용 예:</b>
 * <pre>
 * Data_read2 dataRead2 = new Data_read2();
 * List<String[]> rows = dataRead2.getRows(); // CSV 모든 행 반환
 * List<String> subjects = dataRead2.getSubjects(); // 교과목 리스트 반환
 * Map<String, String> subjectTimes = dataRead2.getSubjectTimes(); // 과목별 시간 정보 반환
 * Map<String, String[]> detailedInfo = dataRead2.getDetailedSubjectInfo(); // 과목별 상세 정보 반환
 * </pre>
 * </p>
 */
package data;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data_read2 {
    private final List<String[]> rows; // csv 데이터 전체 저장
    private final List<String> subjects; // 교과목 필드만 저장
    private final Map<String, String> subjectTimes; // 과목별 시간 데이터 매핑

    /**
     * Data_read2 클래스의 생성자.
     * 지정된 CSV 파일을 읽고 데이터를 저장합니다.
     * 첫 번째 행(헤더)을 건너뛰고, 각 과목에 대한 시간 정보를 추출하여 저장합니다.
     *
     * @throws IllegalArgumentException "시간" 열이 없을 경우 발생
     */
    public Data_read2() {
        rows = new ArrayList<>();
        subjects = new ArrayList<>();
        subjectTimes = new HashMap<>();
        String filePath = "./csv/교양 강의 데이터.csv"; // 읽을 CSV 파일 경로

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            boolean isFirst = true; // 첫 번째 줄은 헤더로 처리
            int timeIndex = -1; // "시간" 열의 인덱스

            // 파일의 각 줄을 읽어온다.
            while ((nextLine = reader.readNext()) != null) {
                if (isFirst) {
                    isFirst = false; // 첫 번째 줄은 헤더
                    for (int i = 0; i < nextLine.length; i++) {
                        if ("시간".equals(nextLine[i].trim())) {
                            timeIndex = i; // "시간" 열의 위치 저장
                            break;
                        }
                    }
                    if (timeIndex == -1) {
                        throw new IllegalArgumentException("CSV 파일에 '시간' 헤더가 없습니다.");
                    }
                    continue;
                }

                rows.add(nextLine);

                // 과목 이름 저장 (첫 번째 열)
                if (nextLine.length > 0) {
                    String subject = nextLine[0].trim();
                    subjects.add(subject);

                    // 시간 데이터 저장
                    if (nextLine.length > timeIndex) {
                        String time = nextLine[timeIndex].trim();
                        subjectTimes.put(subject, time);
                    }
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스를 출력
        }
    }

    /**
     * CSV 파일에서 읽어온 모든 행을 반환합니다.
     *
     * @return CSV 파일의 모든 행을 담고 있는 리스트
     */
    public List<String[]> getRows() {
        return rows;
    }

    /**
     * CSV 파일에서 교과목만 추출하여 리스트로 반환합니다.
     *
     * @return 교과목명만 담고 있는 리스트
     */
    public List<String> getSubjects() {
        return subjects;
    }

    /**
     * 과목별 시간 정보를 반환합니다.
     *
     * @return 과목명과 해당 시간 정보가 매핑된 맵
     */
    public Map<String, String> getSubjectTimes() {
        return subjectTimes;
    }

    /**
     * 과목별 상세 정보를 반환합니다.
     * 상세 정보에는 교과목명, 교수명, 시간, 장소, 학점, 영역이 포함됩니다.
     *
     * @return 각 과목에 대한 상세 정보가 담긴 맵
     */
    public Map<String, String[]> getDetailedSubjectInfo() {
        Map<String, String[]> detailedInfo = new HashMap<>();
        for (String[] row : rows) {
            if (row.length >= 6) { // 최소 6개의 열이 있어야 함
                String subject = row[0].trim();
                detailedInfo.put(subject, new String[]{
                        row[0], // 교과목
                        row[1], // 교수
                        row[2], // 시간
                        row[3], // 장소
                        row[4], // 학점
                        row[5]  // 영역
                });
            }
        }
        return detailedInfo;
    }
}
