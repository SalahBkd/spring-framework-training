package io.salahboutainawarda.parkinglot.lot;

import io.salahboutainawarda.parkinglot.vehicles.Vehicle;

import java.util.List;

public class ParkingAttendant {
    List<ParkingSpace> parkingSpaces = null;

    public ParkingAttendant(List<ParkingSpace> parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }

    public boolean park(Vehicle vehicle) {
        for(var parkingSpace : parkingSpaces) {
            boolean isParkAndVehicleHandicapped = (parkingSpace.isHandicapped() == vehicle.isHandicapped());

            if((parkingSpace.isHandicapped() == false || isParkAndVehicleHandicapped) && parkingSpace.getVehicle() == null && (parkingSpace.getParkingSpaceType().toString().equals("BIKE")) &&
                    (vehicle.getVehicleType().toString().equals("BIKE"))) {
                parkingSpace.setVehicle(vehicle);
                break;
            }
            if((parkingSpace.isHandicapped() == false || isParkAndVehicleHandicapped) && parkingSpace.getVehicle() == null && (parkingSpace.getParkingSpaceType().toString().equals("COMPACT")) &&
                    (vehicle.getVehicleType().toString().equals("BIKE") ||
                    vehicle.getVehicleType().toString().equals("COMPACT"))) {
                parkingSpace.setVehicle(vehicle);
                break;
            }
            if((parkingSpace.isHandicapped() == false || isParkAndVehicleHandicapped) && parkingSpace.getVehicle() == null && (parkingSpace.getParkingSpaceType().toString().equals("LARGE")) &&
                    (vehicle.getVehicleType().toString().equals("BIKE") ||
                    vehicle.getVehicleType().toString().equals("COMPACT") ||
                    vehicle.getVehicleType().toString().equals("LARGE"))) {
                parkingSpace.setVehicle(vehicle);
                break;
            }
            if((parkingSpace.isHandicapped() == false || isParkAndVehicleHandicapped) && parkingSpace.getVehicle() == null && (parkingSpace.getParkingSpaceType().toString().equals("TRUCK")) &&
                    (vehicle.getVehicleType().toString().equals("BIKE") ||
                    vehicle.getVehicleType().toString().equals("COMPACT") ||
                    vehicle.getVehicleType().toString().equals("LARGE") ||
                    vehicle.getVehicleType().toString().equals("TRUCK") ||
                    vehicle.getVehicleType().toString().equals("SUV"))) {
                parkingSpace.setVehicle(vehicle);
                break;
            }
        }
        return false;
    }
}
