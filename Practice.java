import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {

    public static void main(String[] args) {

        String[] values6 = new String[]{"유","진","우"};

        System.out.println("values6 길이 : " + values6.length);

        String line6 = "4,유진우,\"객체\"";

        int quote = line6.indexOf("\"");

        int lastQuote = line6.lastIndexOf("\"");

        System.out.println("quote : " + quote);
        System.out.println("lastQuote : " + lastQuote);
        System.out.println(line6.length());



        List<String> list3 = List.of("유진우", "박설화");
        System.out.println(list3);

        String line2 = "유진우";
        String[] line2Value = line2.split(",");

        System.out.println(Arrays.toString(line2Value));

        // 연관된 서브 클래스를 묶어 한 번에 교체하는 것이 가능"

        String line = "4,추상팩토리(Abstract Factory),인터페이스를 통해 서로 연관, 의존하는 객체들의 그룹으로 생성하여 추상적으로 표현";

        // 내 목표 : String을 요소별로 나누어 객체의 필드로 할당하기
        line = line.replaceAll("\"", "");

        String[] values = line.split(",");

        Question question = new Question();

        question.setId(Integer.parseInt(values[0]));
        question.setConcept(values[1]);
        question.setDescription(values[2]);

        if (values.length > 3) {
            StringBuilder description = new StringBuilder();
            for (int i = 2; i < values.length - 1; i++) {
                description.append(values[i]).append(",").append(values[++i]);
            }
            System.out.println(description.toString());
            question.setDescription(description.toString());
        }

        System.out.println(question.toString());

        if (!line.contains(",")) {
            System.out.println("유진우");
        }

        System.out.println(values[0] + " " + values[1] + " " + values[2]);

        List<String[]> list = new ArrayList<>();
        List<Question> questionList = new ArrayList<>();

        list.add(values);

        String[] newLine = values[0].split(",");

        System.out.println(Arrays.toString(newLine));

    }
}
