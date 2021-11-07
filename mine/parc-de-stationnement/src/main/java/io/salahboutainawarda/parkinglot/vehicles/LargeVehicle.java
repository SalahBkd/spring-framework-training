package io.salahboutainawarda.parkinglot.vehicles;

public class LargeVehicle extends Vehicle {
    public LargeVehicle(VehicleType vehicleType, boolean isHandicapped) {
        this.setVehicleType(vehicleType);
        this.setHandicapped(isHandicapped);
    }
}
