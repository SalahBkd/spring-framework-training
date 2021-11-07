package io.salahboutainawarda.parkinglot;

import io.salahboutainawarda.parkinglot.lot.ParkingLot;
import io.salahboutainawarda.parkinglot.lot.ParkingSpace;
import io.salahboutainawarda.parkinglot.lot.ParkingSpaceType;
import io.salahboutainawarda.parkinglot.vehicles.VehicleFactory;
import io.salahboutainawarda.parkinglot.vehicles.VehicleType;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setParkingSpaces(
            Arrays.asList(
                    new ParkingSpace(ParkingSpaceType.COMPACT, true),
                    new ParkingSpace(ParkingSpaceType.LARGE, false),
                    new ParkingSpace(ParkingSpaceType.TRUCK, true),
                    new ParkingSpace(ParkingSpaceType.BIKE, true)
            )
        );


        parkingLot.getParkingAttendant().park(VehicleFactory.createVehicle(VehicleType.BIKE, false));
        parkingLot.getParkingAttendant().park(VehicleFactory.createVehicle(VehicleType.COMPACT, false));
        parkingLot.getParkingAttendant().park(VehicleFactory.createVehicle(VehicleType.SUV, true));
        parkingLot.getParkingAttendant().park(VehicleFactory.createVehicle(VehicleType.COMPACT, true));
        parkingLot.getParkingAttendant().park(VehicleFactory.createVehicle(VehicleType.LARGE, false));

        System.out.println(parkingLot);
    }
}
