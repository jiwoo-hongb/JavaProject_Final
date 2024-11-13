package data;

public class TimeTable {
    public static void main(String[] args) {
        // 요일별 배열: 월요일부터 금요일까지 (0: 월요일, 1: 화요일, ..., 4: 금요일)
        String[][] timetable = new String[5][9];

        // 시간표 초기화 (빈 시간은 null로 설정)
        for (int i = 0; i < timetable.length; i++) {
            for (int j = 0; j < timetable[i].length; j++) {
                timetable[i][j] = null;  // 비어있는 시간 (null로 초기화)
            }
        }
    }
}
