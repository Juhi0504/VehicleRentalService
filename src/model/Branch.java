package model;

import java.util.*;

public class Branch {

    int id;
    String location;
    Map<VehicleType, Integer> priceByType;

    Map<VehicleType, List<Vehicle>> vehiclesByType;

    public Branch(int id, String location)
    {
        this.id = id;
        this.location = location;
        this.priceByType = new EnumMap<>(VehicleType.class);
        this.vehiclesByType = new EnumMap<>(VehicleType.class);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Map<VehicleType, Integer> getPriceByType() {
        return priceByType;
    }

    public void setPriceByType(Map<VehicleType, Integer> priceByType) {
        this.priceByType = priceByType;
    }

    public Map<VehicleType, List<Vehicle>> getVehicles() {
        return vehiclesByType;
    }

    public void setVehicles(Map<VehicleType, List<Vehicle>> vehicles) {
        this.vehiclesByType = vehicles;
    }

    public void addPrice(VehicleType type, int price)
    {
        priceByType.put(type, price);
    }

    public void addVehicles(VehicleType type, String id)
    {
        Vehicle v = new Vehicle(id, type);
        if(vehiclesByType.containsKey(type))
        {
            vehiclesByType.getOrDefault(type, new ArrayList<>()).add(new Vehicle(id, type));
        }
        else
        {
            List<Vehicle> vehicles = new ArrayList<>();
            vehicles.add(v);
            vehiclesByType.put(type, vehicles);
        }
    }

    public int getPrice(VehicleType type)
    {
        return priceByType.getOrDefault(type, Integer.MAX_VALUE);
    }

    public Vehicle getAvailibility(VehicleType type, Date startTime, Date endTime)
    {
        List<Vehicle> vehicles = vehiclesByType.get(type);
        if(vehicles == null)
        {
            return null;
        }
        for(int i=0; i<vehicles.size(); i++)
        {
            if(vehicles.get(i).isAvailable(startTime, endTime))
            {
                return vehicles.get(i);
            }
        }
        return null;
    }
}
