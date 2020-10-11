package Repository;

import Model.IVehicle;
import Exceptions.MyException;
public interface IRepository {
    void addVehicle(IVehicle vehicle) throws MyException;
    void deleteVehicle(IVehicle vehicle) throws MyException;
    IVehicle[] getVehicles();
    int getSize();
}


