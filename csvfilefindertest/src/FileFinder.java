package csvfilefindertest.src;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import csvfilefindertest.src.function.CsvFileFinder;
import csvfilefindertest.src.function.CsvFileParser;
import csvfilefindertest.src.function.CsvFileReader;

public class FileFinder {

    public void find() {
        CsvFileReader csvFileReader = new CsvFileReader();
        CsvFileFinder csvFileFinder = new CsvFileFinder();
        CsvFileParser csvFileParser = new CsvFileParser();

        Path selectedFile = Paths.get("/home/omelet1/dev3/study-java/csvfilefindertest/csv/omelet1.csv");
        System.out.println(selectedFile.toString());
        // List<String[]> list = csvFileReader.readCsvFile(selectedFile);
        // List<String[]> list = csvFileParser.readCsvFile(selectedFile);
        List<String[]> list = csvFileReader.readCsvFile(selectedFile);

        // for (String[] arr : list) {
        //     System.out.println(Arrays.toString(arr));
        // }

    }

}
