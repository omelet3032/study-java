package String;

public class StringExample {
    
    public static void main (String[] args) {
       
        String word1 = "hello, world!";

        //1. 문자열 길이 출력
        System.out.println("lengthP : " + word1.length());

        //2. 대소문자
        System.out.println("대문자 : " + word1.toUpperCase());
        System.out.println("소문자 : " + word1.toLowerCase());

        //3. concat
        String word2 = "Hello";
        String word3 = "world!";

        System.out.println("concat : " + word2.concat(word3));

        //4. 부분 문자열 추출
        String word4 = "Welcome to Java Programming";
        System.out.println("subString() : " + word4.substring(11,15));


        //5. 문자 찾기
        String word5 = "apple";
        System.out.println("index : " + word5.indexOf("a"));

        //6. 문자열 비교
        String word6 = "hello";
        System.out.println("equals() : " + word6.equals("Hello"));

        //7. 공백 제거
        String word7 = "    hello world    ";
        System.out.println("trim() : " + word7.trim());
        System.out.println("trim() : " + word7);

        //8. 문자 대체
        String word8 = "java programming";
        System.out.println("replace() : " + word8.replace("java", "python"));


        //9. 문자열 포함 여부 확인
        String word9 = "java is fun";
        System.out.println("contains() : " + word9.contains("fun"));

        //10. 문자열 분리
        String word10 = "apple,banana,orange";
        String[] fruitArray = word10.split(",");

        for (int i = 0; i < fruitArray.length; i++) {
            System.out.println("fruitArray : " + fruitArray[i]);
        }


        
        
    } 
}
