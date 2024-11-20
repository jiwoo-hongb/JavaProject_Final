package function;

import data.Data_read;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeTable {
    Data_read dataRead = new Data_read();
    private String[][] timetable; // 5일(월~금), 9교시 시간표
    private Map<String, String> subjectTimes; // 과목별 시간 데이터 매핑

    public TimeTable() {
        timetable = new String[5][9]; // 5일, 9교시 시간표 배열
        subjectTimes = new HashMap<>();

        // 시간표 초기화
        for (int i = 0; i < timetable.length; i++) {
            for (int j = 0; j < timetable[i].length; j++) {
                timetable[i][j] = null; // 비어있는 시간 (null)
            }
        }

        // CSV 데이터 로드 및 과목 시간 정보 저장
        loadSubjectTimes();
    }

    /**
     * CSV 데이터를 읽어와 과목 시간 정보를 저장합니다.
     */
    private void loadSubjectTimes() {
        Data_read dataRead = new Data_read();
        List<String[]> rows = dataRead.getRows();

        for (String[] row : rows) {
            if (row.length > 2) { // "시간" 필드가 존재한다고 가정
                String subject = row[0].trim(); // 교과목 이름
                String time = row[2].trim();    // 시간 정보 (예: "금(1,2,3)")
                subjectTimes.put(subject, time);
            }
        }
    }

    /**
     * 사용자가 클릭한 과목을 시간표에 추가합니다.
     *
     * @param subject 과목 이름
     * @return 추가 성공 여부
     */
    public boolean addSubjectToTimetable(String subject) {
        // 과목의 시간 정보를 가져옵니다.
        String time = subjectTimes.get(subject);

        if (time == null) {
            System.out.println("Error: Subject not found in the timetable.");
            return false;
        }

        // 시간 정보를 파싱하여 시간표에 반영합니다.
        if (applyTimeToTimetable(subject, time)) {
            System.out.println(subject + " has been added to the timetable.");
            return true;
        } else {
            System.out.println(subject + " could not be added due to time conflicts.");
            return false;
        }
    }

    /**
     * 시간 정보를 파싱하고 시간표 배열에 반영합니다.
     *
     * @param subject 과목 이름
     * @param time    시간 정보 (예: "금(1,2,3)")
     * @return 추가 성공 여부
     */
    private boolean applyTimeToTimetable(String subject, String time) {
        // 예: "금(1,2,3)" -> day = 4 (금요일), periods = [1, 2, 3]
        String[] parts = time.split("\\(");
        if (parts.length < 2) return false;

        String dayString = parts[0].trim();
        String periodsString = parts[1].replace(")", "").trim();
        int day = dayStringToIndex(dayString);
        if (day == -1) return false; // 잘못된 요일

        // 시간대를 파싱
        String[] periods = periodsString.split(",");
        for (String period : periods) {
            int periodIndex = Integer.parseInt(period.trim()) - 1; // 1교시 -> 인덱스 0
            if (timetable[day][periodIndex] != null) {
                // 이미 다른 과목이 들어있는 경우
                System.out.println("Time conflict at day " + dayString + ", period " + period + ".");
                return false;
            }
        }

        // 시간표에 과목 추가
        for (String period : periods) {
            int periodIndex = Integer.parseInt(period.trim()) - 1;
            timetable[day][periodIndex] = subject;
        }

        return true;
    }

    public boolean removeSubjectFromTimetable(String subject) {
        // 시간표에서 과목을 찾아 제거
        boolean removed = false;

        for (int day = 0; day < timetable.length; day++) {
            for (int time = 0; time < timetable[day].length; time++) {
                if (subject.equals(timetable[day][time])) {
                    timetable[day][time] = null; // 해당 과목 제거
                    removed = true;
                }
            }
        }

        return removed; // 과목이 제거되었는지 여부 반환
    }


    /**
     * 요일 문자열을 배열 인덱스로 변환합니다.
     *
     * @param dayString 요일 문자열 (예: "월", "화", ..., "금")
     * @return 요일 인덱스 (0: 월요일, ..., 4: 금요일), 잘못된 요일은 -1 반환
     */
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

    /**
     * 현재 시간표를 출력합니다.
     */
    public void printTimetable() {
        System.out.println("Current Timetable:");
        for (int i = 0; i < timetable.length; i++) {
            System.out.print(dayIndexToString(i) + ": ");
            for (int j = 0; j < timetable[i].length; j++) {
                if (timetable[i][j] == null) {
                    System.out.print("[ ] ");
                } else {
                    System.out.print("[" + timetable[i][j] + "] ");
                }
            }
            System.out.println();
        }
    }

    /**
     * 요일 인덱스를 문자열로 변환합니다.
     *
     * @param dayIndex 요일 인덱스 (0: 월요일, ..., 4: 금요일)
     * @return 요일 문자열
     */
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
