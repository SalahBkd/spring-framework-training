package io.salahboutainawarda.parkinglot.lot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private List<ParkingSpace> parkingSpaces = new ArrayList<>();
    private PaymentCounter paymentCounter = new PaymentCounter();
    private ParkingAttendant parkingAttendant;

    public ParkingAttendant getParkingAttendant() {
        return parkingAttendant;
    }

    public PaymentCounter getPaymentCounter() {
        return paymentCounter;
    }

    public List<ParkingSpace> getParkingSpaces() {
        return parkingSpaces;
    }

    public void setParkingSpaces(List<ParkingSpace> parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
        parkingAttendant = new ParkingAttendant(parkingSpaces);
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();

        for(var parkingSpace : parkingSpaces) {
            String vehicleType = null;
            if(parkingSpace.getVehicle() != null) {
                vehicleType = parkingSpace.getVehicle().getVehicleType().toString();
            }

            String parkingSpaceType = parkingSpace.getParkingSpaceType().toString();

            if(parkingSpace.getVehicle() != null && parkingSpaceType.equals("COMPACT")) {
                strBuilder.append("(C)|__"+ vehicleType +"__|      ");
            } else if(parkingSpaceType.equals("COMPACT")) {
                strBuilder.append("(C)|______|      ");
            }

            if(parkingSpace.getVehicle() != null && parkingSpaceType.equals("LARGE")) {
                strBuilder.append("(L)|__"+ vehicleType +"__|      ");
            } else if(parkingSpaceType.equals("LARGE")) {
                strBuilder.append("(L)|______|      ");
            }

            if(parkingSpace.getVehicle() != null && parkingSpaceType.equals("TRUCK")) {
                strBuilder.append("(T)|__"+ vehicleType +"__|      ");
            } else if(parkingSpaceType.equals("TRUCK")) {
                strBuilder.append("(T)|______|      ");
            }

            if(parkingSpace.getVehicle() != null && parkingSpaceType.equals("BIKE") && vehicleType.equals("BIKE")) {
                strBuilder.append("(B)|__"+ vehicleType +"__|      ");
            } else if(parkingSpaceType.equals("BIKE")) {
                strBuilder.append("(B)|______|      ");
            }
        }
       return strBuilder.toString();
    }


}
