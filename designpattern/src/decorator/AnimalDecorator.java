package decorator;

import animal.Animal;

public class AnimalDecorator implements Animal {
    
    private Animal animal;
    private String cloth;

    public AnimalDecorator(Animal animal) {
        this.animal = animal;
    }

    public AnimalDecorator(String cloth) {
        this.cloth = cloth;
    }

    // 기능 추가
    public String wearCloth(String cloth) {
        System.out.println("옷입자~~");
        System.out.println("입은 옷 : " + cloth);
        return this.cloth;
    }

    // sound 기능 추가
    @Override
    public void sound() {
        this.animal.sound();
        System.out.println("우렁차게 내지르자!!!");
    }


    // ----------------------------



    @Override
    public void play() {
        this.animal.play();
        System.out.println("더 힘차게 play 해보자!!");
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    @Override
    public String getType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getType'");
    }

    @Override
    public String getSex() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSex'");
    }

    @Override
    public int getAge() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAge'");
    }

    @Override
    public String getStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStatus'");
    }

    
} 
