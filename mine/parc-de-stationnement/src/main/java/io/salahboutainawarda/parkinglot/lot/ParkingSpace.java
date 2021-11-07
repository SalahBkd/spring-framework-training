package io.salahboutainawarda.parkinglot.lot;

import io.salahboutainawarda.parkinglot.vehicles.Vehicle;

public class ParkingSpace {

    private ParkingSpaceType parkingSpaceType;
    private boolean isHandicapped;
    private Vehicle vehicle;

    public ParkingSpace(ParkingSpaceType parkingSpaceType) {
        this.parkingSpaceType = parkingSpaceType;
    }

    public ParkingSpace(ParkingSpaceType parkingSpaceType, boolean isHandicapped) {
        this.parkingSpaceType = parkingSpaceType;
        this.isHandicapped = isHandicapped;
    }

    public ParkingSpaceType getParkingSpaceType() {
        return parkingSpaceType;
    }

    public void setParkingSpaceType(ParkingSpaceType parkingSpaceType) {
        this.parkingSpaceType = parkingSpaceType;
    }

    public boolean isHandicapped() {
        return isHandicapped;
    }

    public void setHandicapped(boolean handicapped) {
        isHandicapped = handicapped;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean park(Vehicle vehicle) {
        return false;
    }


}
