//package function;
//
//import gui.Main_Gui;
//
//public class TimetableProcessor {
//    Main_Gui main = new Main_Gui();
//    public void fillEmptySlotsWithZero() {
//        // TimeTable 인스턴스 가져오기
//        TimeTable timetableInstance = TimeTable.getInstance();
//
//        // 현재 시간표 가져오기
//        String[][] timetable = timetableInstance.getTimetable();
//
//        // 시간표 배열 순회
//        for (int i = 0; i < timetable.length; i++) {
//            for (int j = 0; j < timetable[i].length; j++) {
//                if (timetable[i][j] == null) { // 빈 칸 확인
//                    timetable[i][j] = "0";    // 빈 칸에 "0" 채우기
//                }
//            }
//        }
//
//        System.out.println("Updated Timetable with 0 in empty slots:");
//        printTimetable(timetable);
//    }
//
//    // 시간표 출력
//    private void printTimetable(String[][] timetable) {
//        for (int i = 0; i < timetable.length; i++) {
//            for (int j = 0; j < timetable[i].length; j++) {
//                System.out.print((timetable[i][j] == null ? "[ ]" : "[" + timetable[i][j] + "]") + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    public static void main(String[] args) {
//        // TimetableProcessor 실행
//        TimetableProcessor processor = new TimetableProcessor();
//        processor.fillEmptySlotsWithZero();
//    }
//}
