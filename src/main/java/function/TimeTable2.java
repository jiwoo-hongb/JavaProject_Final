package function;

import java.util.*;
import data.Data_read2;

public class TimeTable2 {

    public static Map<String, List<String>> getRecommendations(String[][] timetable, Data_read2 dataReader) {
        // LinkedHashMap을 사용하여 요일 순서 유지
        Map<String, List<String>> recommendations = new LinkedHashMap<>();
        Map<String, String> subjectTimes = dataReader.getSubjectTimes();

        // 요일별 초기화
        String[] days = {"월", "화", "수", "목", "금"};
        for (String day : days) {
            recommendations.put(day, new ArrayList<>());
        }

        // 각 과목을 시간표와 비교하여 추천 리스트에 추가
        for (Map.Entry<String, String> entry : subjectTimes.entrySet()) {
            String subject = entry.getKey();
            String time = entry.getValue();

            // 시간 정보를 파싱
            String[] timeParts = time.split("\\(");
            String day = timeParts[0]; // 요일
            String[] periods = timeParts[1].replace(")", "").split(",");

            if (recommendations.containsKey(day)) {
                boolean canAdd = true;

                // timetable과 충돌 체크
                for (String periodStr : periods) {
                    try {
                        int period = Integer.parseInt(periodStr) - 1;
                        int dayIndex = convertDayToIndex(day);

                        // **배열 범위 검사**
                        if (dayIndex < 0 || dayIndex >= timetable.length || period < 0 || period >= timetable[0].length) {
                            System.out.println("잘못된 시간 정보: " + subject + " - " + periodStr);
                            canAdd = false;
                            break;
                        }

                        // timetable에 이미 다른 과목이 있으면 추가 불가
                        if (timetable[dayIndex][period] != null) {
                            canAdd = false;
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("잘못된 시간 형식: " + subject + " - " + periodStr);
                        canAdd = false;
                        break;
                    }
                }

                // timetable과 충돌이 없으면 추천 리스트에 추가
                if (canAdd) {
                    recommendations.get(day).add(subject);
                }
            }
        }
        return recommendations;
    }

    /**
     * 요일을 배열 인덱스로 변환하는 메서드.
     *
     * @param day 요일 문자열
     * @return 요일에 해당하는 배열 인덱스
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
}
