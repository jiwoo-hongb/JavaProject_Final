/**
 * TimeTable2 클래스는 시간표에 교양 과목을 추천하는 기능을 제공합니다.
 * 이 클래스는 과목의 시간 정보와 기존 시간표를 바탕으로, 추가 가능한 교양 과목을 추천합니다.
 *
 * <p><b>주요 기능:</b>
 * <ul>
 * <li>시간표에 교양 과목을 추가할 수 있는지 확인하고 추천 리스트를 생성</li>
 * <li>교양 과목의 시간대와 기존 시간표를 비교하여 추가 가능 여부 확인</li>
 * <li>요일별로 교양 과목을 추천 리스트에 추가</li>
 * </ul>
 * </p>
 *
 * <p><b>사용 예:</b>
 * <pre>
 * TimeTable2 timeTable = new TimeTable2();
 * Map<String, List<String>> recommendations = timeTable.getRecommendationsRefactored(timetable, dataReader);
 * </pre>
 * </p>
 */
package function;

import java.util.*;
import data.Data_read2;

public class TimeTable2 {

    /**
     * 주어진 시간표와 교양 과목 데이터에서 추가 가능한 교양 과목을 추천합니다.
     * 각 요일별로 추가 가능한 교양 과목을 추천 리스트로 반환합니다.
     *
     * <p><b>추천 방법:</b>
     * <ul>
     * <li>각 과목의 시간대가 시간표와 겹치지 않으면 해당 과목을 추천 리스트에 추가</li>
     * </ul>
     * </p>
     *
     * @param timetable 시간표 배열 (2D 배열 형태)
     * @param dataReader 교양 과목 시간 데이터를 읽어오는 객체
     * @return 각 요일별로 추가 가능한 교양 과목 리스트
     */
    public static Map<String, List<String>> getRecommendationsRefactored(String[][] timetable, Data_read2 dataReader) {
        // 1. 요일별 리스트 준비
        Map<String, List<String>> recommendations = new LinkedHashMap<>();
        String[] days = {"월", "화", "수", "목", "금"};
        for (String day : days) {
            recommendations.put(day, new ArrayList<>());
        }

        // 2. 교양 과목 시간 데이터 가져오기
        Map<String, String> subjectTimes = dataReader.getSubjectTimes();

        // 3. 교양 과목 추가 조건 검사
        for (Map.Entry<String, String> entry : subjectTimes.entrySet()) {
            String subject = entry.getKey(); // 과목명
            String time = entry.getValue(); // 시간 정보 (e.g., "월(1,2,3)")

            try {
                // 과목의 요일과 시간 정보 추출
                String[] timeParts = time.split("\\("); // "월(1,2,3)" -> ["월", "1,2,3)"]
                String day = timeParts[0]; // 요일 추출
                String[] periods = timeParts[1].replace(")", "").split(","); // 시간대 추출

                // 요일이 recommendations에 없으면 스킵
                if (!recommendations.containsKey(day)) continue;

                // 예약된 시간과 비교
                int dayIndex = convertDayToIndex(day); // 요일 -> 인덱스 변환
                if (dayIndex < 0 || dayIndex >= timetable.length) continue;

                boolean canAdd = true;
                for (String periodStr : periods) {
                    int period = Integer.parseInt(periodStr) - 1; // 1부터 시작하는 시간대를 0부터로 변환
                    if (period < 0 || period >= timetable[dayIndex].length || timetable[dayIndex][period] != null) {
                        canAdd = false;
                        break;
                    }
                }

                // 조건 만족 시 해당 요일 리스트에 추가
                if (canAdd) {
                    recommendations.get(day).add(subject);
                }
            } catch (Exception e) {
                System.out.println("Error processing subject: " + subject + ", time: " + time);
            }
        }

        return recommendations;
    }

    /**
     * 요일 문자열을 인덱스(0~4)로 변환합니다.
     *
     * @param day 요일 문자열 ("월", "화", "수", "목", "금")
     * @return 해당 요일에 해당하는 인덱스 (월: 0, 화: 1, ..., 금: 4)
     */
    private static int convertDayToIndex(String day) {
        switch (day) {
            case "월": return 0;
            case "화": return 1;
            case "수": return 2;
            case "목": return 3;
            case "금": return 4;
            default:
                System.out.println("잘못된 요일: " + day);
                return -1; // 잘못된 요일은 -1 반환
        }
    }

    /**
     * 시간대가 비어 있는지 확인하는 메서드 (현재 구현되지 않음).
     *
     * @param day 과목이 추가될 요일
     * @param subject 확인할 과목
     * @return 항상 false를 반환 (현재 미구현)
     */
    public boolean isTimeSlotAvailable(String day, String subject) {
        return false;
    }
}
