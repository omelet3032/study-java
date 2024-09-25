package csvfilefindertest.src.function;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvFileReader2 {

	private List<String[]> list;

	public List<String[]> readCsvFile(Path selectedFile) {

		this.list = new ArrayList<>();

		try (BufferedReader reader = Files.newBufferedReader(selectedFile)) {

			String line;
			line = reader.readLine();

			String[] lastValues = null;
			
			while ((line = reader.readLine()) != null) {
				// "연관된 서브 클래스를 묶어 한 번에 교체하는 것이 가능\"";
				if (line.startsWith(",")) {
					line = line.replaceFirst("^,", "");
				}

				String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
				System.out.println("line의 내용 : " + Arrays.toString(values));
				System.out.println("길이 : " + values.length);

				if (values.length == 1) {
					String[] beforeValues = list.get(list.size() - 1); // {유진우, 박설화, 대장군}
					String[] copyValues = new String[beforeValues.length + values.length];

					System.arraycopy(beforeValues, 0, copyValues, 0, beforeValues.length);
					System.arraycopy(values, 0, copyValues, beforeValues.length, values.length);

					// list.add(copyValues);
					list.set(list.size() - 1, copyValues);
				}

				list.add(values);

				// System.out.println(list.get(0).toString());

			}

		} catch (IOException e) {
			e.printStackTrace();

		}

		return this.list;
	}

}