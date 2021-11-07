package io.salahboutainawarda.parkinglot.lot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingChargeTest {

    @Test
    public void testParking() {
        ParkingLot lot;

        // First tier single vehicle 1
        lot = new ParkingLotTestUtil()
                .setSpaceTypes("BIKE")
                .setHandicappedSpots("false")
                .setVehicles("BIKE")
                .setParkingTime(10)
                .park()
                .getParkingLot();
        assertEquals(
                20,
                lot.getPaymentCounter().getTotalCash(),
                "For parking time in the first tier, charge should be 2 per minute"

        );
        // First tier single vehicle 2
        lot = new ParkingLotTestUtil()
                .setSpaceTypes("BIKE")
                .setHandicappedSpots("false")
                .setVehicles("BIKE")
                .setParkingTime(180)
                .park()
                .getParkingLot();
        assertEquals(
                360,
                lot.getPaymentCounter().getTotalCash(),
                "For parking time in the first tier, charge should be 2 per minute"

        );

        // First tier multiple vehicles
        lot = new ParkingLotTestUtil()
                .setSpaceTypes("BIKE,TRUCK,COMPACT")
                .setHandicappedSpots("false")
                .setVehicles("BIKE,SUV,COMPACT")
                .setParkingTime(180,10,100)
                .park()
                .getParkingLot();
        assertEquals(
                580,
                lot.getPaymentCounter().getTotalCash(),
                "For parking time in the first tier, charge should be 2 per minute"

        );

        // Second tier single vehicle 1
        lot = new ParkingLotTestUtil()
                .setSpaceTypes("BIKE")
                .setHandicappedSpots("false")
                .setVehicles("BIKE")
                .setParkingTime(181)
                .park()
                .getParkingLot();
        assertEquals(
                181,
                lot.getPaymentCounter().getTotalCash(),
                "For parking time in the second tier, charge should be 1 per minute"

        );
        // Second tier single vehicle 2
        lot = new ParkingLotTestUtil()
                .setSpaceTypes("BIKE")
                .setHandicappedSpots("false")
                .setVehicles("BIKE")
                .setParkingTime(1439)
                .park()
                .getParkingLot();
        assertEquals(
                1439,
                lot.getPaymentCounter().getTotalCash(),
                "For parking time in the second tier, charge should be 1 per minute"

        );

        // Second tier multiple vehicles
        lot = new ParkingLotTestUtil()
                .setSpaceTypes("BIKE,TRUCK,COMPACT")
                .setHandicappedSpots("false")
                .setVehicles("BIKE,SUV,COMPACT")
                .setParkingTime(1400,1000,700)
                .park()
                .getParkingLot();
        assertEquals(
                1400 + 1000 + 700,
                lot.getPaymentCounter().getTotalCash(),
                "For parking time in the second tier, charge should be 1 per minute"

        );


        // Third tier single vehicle 1
        lot = new ParkingLotTestUtil()
                .setSpaceTypes("BIKE")
                .setHandicappedSpots("false")
                .setVehicles("BIKE")
                .setParkingTime(1440 + 100)
                .park()
                .getParkingLot();
        assertEquals(
                700,
                lot.getPaymentCounter().getTotalCash(),
                "For parking time in the third tier, charge should be 500 for full day + 2 per minute for remaining tier 1"

        );
        // Third tier single vehicle 2
        lot = new ParkingLotTestUtil()
                .setSpaceTypes("BIKE")
                .setHandicappedSpots("false")
                .setVehicles("BIKE")
                .setParkingTime(1440 + 1440 + 300)
                .park()
                .getParkingLot();
        assertEquals(
                500 + 500 + 300,
                lot.getPaymentCounter().getTotalCash(),
                "For parking time in the third tier, charge should be 500 for full day + 1 per minute for remaining tier 2"

        );

        // Third tier multiple vehicles
        lot = new ParkingLotTestUtil()
                .setSpaceTypes("BIKE,TRUCK,COMPACT")
                .setVehicles("BIKE,SUV,COMPACT")
                .setParkingTime(1440 + 1440, 200, 1440 + 600)
                .park()
                .getParkingLot();
        assertEquals(
                500 + 500 + 200 + 500 + 600,
                lot.getPaymentCounter().getTotalCash(),
                "For parking time in the third tier, charge should be added across all vehicles"

        );

        // No charge for unparked vehicles
        lot = new ParkingLotTestUtil()
                .setSpaceTypes("BIKE,TRUCK,COMPACT")
                .setVehicles("BIKE,SUV,COMPACT,TRUCK,SUV")
                .setParkingTime(1440 + 1440, 200, 1440 + 600, 300, 1450)
                .park()
                .getParkingLot();
        assertEquals(
                500 + 500 + 200 + 500 + 600,
                lot.getPaymentCounter().getTotalCash(),
                "Vehicles should not be charged when they are unable to park"

        );

    }
}
