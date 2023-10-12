package Guangzhou_Hotel;
import java.util.Date;

import java.util.Date;

public class Reservation {
    private static int reservationCounter = 1000;
    private int reservationNumber;
    private Date arrivalDate;
    private Customer customer;
    private RoomType roomType;

    public Reservation(Date arrivalDate, Customer customer, RoomType roomType) {
        this.arrivalDate = arrivalDate;
        this.customer = customer;
        this.roomType = roomType;
        this.reservationNumber = reservationCounter++;
    }

    public int calculateTotalCost(int numNights) {
        return roomType.getRate() * numNights;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public int getReservationNumber() {
        return 0;
    }
}

