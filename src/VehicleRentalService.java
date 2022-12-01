import model.Branch;
import model.Vehicle;
import model.VehicleType;

import java.util.*;

public class VehicleRentalService {

    int branchId = 0;

    HashMap<String, Branch> branches;

    public VehicleRentalService()
    {
        branches = new HashMap<>();
    }
    public void addBranch(String name)
    {
        if(branches.containsKey(name))
        {
            return;
        }
        Branch branch = new Branch(branchId++, name);
        branches.put(name, branch);
    }

    public void allocatePrice(String branchName, VehicleType type, int price)
    {
        if(!branches.containsKey(branchName))
        {
            return;
        }
        Branch branch = branches.get(branchName);
        branch.addPrice(type, price);
    }

    public void addVehicle(String id, VehicleType type, String branchName)
    {
        if(!branches.containsKey(branchName))
        {
            return;
        }
        Branch branch = branches.get(branchName);
        branch.addVehicles(type, id);
    }

    public Vehicle bookVehicle(VehicleType type, Date startTime, Date endTime)
    {
        int lowestCost = Integer.MAX_VALUE;
        Vehicle vehicleBooked = null;
        // iterate all branches and get the cheapest quote from that
        for(Map.Entry<String, Branch> branch : branches.entrySet())
        {
            if(branch.getValue().getPrice(type) < lowestCost)
            {
                Vehicle vehicle = branch.getValue().getAvailibility(type, startTime, endTime);

                if(vehicle != null)
                {
                    vehicleBooked = vehicle;
                }
            }
        }
        if(vehicleBooked != null)
        {
            vehicleBooked.book(startTime, endTime);
        }
        return vehicleBooked;
    }

    public List<List<Vehicle>> viewVehicleInventory(Date startTime, Date endTime)
    {
        List<List<Vehicle>> vehicles = new ArrayList<>();

        return vehicles;
    }
}
