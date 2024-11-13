package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data_read {
    public static void main(String[] args) throws IOException {
        String filePath = "src/data/교양 강의 데이터.csv";
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        // 헤더 읽기
        String line = br.readLine();
        if (line == null) {
            System.out.println("CSV 파일에 헤더가 없습니다.");
            br.close();
            return;
        }
        String[] header = line.split(",");

        // 데이터 읽기
        List<Map<String, String>> dataList = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");
            Map<String, String> rowMap = new HashMap<>();
            for (int i = 0; i < header.length; i++) {
                rowMap.put(header[i], i < row.length ? row[i] : "");
            }
            dataList.add(rowMap);
        }

        br.close();

        // 데이터 출력 (예시로 첫 5개만 출력)
        dataList.stream().limit(5).forEach(System.out::println);
    }
}
