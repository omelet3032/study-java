package generic.src;

public class Library {
   
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Library [title=" + title + "]";
    }


}
