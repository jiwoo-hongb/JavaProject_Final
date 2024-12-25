/**
 * Data_read 클래스는 CSV 파일에서 데이터를 읽어와 저장하는 기능을 제공합니다.
 * 이 클래스는 주로 교과목 데이터를 읽어와 리스트로 반환하는 역할을 합니다.
 *
 * <p><b>주요 기능:</b>
 * <ul>
 * <li>CSV 파일을 읽고 데이터를 행 단위로 저장</li>
 * <li>교과목 필드만 추출하여 별도의 리스트에 저장</li>
 * <li>CSV 파일의 데이터(행)를 반환하는 메소드 제공</li>
 * </ul>
 * </p>
 *
 * <p><b>사용 예:</b>
 * <pre>
 * Data_read dataRead = new Data_read();
 * List<String[]> rows = dataRead.getRows(); // CSV 모든 행 반환
 * List<String> subjects = dataRead.getSubjects(); // 교과목 리스트 반환
 * </pre>
 * </p>
 */
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

    /**
     * Data_read 클래스의 생성자.
     * 지정된 CSV 파일을 읽고 데이터를 저장합니다.
     * 첫 번째 행(헤더)은 건너뛰고 그 이후의 데이터를 rows와 subjects에 저장합니다.
     */
    public Data_read() {
        rows = new ArrayList<>();
        subjects = new ArrayList<>();
        String filePath = "./csv/전공_교필_강의 데이터.csv"; // 읽을 CSV 파일 경로

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            boolean isFirst = true; // 첫 번째 줄을 헤더로 처리하기 위한 변수

            // 파일의 각 줄을 읽어온다.
            while ((nextLine = reader.readNext()) != null) {
                if (isFirst) {
                    isFirst = false; // 첫 번째 줄 -> 헤더는 건너뜀
                    continue;
                }
                rows.add(nextLine); // 각 행을 rows에 추가

                if(nextLine.length > 0) {
                    subjects.add(nextLine[0].trim()); // 교과목명만 추출하여 subjects에 추가
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
}
