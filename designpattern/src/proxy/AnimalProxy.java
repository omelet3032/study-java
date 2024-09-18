package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AnimalProxy implements InvocationHandler {

    private final Object target;

    public AnimalProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        
        System.out.println("<<실행된 메서드 : " + method.getName() + ">>");
        System.out.println("-------");
        Object result = method.invoke(target, args);
        System.out.println("-------");
        System.out.println("<<메서드 종료>>");

        return result;
    }

    public static Object newProxyInstance(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new AnimalProxy(target));

    }

}
