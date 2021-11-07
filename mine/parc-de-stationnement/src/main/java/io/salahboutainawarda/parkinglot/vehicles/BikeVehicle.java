package io.salahboutainawarda.parkinglot.vehicles;

public class BikeVehicle extends Vehicle {

    public BikeVehicle(VehicleType vehicleType, boolean isHandicapped) {
        this.setVehicleType(vehicleType);
        this.setHandicapped(isHandicapped);
    }
}
