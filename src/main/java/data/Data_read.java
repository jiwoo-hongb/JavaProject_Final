package data;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Data_read {
    List<String[]> rows; // csv 데이터 전체 저장
    List<String> subjects; // 교과목 필드만 저장

    public Data_read() {
        rows = new ArrayList<>();
        subjects = new ArrayList<>();
        String filePath = "./csv/전공_교필_강의 데이터.csv"; // 읽을 CSV 파일 경로

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            boolean isFirst = true; // ?

            // 파일의 각 줄을 읽어온다.
            while ((nextLine = reader.readNext()) != null) {
                if (isFirst) {
                    isFirst = false; // 첫번째 줄 -> 헤더는 건너뜀
                    continue;
                }
                rows.add(nextLine);

                if(nextLine.length > 0) {
                    subjects.add(nextLine[0].trim());
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
}
