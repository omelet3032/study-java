package generic.src;

public class GenericExample {
    
    public static void main(String[] args) {
        
        Box<Integer> intBox1 = new Box<>();
        intBox1.set(10);

        Integer intValue1 = intBox1.get();
        System.out.println("Integer Value : " + intValue1);

        Box<String> intBox2 = new Box<>();

        intBox2.set("유진우");
        String intValue2 = intBox2.get();
        System.out.println("String Value : " + intValue2);

        Library library = new Library();
        library.setTitle("자바의 정석");

        Box<Library> libraryBox = new Box<>();
        
        libraryBox.set(library);

        System.out.println(libraryBox.get());
    }
}
