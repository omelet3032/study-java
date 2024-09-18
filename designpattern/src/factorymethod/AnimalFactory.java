package factorymethod;

import animal.Animal;
import animal.Cat;
import animal.Dog;
import decorator.AnimalDecorator;

public interface AnimalFactory {
    
    Animal createAnimal();

}
