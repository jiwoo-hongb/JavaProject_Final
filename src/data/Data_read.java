package data;


import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data_read {
    public static void main(String[] args) {
        CSVReader
        // 반환용 리스트 변수
        List<Map<String, String>> ret = new ArrayList<>();
        // 입력 스트림 오브젝트 생성
        BufferedReader br = null;

        try {
            // 대상 CSV 파일의 경로 설정
            br = Files.newBufferedReader(Paths.get("src/data/교양 강의 정보.csv"));
            // CSV 파일에서 읽어들인 1행분의 데이터
            String line = "";

            // 헤더 키 배열 설정 (예: 과목이름, 교수, 강의 방법, 장소, 학점, 영역, 시간)
            String[] keys = {"과목이름", "교수", "강의 방법", "장소", "시간", "학점", "영역"};

            while ((line = br.readLine()) != null) {
                // CSV 파일의 1행을 ','로 나누어 배열로 저장
                String[] values = line.split(",");
                // 키-값 맵 생성
                Map<String, String> map = new HashMap<>();

                // 키와 값을 매핑, 빈 값은 "0"으로 설정
                for (int i = 0; i < keys.length; i++) {
                    if (i < values.length && !values[i].trim().isEmpty()) {
                        // 장소와 시간 구분
                        if (keys[i].equals("장소")) {
                            String[] placeTime = values[i].split(":");
                            if (placeTime.length == 2) {
                                map.put("장소", placeTime[0].trim());
                                map.put("시간", placeTime[1].trim());
                            } else {
                                map.put("장소", values[i].trim());
                                map.put("시간", "0");
                            }
                        } else {
                            map.put(keys[i], values[i].trim());
                        }
                    } else {
                        map.put(keys[i], "0");
                    }
                }

                // 맵 내용 출력
                System.out.println(map);
                // 반환용 리스트에 맵을 저장
                ret.add(map);
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
    }
}
