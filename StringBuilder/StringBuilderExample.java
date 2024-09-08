package StringBuilder;

public class StringBuilderExample {
    
    public static void main(String[] args) {
        
        StringBuilder sb1 = new StringBuilder("Hello");
        StringBuilder sb2 = new StringBuilder(12);
        StringBuilder sb3 = new StringBuilder();

        System.out.println(sb3.toString());

        //1. 문자열 끝에 추가하기 (append)
        sb1.append(" ");
        sb1.append("world!");
        System.out.println("append() : " + sb1);

        //2. 특정 위치에 문자열 삽입하기
        sb1.insert(5,",");
        System.out.println(sb1.toString());

        //3. 문자열 교체하기(replace)
        sb1.replace(0, 5, "study");
        System.out.println(sb1.toString());
        //인덱스 시작부터 끝 다음까지 입력해야 제대로 교체된다.

        
    }
}
