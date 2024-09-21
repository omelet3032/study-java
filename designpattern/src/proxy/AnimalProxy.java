package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import annotation.ProxyAnnotation;

public class AnimalProxy implements InvocationHandler {

    private final Object target;

    public AnimalProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        
        Object result;

        if (method.isAnnotationPresent(ProxyAnnotation.class)) {
            ProxyAnnotation proxyAnnotation = method.getAnnotation(ProxyAnnotation.class);
            
            if (proxyAnnotation.value()) {
                System.out.println("<<실행된 클래스 : " + target.getClass() + ">>");
                System.out.println("<<실행된 메서드 : " + method.getName() + ">>");
                // result = method.invoke(target, args);
                method.invoke(target, args);
                System.out.println("<<메서드 종료>>");
                // return result;
            } else {
                System.out.println("<<로깅 적용 x>>");
                method.invoke(target, args);
            }


        }
        // System.out.println("-------");
        // System.out.println("-------");
        // System.out.println("<<메서드 종료>>");

        // return method.invoke(target, args);
        return null;
    }

    public static Object newProxyInstance(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new AnimalProxy(target));

    }

}
