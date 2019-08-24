package com.oocl.cultivation;

public class ParkingBoy {

    private final ParkingLot parkingLot;
    private String lastErrorMessage;
    private boolean isRightTicket;
    private boolean isNullTicket;
    private boolean isFullParkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingTicket park(Car car) {
        if (parkingLot.getAvailableParkingPosition() <= 0) {
            isFullParkingLot = true;
            return null;
        }
        ParkingTicket ticket = parkingLot.park(car);
        isRightTicket = false;
        if (ticket != null) {
            isRightTicket = true;
        }
        return ticket;
//        throw new RuntimeException("Not implemented");
    }

    public Car fetch(ParkingTicket ticket) {
        // TODO: Please implement the method
        //throw new RuntimeException("Not implemented");
        if (ticket == null) {
            isNullTicket = true;
        }else {
            isNullTicket = false;
        }
        Car car = parkingLot.fetch(ticket);
        if (car == null) {
            isRightTicket = false;
        }
        return car;

    }

    public String getLastErrorMessage() {
        //lastErrorMessage = "Unrecognized parking ticket.";
        if (isNullTicket) {
            return "Please provide your parking ticket.";
        }else if (!isRightTicket) {
            return "Unrecognized parking ticket.";
        }else if(isFullParkingLot){
            return "The parking lot is full.";
        }
        return null;
    }
}
