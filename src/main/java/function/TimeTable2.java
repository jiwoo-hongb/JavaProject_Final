package function;

import java.util.*;
import data.Data_read2;

public class TimeTable2 {

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

    public boolean isTimeSlotAvailable(String day, String subject) {
        return false;
    }
}