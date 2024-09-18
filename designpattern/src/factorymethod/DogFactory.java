package factorymethod;

import animal.Animal;
import animal.Dog;

public class DogFactory implements AnimalFactory {
    @Override
    public Animal createAnimal() {

        Animal dog = new Dog.Builder()
                .type("강아지")
                .sex("암컷")
                .age(3).name("릴리")
                .status("정상")
                .build();

        return dog;
    }
}
