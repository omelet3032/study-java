import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StreamPractice1 {
    public static void main(String[] args) {
        
        /*
         * 다음 작업을 스트림을 사용하여 수행하세요:
         * 
         * 1. 30세 이상인 사람들의 이름을 알파벳 순으로 정렬하여 출력하세요.
         * 2. 각 도시별 평균 나이를 계산하세요.
         * 3. 가장 나이가 많은 사람의 이름을 찾으세요.
         * 4. "New York"에 사는 사람들의 수를 세세요.
         */

        List<Person> people = Arrays.asList(
                new Person("Alice", 25, "New York"),
                new Person("Bob", 30, "London"),
                new Person("Charlie", 35, "New York"),
                new Person("David", 40, "London"),
                new Person("Eve", 45, "Paris"));

        List<Person> over30 = new ArrayList<>();
        for (Person person : people) {
            if (person.getAge() >= 30) {
                over30.add(person);
            }
        }

        /*
         * Collections.sort(over30, new Comparator<Person>() {
         * 
         * @Override
         * public int compare(Person p1, Person p2) {
         * // p1, p2 이름 비교하는 메서드
         * return p1.getName().compareTo(p2.getName());
         * }
         * });
         */

        // 람다식 적용
        Collections.sort(over30, (p1, p2) -> p1.getName().compareTo(p2.getName()));

        for (Person person : over30) {
            System.out.println(person.getName());
        }
        System.out.println("---------스트림------------");
        // 스트림 적용
        people.stream()
                .filter(person -> person.getAge() >= 30)
                // .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                // .sorted(Comparator.comparing(Person::getName))
                .sorted(Comparator.comparing(person -> person.getName()))
                .forEach(person -> System.out.println(person.getName()));
        
        people.stream().filter(p -> p.getAge() >= 30).sorted(Comparator.comparing(p -> p.getName())).forEach(p -> System.out.println(p.getName()));
    }
}

/*
 * String.compareTo() 메서드는 int 값을 반환합니다. 이 메서드의 반환 값은 다음과 같은 규칙을 따릅니다:
 * 
 * 음수 (-1 등):
 * 
 * 호출하는 문자열(p1.getName())이 인자로 전달된 문자열(p2.getName())보다 사전적으로 앞에 옵니다.
 * 
 * 
 * 0:
 * 
 * 두 문자열이 동일합니다.
 * 
 * 
 * 양수 (1 등):
 * 
 * 호출하는 문자열(p1.getName())이 인자로 전달된 문자열(p2.getName())보다 사전적으로 뒤에 옵니다.
 * 
 * 
 * 
 * 예를 들어:
 * 
 * "Alice".compareTo("Bob") 은 음수를 반환합니다 (A가 B보다 앞에 있으므로).
 * "Charlie".compareTo("Charlie") 는 0을 반환합니다 (동일한 문자열).
 * "David".compareTo("Charlie") 는 양수를 반환합니다 (D가 C보다 뒤에 있으므로).
 * 
 * 이 반환 값은 Comparator의 compare 메서드의 요구사항과 일치합니다:
 * 
 * 음수: 첫 번째 객체가 두 번째 객체보다 "작다"
 * 0: 두 객체가 "같다"
 * 양수: 첫 번째 객체가 두 번째 객체보다 "크다"
 * 
 * 따라서 String.compareTo()의 반환 값을 그대로 사용하여 Person 객체들을 이름 순으로 정렬할 수 있습니다.
 * 실제 구현에서는 정확히 -1, 0, 1만 반환하는 것이 아니라, 문자열 간의 사전적 거리에 따라 다양한 정수 값이 반환될 수 있습니다.
 * 하지만 정렬 알고리즘에서는 단순히 값의 부호만을 고려하므로, 정확한 값은 중요하지 않습니다.
 */