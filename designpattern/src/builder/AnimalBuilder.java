package builder;

import animal.Animal;

public interface AnimalBuilder {

    AnimalBuilder name(String name);

    AnimalBuilder type(String type);

    AnimalBuilder sex(String sex);

    AnimalBuilder age(int age);

    AnimalBuilder status(String status);

    Animal build();

}
