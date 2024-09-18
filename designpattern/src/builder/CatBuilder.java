package builder;

import animal.Animal;
import animal.Cat;

public class CatBuilder implements AnimalBuilder {

    private String name;
    private String type;
    private String sex;
    private int age;
    private String status;

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

    @Override
    public Animal build() {
        return new Cat(name, type, sex, age, status);
    }

}
