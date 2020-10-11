package Model;

public interface IVehicle {
    int getId();
    void setId(int id);
    String getColor();
    void setColor(String color);
    boolean colorFilter(String color);
}
