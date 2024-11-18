package data;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class Test_Dataread {
    public static void main (String[] args) throws CsvValidationException, IOException {
        CSVReader reader = new CSVReader(new FileReader("src/data/전공_교필_강의 데이터.csv"));
        String[] line;
        while ((line = reader.readNext()) != null) {
            System.out.println(String.join(",", line));
        }
    }
}
