package csvfilefindertest.src.function;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CsvFileReader {

	private List<String[]> list = new ArrayList<>();

	private List<Question> questionList = new ArrayList<>();

	public List<String[]> readCsvFile(Path selectedFile) {
		
		try (BufferedReader reader = Files.newBufferedReader(selectedFile)) {
			
			List<String> lineList = new ArrayList<>();
			
			String line;
			
			line = reader.readLine();

			while ((line = reader.readLine()) != null) {

				if (line.startsWith(",")) {
					line = line.replaceFirst("^,", "");
				}

				if (isQuoteUnclosed(line)) {
					line = line.replaceAll("\"", "");
					lineList.add(line);

					if (lineList.size() > 1) {
						line = String.join(", ", lineList);
						lineList.clear();
					}

				} else {
					line = line.replaceAll("\"", "");
				}

				if (lineList.isEmpty()) {

					String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
					System.out.println(Arrays.toString(values));
					System.out.println();

					list.add(values);
				}

			}

		} catch (IOException e) {
			e.printStackTrace();

		}

		return this.list;
	}

	private boolean isQuoteUnclosed(String line) {
		int quoteCount = 0;

		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == '"') {
				quoteCount++;
			}
		}

		return quoteCount % 2 != 0;
	}
}