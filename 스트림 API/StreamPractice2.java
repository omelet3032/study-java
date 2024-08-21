import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPractice2 {
    public static void main(String[] args) {

        /*
         * 다음 작업을 스트림을 사용하여 수행하세요:
         * 2. 각 도시별 평균 나이를 구하시오.
         */

        // 기본 메서드와 로직을 이용한 풀이
        List<Person> people = Arrays.asList(
                new Person("Alice", 25, "New York"),
                new Person("Bob", 30, "New York"),
                new Person("Charlie", 35, "New York"),
                new Person("David", 40, "London"),
                new Person("Eve", 45, "Paris"),
                new Person("kevin", 55, "London"));

        Map<String, Double> map = people.stream()
                .collect(Collectors.groupingBy(p -> p.getCity(), Collectors.averagingInt(p -> p.getAge())));
                
        map.forEach((city, age) -> System.out.println(city + " / " + age));

        List<String> uniqueCities = new ArrayList<>();
        for (Person person : people) {
            if (!uniqueCities.contains(person.getCity())) {
                uniqueCities.add(person.getCity());
            }
        }

        for (String city : uniqueCities) {
            int sum = 0;
            int count = 0;
            for (Person person : people) {
                if (person.getCity().equals(city)) {
                    sum += sum + person.getAge();
                    count++;
                }
            }
            double avgAge = (double) sum / count;
            System.out.println(city + ": " + String.format("%.2f", avgAge));
        }

        // Map을 이용한 풀이

    }

}

/*
 * 1. 느낀 점
 * Map<K,V>에서 V에는 정말 다양한 값이 들어갈 수 있다는점
 * int[] 배열도 들어갈 수 있다.
 * 
 * 기초적인 로직 짜는 것조차 많이 부족하다.
 *
 * 2. 새로 배운 것들
 * 중첩 인터페이스 (nested interface)
 * 
 * Entry
 * 
 * entrySet()
 * 
 * putIfAbsent
 * 
 */

/*
 * 궁금한게 위 코드에서 굳이 entry를 안써도 값을 다 추출할 수 있는데 왜 아래가 효율적이라는거야?
 * 오히려 위 코드가 한줄 더 적은데?
 * 
 * 
 * 네, 좋은 질문입니다. 이 점에 대해 더 자세히 설명드리겠습니다.
 * 
 * `entrySet()`을 사용하는 방법이 더 효율적이라고 말씀드린 이유는 다음과 같습니다:
 * 
 * 1. 성능:
 * - `keySet()`을 사용하는 경우, 각 키에 대해 `map.get(key)` 메소드를 호출해야 합니다.
 * - 큰 Map의 경우, 이 추가적인 검색 작업이 성능에 영향을 줄 수 있습니다.
 * - `entrySet()`은 키와 값을 동시에 가져오므로, 추가 검색이 필요 없습니다.
 * 
 * 2. 내부 구현:
 * - 많은 Map 구현체에서 `entrySet()`은 내부적으로 최적화되어 있습니다.
 * - 이는 특히 큰 데이터셋에서 더 효율적일 수 있습니다.
 * 
 * 3. 가독성:
 * - `entrySet()`을 사용하면 키와 값을 동시에 얻을 수 있어, 코드의 의도가 더 명확해질 수 있습니다.
 * 
 * 하지만, 당신의 지적대로 작은 Map이나 성능이 크게 중요하지 않은 상황에서는 두 방법의 실질적인 차이가 미미할 수 있습니다. 또한
 * `keySet()`을 사용하는 방법이 한 줄 더 짧다는 점도 맞습니다.
 * 
 * 결론적으로:
 * - 성능이 중요한 대규모 애플리케이션이나 큰 Map을 다룰 때는 `entrySet()`이 유리할 수 있습니다.
 * - 작은 규모의 Map이나 성능이 크게 중요하지 않은 상황에서는 두 방법 중 개발자가 더 편한 것을 선택해도 무방합니다.
 * - 코드의 가독성과 유지보수성도 고려해야 할 중요한 요소입니다.
 * 
 * 제가 이전에 "더 효율적"이라고 일반화하여 말씀드린 것은 정확하지 않았습니다. 상황에 따라 적절한 방법을 선택하는 것이 중요합니다. 설명이
 * 부족했던 점 사과드립니다.
 */

/*
 * 원본 코드
 * 
 * List<Person> people = Arrays.asList(
 * new Person("Alice", 25, "New York"),
 * new Person("Bob", 30, "London"),
 * new Person("Charlie", 35, "New York"),
 * new Person("David", 40, "London"),
 * new Person("Eve", 45, "Paris")
 * );
 * 
 * // 도시별 나이 합계와 인원 수를 저장할 Map 생성
 * Map<String, int[]> cityAgeMap = new HashMap<>();
 * 
 * // 각 사람의 정보를 순회하며 도시별 나이 합계와 인원 수 계산
 * for (Person person : people) {
 * String city = person.getCity();
 * int age = person.getAge();
 * 
 * cityAgeMap.putIfAbsent(city, new int[]{0, 0});
 * int[] cityData = cityAgeMap.get(city);
 * cityData[0] += age; // 나이 합계
 * cityData[1]++; // 인원 수
 * }
 * 
 * // 각 도시별 평균 나이 계산 및 출력
 * for (Map.Entry<String, int[]> entry : cityAgeMap.entrySet()) {
 * String city = entry.getKey();
 * int[] cityData = entry.getValue();
 * double averageAge = (double) cityData[0] / cityData[1];
 * 
 * System.out.println(city + ": " + averageAge);
 * }
 *
 */