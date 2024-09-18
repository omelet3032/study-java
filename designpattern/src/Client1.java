import animal.Animal;
import decorator.AnimalDecorator;
import factorymethod.AnimalFactory;
import factorymethod.CatFactory;
import factorymethod.DecoratedCatFactory;
import factorymethod.DogFactory;

public class Client1 {

    public static void main(String[] args) {
        
        AnimalFactory catFactory = new CatFactory();

        Animal cat = catFactory.createAnimal(); 

        // cat.sound();

        System.out.println("-------------");
        
        AnimalFactory decoratedCatFactory = new DecoratedCatFactory();
        Animal decoratedCat = decoratedCatFactory.createAnimal();
        
        decoratedCat.sound();
        System.out.println("-----");
        decoratedCat.play();


        // cat.wearCloth("옷");
        
        System.out.println("-------------");
        
        AnimalFactory dogFactory = new DogFactory();
        Animal dog = dogFactory.createAnimal();

        dog.sound();
        dog.play();
    }

}