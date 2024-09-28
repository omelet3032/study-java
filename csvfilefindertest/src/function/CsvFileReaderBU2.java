package csvfilefindertest.src.function;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderBU2 {

	private Question question;

	private List<Question> list = new ArrayList<>();

	public List<Question> readCsvFile(Path selectedFile) {

		try (BufferedReader reader = Files.newBufferedReader(selectedFile)) {

			String line;
			line = reader.readLine();

			String[] values;
			int quoteIndex = line.indexOf("\"");
			String quote = "\"";

			StringBuilder conceptBuilder;
			StringBuilder descriptionBuilder;

			while ((line = reader.readLine()) != null) {

				conceptBuilder = new StringBuilder();
				descriptionBuilder = new StringBuilder();

				if (!line.contains(quote)) {
					System.out.println("1번 조건문");
					values = line.split(",");

					question = new Question();

					conceptBuilder.append(values[0]);
					descriptionBuilder.append(values[1]);

					question.setConcept(conceptBuilder.toString());
					question.setDescription(descriptionBuilder.toString());

					list.add(question);
					continue;
				}

				if (line.contains(quote)) {
					
				}
				// 따옴표가 line의 중간에 있는 경우
				if (quoteIndex != -1 && quoteIndex != 0 && quoteIndex != line.length() - 1) {
					System.out.println("2번 조건문");
					line = line.replaceAll(quote, "");
					values = line.split(",");

					conceptBuilder.append(values[0]);
					question.setConcept(conceptBuilder.toString());

					if (values.length > 2) {

						for (int i = 1; i < values.length - 1; i++) {
							descriptionBuilder.append(values[i]);
							if (i != values.length - 1) {
								descriptionBuilder.append(",");
							}
						}

						question.setDescription(descriptionBuilder.toString());

					} else {
						descriptionBuilder.append(values[1]);
						question.setDescription(descriptionBuilder.toString());
					}
					continue;

				} else if (quoteIndex == line.length() - 1) {
					System.out.println("3번 조건문");
					line = line.replaceAll(quote, "");

					String description = question.getDescription();
					descriptionBuilder.append(description).append(",").append(line);

					question.setDescription(descriptionBuilder.toString());
					list.add(question);
				}

			}
		
	
		} catch (

		IOException e) {
			e.printStackTrace();

		}
		return this.list;
	}

}