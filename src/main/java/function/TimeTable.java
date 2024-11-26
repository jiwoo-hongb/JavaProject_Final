package function;

import data.Data_read;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeTable {
    private static TimeTable instance; // 싱글톤 인스턴스
    private final String[][] timetable; // 시간표 배열
    private final Map<String, String> subjectTimes; // 과목별 시간 데이터 매핑
    private final Data_read dataRead; // 데이터 로드 객체

    // 생성자: 외부에서 직접 호출하지 못하도록 private
    private TimeTable() {
        this.dataRead = new Data_read();
        this.timetable = new String[5][9]; // 시간표 배열 초기화
        this.subjectTimes = new HashMap<>();
        initializeTimetable(); // 시간표 초기화
        loadSubjectTimes();    // 과목 시간 정보 로드
    }

    // 싱글톤 인스턴스를 반환
    public static TimeTable getInstance() {
        if (instance == null) {
            instance = new TimeTable();
        }
        return instance;
    }

    // 시간표 초기화
    private void initializeTimetable() {
        for (int i = 0; i < timetable.length; i++) {
            for (int j = 0; j < timetable[i].length; j++) {
                timetable[i][j] = null;
            }
        }
    }

    // 데이터 로드
    private void loadSubjectTimes() {
        List<String[]> rows = dataRead.getRows();
        for (String[] row : rows) {
            if (row.length > 2) {
                String subject = row[0].trim();
                String time = row[2].trim();
                subjectTimes.put(subject, time);
            }
        }
    }

    // 과목 추가 로직
    public boolean addSubjectToTimetable(String subject) {
        System.out.println("Adding subject: " + subject);
        String time = subjectTimes.get(subject);
        if (time == null) {
            System.out.println("Subject not found.");
            return false;
        }

        if (applyTimeToTimetable(subject, time)) {
            System.out.println("Subject added successfully.");
            return true;
        } else {
            System.out.println("Failed to add subject due to time conflicts.");
            return false;
        }
    }

    // 시간표에 반영
    private boolean applyTimeToTimetable(String subject, String time) {
        String[] parts = time.split("\\(");
        if (parts.length < 2) return false;

        String dayString = parts[0].trim();
        String periodsString = parts[1].replace(")", "").trim();
        int day = dayStringToIndex(dayString);

        if (day == -1) return false;

        String[] periods = periodsString.split(",");
        for (String period : periods) {
            int periodIndex = Integer.parseInt(period.trim()) - 1;
            if (timetable[day][periodIndex] != null) {
                System.out.println("Time conflict: " + dayString + " " + period + "교시.");
                return false;
            }
        }

        for (String period : periods) {
            int periodIndex = Integer.parseInt(period.trim()) - 1;
            timetable[day][periodIndex] = subject;
        }
        return true;
    }

    // 시간표 출력
    public void printTimetable() {
        System.out.println("Current Timetable:");
        for (int i = 0; i < timetable.length; i++) {
            System.out.print(dayIndexToString(i) + ": ");
            for (int j = 0; j < timetable[i].length; j++) {
                System.out.print(timetable[i][j] == null ? "[ ] " : "[" + timetable[i][j] + "] ");
            }
            System.out.println();
        }
    }

    // 요일 문자열 -> 인덱스
    private int dayStringToIndex(String dayString) {
        switch (dayString) {
            case "월": return 0;
            case "화": return 1;
            case "수": return 2;
            case "목": return 3;
            case "금": return 4;
            default: return -1;
        }
    }

    // 인덱스 -> 요일 문자열
    private String dayIndexToString(int dayIndex) {
        switch (dayIndex) {
            case 0: return "월";
            case 1: return "화";
            case 2: return "수";
            case 3: return "목";
            case 4: return "금";
            default: return "";
        }
    }
}
