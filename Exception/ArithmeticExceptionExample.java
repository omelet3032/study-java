public class ArithmeticExceptionExample {

    public static int generateArithmeticException() throws ZeroException {

        int a = 10;
        int b = 0;
        if (b == 0) {
            throw new ZeroException("안녕");
        }
        int result = a / b;
        return result;
    }
}
