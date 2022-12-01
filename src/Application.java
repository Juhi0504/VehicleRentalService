import model.User;
import model.Vehicle;
import model.VehicleType;

import java.util.Calendar;
import java.util.Date;

public class Application {

    public static void main(String[] args)
    {
        VehicleRentalService vrs = new VehicleRentalService();

        User user1 = new User(1, "Juhi");
        User user2 = new User(1, "Harsh");

        vrs.addBranch("HSR");
        vrs.addBranch("Indiranagar");
        vrs.addBranch("Puram");

        vrs.allocatePrice("HSR", VehicleType.Sedan, 100);
        vrs.allocatePrice("Indiranagar", VehicleType.Sedan, 150);
        vrs.allocatePrice("Puram", VehicleType.Sedan, 50);

        vrs.addVehicle("A", VehicleType.Sedan, "HSR");
        //vrs.addVehicle("B", VehicleType.Sedan, "Puram");

        Calendar cal = Calendar.getInstance(); // creates calendar
        cal.setTime(new Date());               // sets calendar time/date
        cal.add(Calendar.HOUR_OF_DAY, 1);      // adds one hour

        Calendar cal2 = Calendar.getInstance(); // creates calendar
        cal2.setTime(new Date());               // sets calendar time/date
        cal2.add(Calendar.HOUR_OF_DAY, 3);

        Vehicle v= vrs.bookVehicle(VehicleType.Sedan, cal.getTime(), cal2.getTime());
        if(v != null)
        {
            System.out.println("booked is " + v.getId());
        }

        cal.setTime(new Date());               // sets calendar time/date
        cal.add(Calendar.HOUR_OF_DAY, 3);

        cal2.setTime(new Date());               // sets calendar time/date
        cal2.add(Calendar.HOUR_OF_DAY, 4);
        v = vrs.bookVehicle(VehicleType.Sedan, cal.getTime(), cal2.getTime());
        if(v != null)
        {
            System.out.println("booked is " + v.getId());
        }

    }
}
