package io.salahboutainawarda.parkinglot.vehicles;

public class TruckVehicle extends Vehicle {
    public TruckVehicle(VehicleType vehicleType, boolean isHandicapped) {
        this.setVehicleType(vehicleType);
        this.setHandicapped(isHandicapped);
    }
}
