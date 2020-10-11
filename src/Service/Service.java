package Service;

import Exceptions.MyException;
import Model.IVehicle;
import Repository.*;

import javax.crypto.spec.IvParameterSpec;

public class Service {
    IRepository repository;
    public Service(int capacity) { this.repository = new Repository(capacity); }

    public void addVehicle(IVehicle vehicle) throws MyException {
          repository.addVehicle(vehicle);
    }

    public void deleteVehicle(IVehicle vehicle) throws MyException {
        repository.deleteVehicle(vehicle);
    }

    public int getSize() {
        return repository.getSize();
    }

    public IVehicle[] getVehicles() {
        return repository.getVehicles();
    }

    public IVehicle[] colorFilter() throws MyException{
        IVehicle[] vehicles = repository.getVehicles();
        IVehicle[] filteredVehicles = new IVehicle[repository.getSize()];
        int filteredListSize = 0;
        for(int index = 0; index < repository.getSize(); index++) {
            if(vehicles[index].colorFilter("red")) {
                filteredVehicles[filteredListSize++] = vehicles[index];
            }
        }
        if(filteredListSize == 0)
            throw new MyException("No red vehicles found.");
        return filteredVehicles;
    }
}
