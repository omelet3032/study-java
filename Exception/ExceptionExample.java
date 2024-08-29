/**
 * ExceptionExample
 */
public class ExceptionExample {

    public static void main(String[] args) {

         try {
            int result = ArithmeticExceptionExample.generateArithmeticException();
            System.out.println(result);
        } catch (ZeroException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } 


    }

}