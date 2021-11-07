package io.salahboutainawarda.parkinglot.lot;

import io.salahboutainawarda.parkinglot.vehicles.Vehicle;
import io.salahboutainawarda.parkinglot.vehicles.VehicleFactory;
import io.salahboutainawarda.parkinglot.vehicles.VehicleType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLotTestUtil {
    private ParkingLot  parkingLot = new ParkingLot();
    private List<Vehicle> vehicles;

    public ParkingLot getParkingLot() {
        return parkingLot;
    }


    public ParkingLotTestUtil setSpaceTypes(String spaceTypesStr) {
        List<ParkingSpace> spaces = Arrays.stream(spaceTypesStr.split(","))
                .map(ParkingSpaceType::valueOf)
                .map(type -> new ParkingSpace(type, false))
                .collect(Collectors.toList());
        parkingLot.setParkingSpaces(spaces);
        return this;
    }

    public ParkingLotTestUtil setHandicappedSpots(String handicappedStr) {
        List<Boolean> handicappedStatusList = Arrays.stream(handicappedStr.split(","))
                .map(Boolean::parseBoolean)
                .collect(Collectors.toList());
        for (int i = 0; i < handicappedStatusList.size(); i++) {
            this.parkingLot.getParkingSpaces().get(i).setHandicapped(handicappedStatusList.get(i));
        }
        return this;
    }

    public ParkingLotTestUtil setVehicles(String vehiclesStr) {
        this.vehicles = Arrays.stream(vehiclesStr.split(","))
                .map(VehicleType::valueOf)
                .map(vehicleType -> VehicleFactory.createVehicle(vehicleType, false))
                .collect(Collectors.toList());

        return this;
    }

    public ParkingLotTestUtil setHandicappedCars(String handicappedStr) {
        List<Boolean> handicappedStatusList = Arrays.stream(handicappedStr.split(","))
                .map(Boolean::parseBoolean)
                .collect(Collectors.toList());
        for (int i = 0; i < handicappedStatusList.size(); i++) {
            this.vehicles.get(i).setHandicapped(handicappedStatusList.get(i));
        }
        return this;
    }

    public ParkingLotTestUtil setParkingTime(int... parkingTimes) {
        for (int i = 0; i < parkingTimes.length; i++) {
            this.vehicles.get(i).setParkingTimeMinutes(parkingTimes[i]);
        }
        return this;
    }

    public ParkingLotTestUtil park() {
        for (Vehicle v : this.vehicles) {
            this.parkingLot.getParkingAttendant().park(v);
        }
        return this;
    }



}
