
public class ZeroException extends Exception {

    private String message;

    public ZeroException(String msg) {
        this.message = msg;
    }

    @Override
    public String getMessage() {
        // TODO Auto-generated method stub
        return this.message;
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        // TODO Auto-generated method stub
        return super.getStackTrace();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        // Systempublic class ArithmeticExceptionExample {
    }

    public static int generateArithmeticException() throws ZeroException {

        int a = 10;
        int b = 0;
        if (b == 0 ) {
            throw new ZeroException("0으로 나눌 수 없습니다.");
        }
        int result = a / b;
        return result;
    }
}

