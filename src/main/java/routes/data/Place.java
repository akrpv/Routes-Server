package routes.data;

public class Place {

    private double x;
    private double y;
    private String name;
    private long categoryId;
    private int time; //in minutes

    public Place(double x, double y, String name, long categoryId, int time) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.categoryId = categoryId;
        this.time = time;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public int getTime() {
        return time;
    }
}