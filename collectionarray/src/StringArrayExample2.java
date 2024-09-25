package collectionarray.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringArrayExample2 {

    public static void main(String[] args) {

        String[] arr1 = new String[]{"유진우", "박설화", "대장군"};

        List<String[]> list = new ArrayList<>();
        list.add(arr1);

        arr1 = new String[]{"대장"};
        
        list.set(list-size()-1, );
        list.size() - 1

        // arr1 + arr2
        // 동적으로 조절이 안되기 때문에 새로운 배열을 만들어야 한다.

        // String[] arr3 = new String[arr1.length + arr2.length];

        // // 배열 복사
        // System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        
        // System.out.println(Arrays.toString(arr3)); 

        // System.arraycopy(arr2, 0, arr3, arr3.length-1, arr2.length);

        // System.out.println(Arrays.toString(arr3));
    }

}

//         String[] arr1 = new String[]{"유진우", "박설화", "대장군"};
//         String[] arr2 = new String[]{"대장"};

//         // arr1과 arr2의 길이를 합친 새로운 배열 생성
//         String[] arr3 = new String[arr1.length + arr2.length];

//         // arr1을 arr3에 복사
//         System.arraycopy(arr1, 0, arr3, 0, arr1.length);
//         // arr2를 arr3에 이어서 복사
//         System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);

//         // 결과 출력
//         System.out.println(Arrays.toString(arr3));
