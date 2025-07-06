package application;

import model.services.CarRental;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:m");

        System.out.print("ENTER RENTAL DATA: "
        + "\nCar model: ");
        String carModel = scanner.nextLine();

        System.out.print("Pickup (dd/mm/yyyy hh:ss): ");
        LocalDateTime pickupDate = LocalDateTime.parse(scanner.nextLine(), formatter);
        System.out.print("Return (dd/mm/yyyy hh:ss): ");
        LocalDateTime returnDate = LocalDateTime.parse(scanner.nextLine(), formatter);

        System.out.print("Enter price per hour: ");
        double pricePerHour = scanner.nextDouble();
        System.out.print("Enter price per day: ");
        double pricePerDay = scanner.nextDouble();

        CarRental carRental = new CarRental(pricePerHour, pricePerDay, pickupDate, returnDate);

        System.out.println(carRental);
    }
}
