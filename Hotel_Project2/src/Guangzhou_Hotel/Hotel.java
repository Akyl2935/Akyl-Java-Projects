package Guangzhou_Hotel;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Random;


public class Hotel {
    private static ArrayList<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Hotel Management System");
            System.out.println("1. Register");
            System.out.println("2. Make a reservation");
            System.out.println("3. Check amenities");
            System.out.println("4. Cancel a reservation");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    checkAmenities();
                    break;
                case 4:
                    cancelReservation();
                    break;
                case 5:
                    System.out.println("Thank you for using the Hotel Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);
    }

    private static void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        System.out.print("Enter the number of persons with you: ");
        int numPersons = sc.nextInt();
        Customer customer = new Customer(firstName, lastName, age, numPersons);
        System.out.println("Customer registered successfully.");
    }

    private static void makeReservation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        System.out.print("Enter the number of persons with you: ");
        int numPersons = sc.nextInt();
        Customer customer = new Customer(firstName, lastName, age, numPersons);
        sc.nextLine();
        System.out.print("Enter your arrival date (dd-MM-yyyy): ");
        String arrivalDateString = sc.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date arrivalDate = null;
        try {
            arrivalDate = formatter.parse(arrivalDateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter the date in dd-MM-yyyy format.");
            return;
        }
        System.out.println("Choose the type of room: ");
        System.out.println("1. Economy (600$ per night)");
        System.out.println("2. Silver (900$ per night)");
        System.out.println("3. Gold (1400$ per night)");
        System.out.print("Enter your choice: ");
        int roomChoice = sc.nextInt();
        RoomType roomType;
        switch (roomChoice) {
            case 1:
                roomType = new RoomType("Economy", 600);
                break;
            case 2:
                roomType = new RoomType("Silver", 900);
                break;
            case 3:
                roomType = new RoomType("Gold", 1400);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                return;
        }
        Reservation reservation = new Reservation(arrivalDate, customer, roomType);
        reservations.add(reservation);
        System.out.println("Reservation made successfully. Your reservation number is " + reservation.getReservationNumber());
    }



        private static void checkAmenities() {
        System.out.println("Our hotel offers the following amenities: ");
        System.out.println("1. Fitness center");
        System.out.println("2. Spa");
        System.out.println("3. Pool");
        System.out.println("4. Restaurant");
        System.out.println("5. Wi-Fi");
    }
    private static void cancelReservation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the reservation number: ");
        int reservationNumber = sc.nextInt();
        Reservation reservation = findReservation(reservationNumber);
        if (reservation == null) {
            System.out.println("Reservation not found.");
            return;
        }
        Date today = new Date();
        long diff = today.getTime() - reservation.getArrivalDate().getTime();
        int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        if (days >= 5) {
            System.out.println("Cancellation fee of 300$ will be charged.");
        }
        reservations.remove(reservation);
        System.out.println("Reservation cancelled successfully.");
    }

    private static Reservation findReservation(int reservationNumber) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationNumber() == reservationNumber) {
                return reservation;
            }
        }
        return null;
    }
}

