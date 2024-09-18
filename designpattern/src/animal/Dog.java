package animal;

import builder.AnimalBuilder;

/* 
 * 심플 빌더 패턴 구현에 따른 DogBuilder 내부 정적 클래스로 선언
 */
public class Dog implements Animal {

    private String name;
    private String type;
    private String sex;
    private int age;
    private String status;

    private Dog(Builder dogBuilder) {
        this.type = dogBuilder.type;
        this.sex = dogBuilder.sex;
        this.age = dogBuilder.age;
        this.name = dogBuilder.name;
        this.status = dogBuilder.status;
    }

    @Override
    public void play() {
        System.out.println("할할할");
    }

    @Override
    public void sound() {
        System.out.println("멍멍");
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSex() {
        return this.sex;
    }

    @Override
    public String getStatus() {
        return this.status;
    }

    @Override
    public String getType() {
        return this.type;
    }

    public static class Builder implements AnimalBuilder {

        private String name;
        private String type;
        private String sex;
        private int age;
        private String status;

        public Animal build() {
            return new Dog(this);
        }

        @Override
        public AnimalBuilder type(String type) {
            this.type = type;
            return this;
        }

        @Override
        public AnimalBuilder sex(String sex) {
            this.sex = sex;
            return this;
        }

        @Override
        public AnimalBuilder age(int age) {
            this.age = age;
            return this;
        }

        @Override
        public AnimalBuilder name(String name) {
            this.name = name;
            return this;
        }

        @Override
        public AnimalBuilder status(String status) {
            this.status = status;
            return this;
        }

    }
}
