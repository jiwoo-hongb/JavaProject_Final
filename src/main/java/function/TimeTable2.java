package function;

import data.Data_read2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TimeTable2 {
    public static List<String> getEmptySlotsAndFill(String[][] timetable, Data_read2 dataReader, String day) {
        List<String> dayList = new ArrayList<>();
        Map<String, String> subjectTimes = dataReader.getSubjectTimes();

        for (Map.Entry<String, String> entry : subjectTimes.entrySet()) {
            String subject = entry.getKey();
            String time = entry.getValue();

            if (time.contains(day)) {
                String[] times = time.replace(day, "").replace("(", "").replace(")", "").split(",");
                boolean canAdd = true;

                for (String t : times) {
                    try {
                        int period = Integer.parseInt(t) - 1; // 교시를 인덱스로 변환
                        int dayIndex = convertDayToIndex(day);

                        // 유효성 검사: 시간표 범위를 초과하지 않는지 확인
                        if (period < 0 || period >= timetable[dayIndex].length || timetable[dayIndex][period] != null) {
                            canAdd = false;
                            break;
                        }
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                        System.err.println("Invalid period or index out of bounds: " + t);
                        canAdd = false;
                        break;
                    }
                }

                if (canAdd) {
                    dayList.add(subject);

                    for (String t : times) {
                        int period = Integer.parseInt(t) - 1;
                        int dayIndex = convertDayToIndex(day);
                        timetable[dayIndex][period] = subject; // 시간표에 추가
                    }
                }
            }
        }
        return dayList;
    }

    private static int convertDayToIndex(String day) {
        switch (day) {
            case "월": return 0;
            case "화": return 1;
            case "수": return 2;
            case "목": return 3;
            case "금": return 4;
            default: throw new IllegalArgumentException("잘못된 요일 입력: " + day);
        }
    }
}
