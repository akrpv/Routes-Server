package routes.data;

public class Category {

    private long id;
    private String name;
    private int time; //in minutes

    public Category(long id, String name, int time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(int time) {
        this.time = time;
    }
}