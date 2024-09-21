package practice2;



import java.util.ArrayList;
import java.util.List;

public class ManualThreadExample {

    public static void main(String[] args) throws InterruptedException {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            numbers.add(i);
        }

        // 두 개의 스레드로 데이터를 나누어 처리
        Thread t1 = new Thread(() -> processData(numbers.subList(0, 50)));
        Thread t2 = new Thread(() -> processData(numbers.subList(50, 100)));

        t1.start();
        t2.start();

        t1.join(); // 스레드 종료 대기
        t2.join();

        System.out.println("모든 작업 완료");
    }

    private static void processData(List<Integer> data) {
        for (int number : data) {
            System.out.println("처리 중: " + number + " - " + Thread.currentThread().getName());
        }
    }
}