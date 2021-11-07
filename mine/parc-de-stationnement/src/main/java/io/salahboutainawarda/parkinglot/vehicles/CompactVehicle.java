package io.salahboutainawarda.parkinglot.vehicles;

public class CompactVehicle extends Vehicle {
    public CompactVehicle(VehicleType vehicleType, boolean isHandicapped) {
        this.setVehicleType(vehicleType);
        this.setHandicapped(isHandicapped);
    }
}
