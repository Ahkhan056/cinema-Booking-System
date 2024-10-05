import java.util.Scanner;

public class bookingSystem {
    private int[][] seats;  // 2D array to represent the seating arrangement

    // Constructor to initialize the seating arrangement (5 rows, 5 columns as an example)
    public bookingSystem(int rows, int cols) {
        seats = new int[rows][cols];
    }

    // Method to display the current seating arrangement
    public void displaySeatingArrangement() {
        System.out.println("Current Seating Arrangement:");
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to book a seat
    public void bookSeat(int row, int seat) {
        if (row >= 0 && row < seats.length && seat >= 0 && seat < seats[0].length) {
            if (seats[row][seat] == 0) {
                seats[row][seat] = 1;  // Mark seat as booked
                System.out.println("Seat booked successfully.");
            } else {
                System.out.println("Sorry, the seat is already booked.");
            }
        } else {
            System.out.println("Invalid seat number.");
        }
    }

    // Method to cancel a booking
    public void cancelBooking(int row, int seat) {
        if (row >= 0 && row < seats.length && seat >= 0 && seat < seats[0].length) {
            if (seats[row][seat] == 1) {
                seats[row][seat] = 0;  // Mark seat as available
                System.out.println("Booking cancelled successfully.");
            } else {
                System.out.println("Seat is not booked.");
            }
        } else {
            System.out.println("Invalid seat number.");
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       bookingSystem cinema = new bookingSystem(5, 5);  // 5x5 seating arrangement as an example
        boolean running = true;

        while (running) {
            // Display menu
            System.out.println("\nCinema Booking System Menu:");
            System.out.println("1. Display Seating Arrangement");
            System.out.println("2. Book a Seat");
            System.out.println("3. Cancel a Booking");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    cinema.displaySeatingArrangement();
                    break;
                case 2:
                    System.out.print("Enter row number (0-4): ");
                    int rowToBook = sc.nextInt();
                    System.out.print("Enter seat number (0-4): ");
                    int seatToBook = sc.nextInt();
                    cinema.bookSeat(rowToBook, seatToBook);
                    break;
                case 3:
                    System.out.print("Enter row number (0-4): ");
                    int rowToCancel = sc.nextInt();
                    System.out.print("Enter seat number (0-4): ");
                    int seatToCancel = sc.nextInt();
                    cinema.cancelBooking(rowToCancel, seatToCancel);
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        sc.close();  // Close the scanner
    }
}
