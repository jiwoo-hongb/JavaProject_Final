package data;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Data_read2 클래스는 '교양 강의 데이터.csv' 파일을 읽고 데이터를 저장 및 반환하는 기능을 제공
 *
 * @author jiwoo-hongb(홍지우, jwhong48 @ gmail.com)
 *
 * @create 2024-12-24
 * @lastModified 2024-12-26
 *
 * @changelog
 * <ul>
 *  <li>2024-12-24: 최초 생성 및 </li>
 *  <li>2024-12-25: 교양과목 정보 제공을 위한 데이터 관리</li>
 *  <li>2024-12-26: Javadoc 수정</li>
 *  </ul>
 *
 * <p><b>주요 기능:</b>
 * <ul>
 * <li>CSV 파일에서 모든 데이터를 행 단위로 읽어와 저장</li>
 * <li>교과목 및 시간 정보를 저장하고 반환</li>
 * <li>교과목에 대한 상세 정보를 교과목명, 교수, 시간, 장소, 학점, 영역별로 반환</li>
 * </ul>
 * </p>
 *
 */
public class Data_read2 {
    private final List<String[]> rows; // csv 데이터 전체 저장
    private final List<String> subjects; // 교과목 필드만 저장
    private final Map<String, String> subjectTimes; // 과목별 시간 데이터 매핑

    /**
     * <ul>
     * <li>Data_read2 클래스의 생성자</li>
     * <li>지정된 CSV 파일을 읽고 데이터를 저장</li>
     * <li>첫 번째 행(헤더)을 건너뛰고, 각 과목에 대한 시간 정보를 추출하여 저장</li>
     * </ul>
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

            // 파일의 각 줄을 읽어온다
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
     * <ul>
     * <li>CSV 파일에서 읽어온 모든 행을 반환</li>
     * </ul>
     *
     * @return CSV 파일의 모든 행을 담고 있는 리스트
     */
    public List<String[]> getRows() {
        return rows;
    }

    /**
     * <ul>
     * <li>CSV 파일에서 교과목만 추출하여 리스트로 반환</li>
     * </ul>
     *
     * @return 교과목명만 담고 있는 리스트
     */
    public List<String> getSubjects() {
        return subjects;
    }

    /**
     * <ul>
     * <li>과목별 시간 정보를 반환</li>
     * </ul>
     *
     * @return 과목명과 해당 시간 정보가 매핑된 맵
     */
    public Map<String, String> getSubjectTimes() {
        return subjectTimes;
    }

    /**
     * <ul>
     * <li>과목별 상세 정보를 반환</li>
     * <li>상세 정보에는 교과목명, 교수명, 시간, 장소, 학점, 영역이 포함</li>
     * </ul>
     *
     * @return 각 과목에 대한 상세 정보가 담긴 맵
     */
    public Map<String, String[]> getDetailedSubjectInfo() {
        Map<String, String[]> detailedInfo = new HashMap<>();
        for (String[] row : rows) {
            if (row.length >= 6) {
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
