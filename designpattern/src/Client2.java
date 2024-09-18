import animal.Animal;
import animal.Cat;
import animal.Dog;

public class Client2 {
    
    public static void main(String[] args) {
        
        Animal cat = new Cat("고양이", "암컷", "미오", 13, "정상");

        cat.sound();
        cat.play();
    }
}
