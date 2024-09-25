package collectionarray.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringArrayExample {

    public static void main(String[] args) {

        List<String[]> list = new ArrayList<>();

        String line = ",4,추상팩토리(Abstract Factory),\"인터페이스를 통해 서로 연관, 의존하는 객체들의 그룹으로 생성하여 추상적으로 표현";

        for (int i = 0; i < line.length(); i++) {
            line = line.replaceFirst("^,", "");
        }

        System.out.println("첫 번째 쉼표 제거 : " + line);
        
        System.out.println();

        String[] parts1 = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

        System.out.println("설명란의 ,를 제외한 나머지 기준 : " + Arrays.toString(parts1));
        list.add(parts1);

        System.out.println();

        // 다음 행

        String line2 = "연관된 서브 클래스를 묶어 한 번에 교체하는 것이 가능\"";
        String[] parts2 = new String[1];
        parts2[0] = line2;

        String[] e = new String[1];
        e[0] = list.get(list.size()-1) + parts2[0];
        list.set(list.size()-1,  e);

        
        for (String[] values : list) {
            for (String a : values) {
                System.out.println(a);
            }
        }



        // System.out.println(Arrays.toString(list.get(0)));

    }

}