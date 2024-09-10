package generic.src;

public class Box<T> {
    
    private T content;

    public void set(T content) {
        this.content = content;
    }

    public T get() {
        return content;
    }

    @Override
    public String toString() {
        return "Box [content=" + content + "]";
    }

    
}
