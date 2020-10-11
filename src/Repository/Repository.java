package Repository;

import Model.IVehicle;
import Exceptions.MyException;
public class Repository implements IRepository{
    IVehicle[] vehicles;
    int numberOfVehicles, capacity;

    public Repository(int capacity) {
        vehicles = new IVehicle[capacity];
        this.numberOfVehicles = 0;
        this.capacity = capacity;
    }

    public int getSize() { return this.numberOfVehicles; }

    private int getPosition(IVehicle vehicle) {
        for(int index=0; index<this.numberOfVehicles;index++){
            if(vehicles[index].getId()==vehicle.getId() && vehicles[index].getClass() == vehicle.getClass())
                return index;
        }
        return -1;
    }
    public void addVehicle(IVehicle vehicle) throws MyException{
        if(this.numberOfVehicles == this.capacity)
            throw new MyException("Repository is full.");
        if(getPosition(vehicle) != -1)
            throw new MyException("Vehicle already in repository.");
        vehicles[numberOfVehicles++] = vehicle;
    }

    public void deleteVehicle(IVehicle vehicle) throws MyException {
        int indexToDelete = getPosition(vehicle);
        if (indexToDelete == -1)
            throw new MyException("Vehicle does not exist.");
        if (vehicles.length - 1 - indexToDelete >= 0)
            System.arraycopy(vehicles, indexToDelete + 1, vehicles, indexToDelete, vehicles.length - 1 - indexToDelete);
        numberOfVehicles--;
    }

    public IVehicle[] getVehicles() { return vehicles;}
}