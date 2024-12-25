package function;

import java.util.*;
import data.Data_read2;

public class TimeTable2 {

    public static Map<String, List<String>> getRecommendations(String[][] timetable, Data_read2 dataReader) {
        Map<String, List<String>> recommendations = new LinkedHashMap<>();
        Map<String, String> subjectTimes = dataReader.getSubjectTimes();

        String[] days = {"월", "화", "수", "목", "금"};
        for (String day : days) {
            recommendations.put(day, new ArrayList<>());
        }

        for (Map.Entry<String, String> entry : subjectTimes.entrySet()) {
            String subject = entry.getKey();
            String time = entry.getValue();

            try {
                String[] timeParts = time.split("\\(");
                String day = timeParts[0];
                String[] periods = timeParts[1].replace(")", "").split(",");

                if (!recommendations.containsKey(day)) continue;

                int dayIndex = convertDayToIndex(day);
                if (dayIndex < 0 || dayIndex >= timetable.length) continue;

                boolean canAdd = true;

                for (String periodStr : periods) {
                    int period = Integer.parseInt(periodStr) - 1;
                    if (period < 0 || period >= timetable[dayIndex].length) {
                        canAdd = false;
                        break;
                    }

                    if (timetable[dayIndex][period] != null) {
                        canAdd = false;
                        break;
                    }
                }

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