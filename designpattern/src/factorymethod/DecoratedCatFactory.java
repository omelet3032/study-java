package factorymethod;

import animal.Animal;
import builder.CatBuilder;
import decorator.AnimalDecorator;
import proxy.AnimalProxy;

public class DecoratedCatFactory extends CatFactory {

    @Override
    public Animal createAnimal() {

        Animal cat = super.createAnimal();
        AnimalDecorator decoratedCat = new AnimalDecorator(cat);
        // Animal decoratedCat = new AnimalDecorator(cat);

        Animal proxyCat = (Animal) AnimalProxy.newProxyInstance(decoratedCat);
        
        return proxyCat;
    }

}
