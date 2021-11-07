package io.salahboutainawarda.parkinglot.vehicles;

public class VehicleFactory {

    public static Vehicle createVehicle(VehicleType vehicleType, boolean isHandicapped) {
        Vehicle vehicle = null;

        switch(vehicleType) {
            case BIKE:
                vehicle = new BikeVehicle(vehicleType, isHandicapped);
                break;
            case COMPACT:
                vehicle = new CompactVehicle(vehicleType, isHandicapped);
                break;
            case LARGE:
                vehicle = new LargeVehicle(vehicleType, isHandicapped);
                break;
            case SUV:
                vehicle = new SuvVehicle(vehicleType, isHandicapped);
                break;
            case TRUCK:
                vehicle = new TruckVehicle(vehicleType, isHandicapped);
                break;
            default:
                break;
        }
        return vehicle;
    }
}
