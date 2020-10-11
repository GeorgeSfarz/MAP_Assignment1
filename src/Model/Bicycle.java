package Model;

public class Bicycle implements IVehicle{
    int id;
    String color;
    public Bicycle(int id, String color) {
        this.id = id;
        this.color = color;
    }
    public int getId() { return id; }
    public String getColor() { return color; }
    public void setId(int id) { this.id = id; }
    public void setColor(String color) { this.color = color; }
    public boolean colorFilter(String color) { return this.color.equals(color); }
}
