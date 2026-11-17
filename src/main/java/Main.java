import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Houses
        House home = new House("My home", "05/29/2023",
                new BigDecimal("100000"), "759 HBT St, NJ", 4, 144, 10000);

        House vacationHome = new House("Vacation home", "05/29/2025",
                new BigDecimal("1000000"), "Grove St, Los Santos", 1, 154, 100000);

// Vehicles
        Vehicle car = new Vehicle("My daily car", "06/15/2022",
                new BigDecimal("12000"), "Honda CR-V", 2008, 145000);

        Vehicle sportsCar = new Vehicle("Weekend sports car", "03/10/2024",
                new BigDecimal("65000"), "Chevrolet Corvette", 2022, 15000);

        Vehicle truck = new Vehicle("Work truck", "08/20/2021",
                new BigDecimal("35000"), "Ford F-150", 2019, 85000);


        ArrayList<Asset> myAssets = new ArrayList<>();

        myAssets.add(home);
        myAssets.add(vacationHome);
        myAssets.add(sportsCar);
        myAssets.add(truck);
        myAssets.add(car);

        BigDecimal netWorth = new BigDecimal(0);
        for(Asset a : myAssets){
            netWorth = netWorth.add(a.getValue());

            System.out.println(a);

            if (a instanceof House) {
                House house = (House) a;
                System.out.println("Address: " + house.getAddress());
            } else if (a instanceof Vehicle) {
                Vehicle vehicle = (Vehicle) a;
                System.out.println("Vehicle: " + vehicle.getYear() + " " + vehicle.getMakeModel());
            }
        }

        System.out.println("Your net worth:");
        System.out.println(netWorth);


    }

}
