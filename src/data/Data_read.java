package data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data_read {

    public static void main(String[] args) {

        // 반환용 리스트 변수
        List<List<String>> ret = new ArrayList<>();
        // 추출할 특정 인덱스 리스트
        List<List<String>> extractedData = new ArrayList<>();
        // 입력 스트림 오브젝트 생성
        BufferedReader br = null;

        try {
            // 대상 CSV 파일의 경로 설정
            br = Files.newBufferedReader(Paths.get("src/data/교양강의 정보.csv"));
            // CSV파일에서 읽어들인 1행분의 데이터
            String line = "";

            while ((line = br.readLine()) != null) {
                // CSV 파일의 1행을 저장하는 리스트 변수
                List<String> tmpList = Arrays.asList(line.split(","));
                // 반환용 리스트에 1행의 데이터를 저장
                ret.add(tmpList);

                // 인덱스 2, 5, 18, 35번째 원소 추출 (배열 인덱스는 0부터 시작)
                List<String> selectedElements = new ArrayList<>();
                if (tmpList.size() > 35) { // 인덱스가 존재하는지 확인
                    selectedElements.add(tmpList.get(2));
                    selectedElements.add(tmpList.get(5));
                    selectedElements.add(tmpList.get(18));
                    selectedElements.add(tmpList.get(35));
                    selectedElements.add(tmpList.get(40));
                    extractedData.add(selectedElements);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 결과 출력
        for (List<String> row : extractedData) {
            System.out.println(row);
        }
    }
}
