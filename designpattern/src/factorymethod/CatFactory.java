package factorymethod;

import animal.Animal;
import animal.Cat;
import builder.CatBuilder;
import decorator.AnimalDecorator;
import proxy.AnimalProxy;

public class CatFactory implements AnimalFactory {

    @Override
    public Animal createAnimal() {
        Animal cat = new CatBuilder()
                .type("고양이")
                .sex("암컷")
                .age(13)
                .name("미오")
                .status("정상")
                .build();


        return cat;
    }

}
