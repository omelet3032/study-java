import java.util.Arrays;
import java.util.List;

public class LambdaPractice1 {

    // 함수형 인터페이스 정의
    @FunctionalInterface
    interface NumberOperation {
        int operate(int n);
    }

    public static void processNumbers(List<Integer> numbers, NumberOperation operation) {
        for (int num : numbers) {
            int result = operation.operate(num);
            System.out.println("Result for " + num + ": " + result);
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // 여기에 람다 표현식을 사용하여 processNumbers 메서드를 호출하세요
        // 예: 각 숫자를 2배로 만드는 연산

        processNumbers(numbers, number -> {
            return number * 2;
        });

        processNumbers(numbers, number -> number * 2); // 단일 표현식 람다는 return을 굳이 명시할 필요 없다.

        processNumbers(numbers, new NumberOperation() {
            @Override
            public int operate(int number) { // 리스코프 치환 원칙에 의거, 구현 클래스에서는 인터페이스 지시자보다 위에 있어야 한다. public
                return number * 2;
            }
        });
    }
}

/* 
 * 인터페이스의 추상 메서드는 암시적으로 public 
 * 구현 클래스에서는 기본적으로 default 메서드, 명시적으로 public을 선언해야 함
 * 
 * 막상 문제를 풀어보니 나 람다에 대해 아무것도 몰랐구나 싶었다.
 * 이렇게 풀어보니 NamedParameter.query 메서드의 람다 파라미터에 대해 알게 되었다.
 * 스프링에서 RowMapper에 대한 함수형 인터페이스를 만들어두었고, 우리는 query메서드 파라미터에서 람다로 구현하면 되는것이다.
 * 
 * @FunctionalInterface
    public interface RowMapper<T> {
    T mapRow(ResultSet rs, int rowNum) throws SQLException;
    }
 * 
 * Cannot reduce the visibility of the inherited method from 
 * -> 상속받은 메서드의 가시성을 줄일 수 없다
 */