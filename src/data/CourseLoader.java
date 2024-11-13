package data;

//test 전공 데이터 가져오는 중
import java.io.*;
import java.util.*;

public class CourseLoader {
    private List<String[]> courses;  // 과목 정보 배열을 저장할 리스트

    public CourseLoader() {
        courses = new ArrayList<>();
        loadCourses();  // CSV 파일에서 데이터 로드
    }

    // CSV 파일을 읽어서 과목 정보를 리스트에 저장
    private void loadCourses() {
        String csvFilePath = "src/data/전공 강의 데이터.csv";  // CSV 파일 경로
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            reader.readLine();  // 첫 번째 줄(헤더)은 건너뜀
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 5) {
                    continue; // CSV 형식이 잘못된 경우 처리 (항목이 5개 미만이면 무시)
                }
                courses.add(data);  // 과목 정보를 리스트에 추가
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 과목명을 통해 해당 과목의 세부 정보를 반환
    public String getCourseDetails(String courseName) {
        for (String[] course : courses) {
            String courseTitle = course[0].trim();  // 과목명
            if (courseTitle.equals(courseName.trim())) {  // 공백을 제거하고 비교
                // 과목명이 일치하면 해당 과목의 세부 정보 반환
                return "교수: " + course[1].trim() + ", 시간: " + course[2].trim() + ", 장소: " + course[3].trim() + ", 학점: " + course[4].trim();
            } else {
                return "정보 없음";  // 과목명이 없으면 "정보 없음" 반환
            }
        }
        return "";
    }
}
