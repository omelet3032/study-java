import java.util.ArrayList;
import java.util.List;

public class StringProcessor {
    @FunctionalInterface
    interface StringFilter {
        boolean test(String s);
    }

    @FunctionalInterface
    interface StringTransformer {
        String transform(String s);
    }

    public static List<String> processStrings(List<String> input, StringFilter filter, StringTransformer transformer) {
        List<String> result = new ArrayList<>();
        // 여기에 코드를 작성하세요
        boolean isOverFive;
        String word;

        for (int i = 0; i < input.size(); i++) {
            word = input.get(i);
            isOverFive = filter.test(word);
            if (isOverFive) {
                String transWord = transformer.transform(word);
                result.add(transWord);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<String> words = List.of("apple", "banana", "cherry", "date", "elderberry");

        // processStrings 메서드를 호출하여 다음을 수행하세요:
        // 1. 길이가 5 이상인 단어만 선택
        // 2. 선택된 단어를 대문자로 변환
        // 람다 표현식을 사용하세요

        /* 
         * 익명 클래스
         * 
         * List<String> processedWords = processStrings(words, new StringFilter() {
         * 
         * @Override
         * public boolean test(String word) {
         * int wordLength = word.length();
         * return wordLength >= 5 ? true : false;
         * }
         * }, new StringTransformer() {
         * 
         * @Override
         * public String transform(String word) {
         * String upperCaseWord = word.toUpperCase();
         * return upperCaseWord;
         * }
         * });
         */

        List<String> processedWords = processStrings(words,
                word -> {
                    int wordLength = word.length();
                    return wordLength >= 5 ? true : false;
                }, word -> {
                    String upperCaseWord = word.toUpperCase();
                    return upperCaseWord;

                });

        // 여기에 코드를 작성하세요

        System.out.println(processedWords);
    }
}