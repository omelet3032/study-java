public class GCExample {

    static class BigObject {
        private byte[] memory = new byte[10 * 1024 * 1024];

    }

    public static void main(String[] args) {

        System.out.println("시작전 가용 메모리 : " + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "MB");

        for (int i = 0; i < 10; i++) {
            BigObject obj = new BigObject();
            System.out.println("생성된 obj #" + (i + 1));
        }

        System.out.println("객체 생성후 가용 메모리 : " + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "MB");

        System.gc();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("gc 실행후 가용 메모리 : " + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "MB");
    }
}
