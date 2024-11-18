package data;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class Data_read {
    public static void main(String[] args) {
        String filePath = "./csv/전공_교필_강의 데이터.csv"; // 읽을 CSV 파일 경로

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;

            // 파일의 각 줄을 읽어온다.
            while ((nextLine = reader.readNext()) != null) {
                // 읽어온 줄의 각 필드 출력
                for (String field : nextLine) {
                    System.out.print(field + " ");
                }
                System.out.println(); // 줄 바꿈
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
