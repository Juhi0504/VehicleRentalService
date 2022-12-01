package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vehicle {

    String id;
    VehicleType type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    List<Pair> bookings;

    public Vehicle(String id, VehicleType type) {
        this.id = id;
        this.type = type;

        bookings = new ArrayList<>();
    }

    public boolean isAvailable(Date start, Date end)
    {
        for(int i=0; i<bookings.size(); i++)
        {
            if(start.compareTo(bookings.get(i).startTime) >0 && start.compareTo(bookings.get(i).endTime) <= 0)
            {
                return false;
            }
            if(end.compareTo(bookings.get(i).startTime) >0 && end.compareTo(bookings.get(i).endTime) <= 0)
            {
                return false;
            }
        }
        return true;
    }

    public void book(Date start, Date end)
    {
        bookings.add(new Pair(start, end));
    }

    class Pair
    {
        Date startTime;
        Date endTime;

        public Pair(Date start, Date end)
        {
            startTime = start;
            endTime = end;
        }

        public Date getStartTime() {
            return startTime;
        }

        public void setStartTime(Date startTime) {
            this.startTime = startTime;
        }

        public Date getEndTime() {
            return endTime;
        }

        public void setEndTime(Date endTime) {
            this.endTime = endTime;
        }
    }
}
