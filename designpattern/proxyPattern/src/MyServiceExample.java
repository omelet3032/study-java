package proxyPattern;

public class MyServiceExample {
   
    public static void main(String[] args) {
        
        MyService myService = new MyServiceImpl();

        MyService proxySevice = (MyService) MyServiceProxy.newProxyInstance(myService);

        proxySevice.doSomeThing();

        proxySevice.doThing();
    }
}
