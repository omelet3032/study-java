package csvfilefindertest.src.function;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CsvFileParser {

	private List<String[]> list;

	private final Pattern CSV_PATTERN = Pattern.compile(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

	public List<String[]> readCsvFile(Path selectedFile) {

		this.list = new ArrayList<>();

		try (BufferedReader reader = Files.newBufferedReader(selectedFile)) {
			
			String line;
			String[] lastValues = null; // 이전 행의 값을 저장할 배열
			boolean appendToPrevious = false; // 이전 설명열에 데이터를 이어붙일지 여부 확인

			while ((line = reader.readLine()) != null) {
				// 첫 번째 쉼표가 아닌 문자가 있는지 확인: 이 경우 이전 설명 열에 이어붙이기
				if (!line.startsWith(",") && lastValues != null) {
					lastValues[lastValues.length - 1] += " " + line.trim(); // 설명 열에 개행된 부분 붙이기
					appendToPrevious = true;
					continue; // 병합 후 다음 라인을 읽음
				}

				// 쉼표로 데이터 분리 (CSV 정규식)
				String[] values = splitCsv(line);

				// 이전 줄에 이어붙여야 하는 경우
				if (appendToPrevious && lastValues != null) {
					lastValues[lastValues.length - 1] += " " + values[0].trim(); // 설명 열에 데이터 병합
					appendToPrevious = false; // 병합 후 상태 초기화
					continue;
				}

				// 읽은 값을 리스트에 추가
				list.add(values);
				lastValues = values; // 현재 줄을 저장하여 다음 줄과 비교
			}

			// 리스트 내용 출력
			for (String[] arr : list) {
				System.out.println(Arrays.toString(arr));
			}

			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.list;
	}

	// CSV를 패턴으로 나누는 메서드
	private String[] splitCsv(String line) {
		Matcher matcher = CSV_PATTERN.matcher(line);
		return line.split(CSV_PATTERN.pattern());
	}
}