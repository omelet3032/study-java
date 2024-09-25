package animal;

import annotation.ProxyAnnotation;

public interface Animal {

    @ProxyAnnotation
    void sound();
    
    @ProxyAnnotation(false)
    void play();

    default void sleep() {
        System.out.println("쿨쿨");
    }

    String getName();

    String getType();

    String getSex();

    int getAge();

    String getStatus();
}
