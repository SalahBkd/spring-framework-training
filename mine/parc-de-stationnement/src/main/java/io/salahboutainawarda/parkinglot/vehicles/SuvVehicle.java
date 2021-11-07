package io.salahboutainawarda.parkinglot.vehicles;

public class SuvVehicle extends Vehicle {
    public SuvVehicle(VehicleType vehicleType, boolean isHandicapped) {
        this.setVehicleType(vehicleType);
        this.setHandicapped(isHandicapped);
    }
}
