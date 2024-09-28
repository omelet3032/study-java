import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {

    public static void main(String[] args) {

        String line = "2,프로토타입,객체";

        String[] values = line.split(",");

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
