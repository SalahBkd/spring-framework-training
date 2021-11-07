package io.salahboutainawarda.parkinglot.lot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingTest {

    @Test
    public void testParking() {
        ParkingLot lot;

        // Empty parking lot
        lot = new ParkingLotTestUtil()
                .getParkingLot();
        assertEquals(
                "",
                lot.toString(),
                "Parking lot with no spots should return empty string"

        );

        // Lot printing 1
        lot = new ParkingLotTestUtil()
                .setSpaceTypes("TRUCK,BIKE,COMPACT,LARGE")
                .getParkingLot();
        assertEquals(
                "(T)|______|      (B)|______|      (C)|______|      (L)|______|      ",
                lot.toString(),
                "Parking lot printing should work as expected"

        );

        // Lot printing 2
        lot = new ParkingLotTestUtil()
                .setSpaceTypes("TRUCK,TRUCK,TRUCK,BIKE,COMPACT,LARGE,BIKE")
                .getParkingLot();
        assertEquals(
                "(T)|______|      (T)|______|      (T)|______|      (B)|______|      (C)|______|      (L)|______|      (B)|______|      ",
                lot.toString(),
                "Parking lot printing should work as expected"

        );

        // Exact type all matching
        lot = new ParkingLotTestUtil()
                .setSpaceTypes("BIKE,BIKE,BIKE")
                .setHandicappedSpots("false,false, false")
                .setVehicles("BIKE,BIKE,BIKE")
                .setHandicappedCars("true,false,true")
                .park()
                .getParkingLot();
        assertEquals(
                "(B)|__BIKE__|      (B)|__BIKE__|      (B)|__BIKE__|      ",
                lot.toString(),
                "Vehicles should be able to park when the slots are available and there are no handicapped restrictions"

        );

        // Exact type handicapped limitation
                lot = new ParkingLotTestUtil()
                .setSpaceTypes("BIKE,BIKE,BIKE")
                .setHandicappedSpots("true,false,true")
                .setVehicles("BIKE,BIKE,BIKE")
                .setHandicappedCars("true,false,false")
                .park()
                .getParkingLot();
        assertEquals(
                "(B)|__BIKE__|      (B)|__BIKE__|      (B)|______|      ",
                lot.toString(),
                "Vehicles should be able to park when the slots are available and have handicapped permits"
        );

        // Larger slots, no limitations 1
        lot = new ParkingLotTestUtil()
                .setSpaceTypes("TRUCK,COMPACT,LARGE")
                .setHandicappedSpots("false,false, false")
                .setVehicles("BIKE,BIKE,BIKE")
                .setHandicappedCars("true,false,true")
                .park()
                .getParkingLot();
        assertEquals(
                "(T)|__BIKE__|      (C)|__BIKE__|      (L)|__BIKE__|      ",
                lot.toString(),
                "Vehicles should be able to park when larger slots are available and there are no handicapped restrictions (1)");

        // Larger slots, no limitations 2
        lot = new ParkingLotTestUtil()
                .setSpaceTypes("TRUCK,COMPACT,LARGE")
                .setHandicappedSpots("false,false, false")
                .setVehicles("BIKE,SUV,COMPACT")
                .setHandicappedCars("true,false,true")
                .park()
                .getParkingLot();
        assertEquals(
                "(T)|__BIKE__|      (C)|__COMPACT__|      (L)|______|      ",
                lot.toString(),
                "Vehicles should be able to park when larger slots are available and there are no handicapped restrictions (2)");

        // Nothing changes with a filled lot
        lot = new ParkingLotTestUtil()
                .setSpaceTypes("TRUCK,COMPACT,TRUCK")
                .setHandicappedSpots("false,false, false")
                .setVehicles("COMPACT,COMPACT,SUV")
                .park()
                .setVehicles("BIKE,BIKE,BIKE")
                .park()
                .getParkingLot();
        assertEquals(
                "(T)|__COMPACT__|      (C)|__COMPACT__|      (T)|__SUV__|      ",
                lot.toString(),
                "Nothing gets parked when the lot is full");

    }
}
