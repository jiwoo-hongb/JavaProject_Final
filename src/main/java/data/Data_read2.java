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

    public Data_read2() {
        rows = new ArrayList<>();
        subjects = new ArrayList<>();
        subjectTimes = new HashMap<>();
        String filePath = "./csv/교양 강의 데이터.csv"; // 읽을 CSV 파일 경로

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            boolean isFirst = true; // 헤더 확인용 변수
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
            e.printStackTrace();
        }
    }

    // csv 모든 행 반환
    public List<String[]> getRows() {
        return rows;
    }

    // 교과목 리스트 반환
    public List<String> getSubjects() {
        return subjects;
    }

    // 과목별 시간 정보 반환
    public Map<String, String> getSubjectTimes() {
        return subjectTimes;
    }

    public Map<String, String[]> getDetailedSubjectInfo() {
        // 과목별 상세 정보를 반환 (교과목, 교수, 시간, 장소, 학점, 영역)
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
