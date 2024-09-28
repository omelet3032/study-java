package csvfilefindertest.src;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import csvfilefindertest.src.function.CsvFileReader;
import csvfilefindertest.src.function.Question;

public class FileFinder {

    public void find() {
        CsvFileReader csvFileReader = new CsvFileReader();

        Path selectedFile = Paths.get("/home/omelet1/dev3/study-java/csvfilefindertest/csv/omelet2.csv");
        List<Question> list = csvFileReader.readCsvFile(selectedFile);

        System.out.println();
        System.out.println("-------------");
        System.out.println("최종 list");
        for (Question question : list) {
            System.out.println(question.toString());
            System.out.println();
        }
    }

}
