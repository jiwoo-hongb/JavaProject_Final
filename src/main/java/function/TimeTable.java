package function;

import data.Data_read;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TimeTable 클래스는 전공과 교필 과목에 대한 시간표 관리 기능을 제공하는 싱글톤 클래스
 *
 * @author jiwoo-hongb(홍지우, jwhong48 @ gmail.com)
 *
 * @create 2024-11-19
 * @lastModified 2024-12-26
 *
 * @changelog
 * <ul>
 *  <li>2024-11-19: 최초 생성 및 사용자 시간표 반영할 2차원 배열 생성</li>
 *  <li>2024-11-20: 과목 제거 기능 추가<li>
 *  <li>2024-11-26: 배열 초기화 오류 수정</li>
 *  <li>2024-12-23: 교양추천을 위해 배열 넘기기</li>
 *  <li>2024-12-25: Javadoc 작성</li>
 *  <li>2024-12-26: Javadoc 수정</li>
 *  </ul>
 *
 * <p><b>주요 기능:</b>
 * <ul>
 * <li>과목을 시간표에 추가</li>
 * <li>시간표에서 과목 제거</li>
 * <li>과목의 시간 정보는 외부 데이터 파일에서 읽어들여 시간표에 반영</li>
 * <li>시간표 출력</li>
 * </ul>
 * </p>
 *
 */
public class TimeTable {

    /**
     * <ul><li>싱글톤 인스턴스를 저장하는 변수</li></ul>
     * */
    private static TimeTable instance;

    /**
     * <ul><li>시간표를 저장하는 2D 배열 (5x9)</li></ul>
     */
    private final String[][] timetable;

    /**
     * <ul><li>과목별 시간 정보를 저장하는 맵</li></ul>
     */
    private final Map<String, String> subjectTimes;

    /**
     * <ul><li>데이터 로드 객체</li></ul>
     */
    private final Data_read dataRead;

    /**
     * <ul>
     * <li>TimeTable 클래스의 생성자로, 데이터 로드 및 시간표 초기화를 수행</li>
     * <li>외부에서 직접 호출할 수 없으며, 싱글톤 패턴을 따름</li>
     * </ul>
     */
    public TimeTable() {
        this.dataRead = new Data_read();
        this.timetable = new String[5][9]; // 시간표 배열 초기화
        this.subjectTimes = new HashMap<>();
        initializeTimetable(); // 시간표 초기화
        loadSubjectTimes();    // 과목 시간 정보 로드
    }

    /**
     * <ul><li>싱글톤 인스턴스를 반환</li></ul>
     *
     * @return TimeTable 인스턴스
     */
    public static TimeTable getInstance() {
        if (instance == null) {
            instance = new TimeTable();
        }
        return instance;
    }

    /**
     * <ul><li>시간표를 초기화하여 모든 셀을 null로 설정합니다.</li></ul>
     */
    private void initializeTimetable() {
        for (int i = 0; i < timetable.length; i++) {
            for (int j = 0; j < timetable[i].length; j++) {
                timetable[i][j] = null;
            }
        }
    }

    /**
     * <ul><li>데이터 파일에서 과목 시간 정보를 로드하여 subjectTimes 맵에 저장</li></ul>
     */
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

    /**
     * <ul>
     * <li>주어진 과목을 시간표에 추가</li>
     * <li>과목의 시간 정보가 없거나 시간표에 중복이 있을 경우 추가되지 않음</li>
     * </ul>
     *
     * @param subject 추가할 과목명
     * @return 과목이 정상적으로 추가되면 true, 그렇지 않으면 false
     */
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

    /**
     * <ul>
     * <li>과목의 시간을 시간표에 반영</li>
     * <li>주어진 시간에 이미 과목이 있으면 충돌로 간주하여 false를 반환</li>
     * </ul>
     *
     * @param subject 추가할 과목명
     * @param time 과목의 시간 정보
     * @return 과목이 정상적으로 추가되면 true, 그렇지 않으면 false
     */
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

    /**
     * <ul><li>현재 시간표를 콘솔에 출력</li></ul>
     */
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

    /**
     * <ul><li>요일 문자열을 인덱스로 변환</li></ul>
     *
     * @param dayString 요일 문자열 (예: "월", "화")
     * @return 요일에 해당하는 인덱스 (월요일: 0, 화요일: 1, ...)
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
     * <ul><li>시간표에서 주어진 과목을 제거</li></ul>
     *
     * @param subject 제거할 과목명
     * @return 과목이 제거되었으면 true, 그렇지 않으면 false
     */
    public boolean removeSubjectFromTimetable(String subject) {
        boolean removed = false;
        for (int day = 0; day < timetable.length; day++) {
            for (int time = 0; time < timetable[day].length; time++) {
                if (subject.equals(timetable[day][time])) {
                    timetable[day][time] = null; // 과목 삭제
                    removed = true;
                }
            }
        }
        return removed;
    }

    /**
     * <ul><li>인덱스를 요일 문자열로 변환</li></ul>
     *
     * @param dayIndex 요일 인덱스 (0: 월, 1: 화, ...)
     * @return 해당하는 요일 문자열
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

    /**
     * <ul><li>시간표 배열을 반환</li></ul>
     *
     * @return 2D 배열 형태의 시간표
     */
    public String[][] getTimetable() {
        return timetable;
    }
}
