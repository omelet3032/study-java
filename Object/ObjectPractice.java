package Object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class ObjectPractice {

    public static void main(String[] args) {

        Book book1 = new Book("테스트", "omelet", 2023);
        Book book2 = new Book("테스트", "tofu", 2023);
        Book book3 = new Book("테스트", "omelet", 2022);

        // 1. 객체 동등 비교
        boolean isEquals1 = book1.equals(book2);
        boolean isEquals2 = book1.equals(book3);

        System.out.println("isEquals1 : " + isEquals1);
        System.out.println("isEquals2 : " + isEquals2);

        // 2. 해시코드
        System.out.println(book1.hashCode());
        System.out.println(book2.hashCode());
        System.out.println(book3.hashCode());
        // 3. Objects.compare();
        System.out.println(Objects.compare(book1, book2, new BookComparator()));

        // 4. toString();
        System.out.println(book1.toString());

        // 5. getClass();
        EBook eBook = new EBook();
        Book book = new EBook();
        System.out.println(book1.getClass());
        System.out.println(book2.getClass());
        System.out.println(eBook.getClass());
        System.out.println(book.getClass());

        // 6. clone()
        System.out.println("------6. clone --------");
        try {
            List<String> chapter = new ArrayList<>();
            chapter.add("유진우");
            chapter.add("유진우2");

            book1.setChapter(chapter);
            Book book4 = (Book) book1.clone();
            chapter.add("유진우3");
            System.out.println(book1.getChapter());
            System.out.println(book4.getChapter());
            // book4.setAuthor("김김김");

            // book4.setChapter(chapter);

            // List<String> newChapter = new ArrayList<>();
            // newChapter.add("유지누4");

            // book4.setChapter(newChapter);

            System.out.println(book1 == book4);
            System.out.println(book1.equals(book4));
            System.out.println(book1.hashCode());
            System.out.println(book4.hashCode());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        // 7. hashCode(), hashMap();
        // Map<Book, String[]> map1 = new HashMap<>();
        // Map<Integer, Book> map2 = new HashMap<>();
        Map<Book, String> map3 = new HashMap<>();

        // map2.putIfAbsent(2, book1);
        map3.put(book1, "초판");
        map3.put(book3, "개정판");

        System.out.println("Map size : " + map3.size());
        System.out.println("book1 value : " + map3.get(book1));
        System.out.println("book3 value : " + map3.get(book3));
        System.out.println("book1.equals book3  : " + book1.equals(book3));
        System.out.println("book1 hashCode  : " + book1.hashCode());
        System.out.println("book3 hashCode  : " + book3.hashCode());
        // boolean isTrue = map2.containsValue(book1);

        System.out.println(map3.containsValue(book1));


        Set<Map.Entry<Book, String>> entrySet = map3.entrySet();

        for (Map.Entry<Book, String> entry : entrySet) {
        System.out.println("entry : " + entry.getKey() + " / " + entry.getValue());
        }

        // System.out.println(map2.toString());
        // System.out.println(map3.toString());
        // System.out.println(isTrue);

        // 7. equals() 대칭성
        Book book4 = new AudioBook("테스트", "omelet", 2023);
        System.out.println("book1.equals book4 : " + book1.equals(book4));
        System.out.println("book4.equals book1 : " + book4.equals(book1));
        System.out.println("book4 hashcode : " + book4.hashCode());
    }

}
