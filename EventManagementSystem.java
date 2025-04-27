import java.util.ArrayList;
import java.util.Scanner;

class Event {
    private String title;
    private String date;
    private String location;
    private String description;


    public Event(String title, String date, String location, String description) {
        this.title = title;
        this.date = date;
        this.location = location;
        this.description = description;
    }


    public void displayEvent() {
        System.out.println("Registered Events are:");
        System.out.println("Title      : " + title);
        System.out.println("Date       : " + date);
        System.out.println("Location   : " + location);
        System.out.println("Description: " + description);
        System.out.println("-------------------------------------------");
    }
}


public class EventManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Event> events = new ArrayList<>();

        System.out.println("=== Welcome to Event Management System ===");

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Register a new event");
            System.out.println("2. Show all registered events");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice;


            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Please enter a valid number!");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:

                    System.out.print("Enter Event Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Event Date in the format [yyyy-mm-dd]: ");
                    String date = scanner.nextLine();

                    System.out.print("Enter Event Location: ");
                    String location = scanner.nextLine();

                    System.out.print("Enter Event Description: ");
                    String description = scanner.nextLine();

                    Event newEvent = new Event(title, date, location, description);
                    events.add(newEvent);

                    System.out.println("Successfully Registered Your Event");
                    break;

                case 2:

                    if (events.isEmpty()) {
                        System.out.println("No upcoming events");
                    } else {
                        System.out.println("\n=== Registered Events ===");
                        for (int i = 0; i < events.size(); i++) {
                            System.out.println("\nEvent #" + (i + 1));
                            events.get(i).displayEvent();
                        }
                    }
                    break;

                case 3:

                    running = false;
                    System.out.println(" Thank you for choosing us!");
                    break;

                default:
                    System.out.println("Incorrect choice ,Please choose from 1, 2, or 3 respectively.");
            }
        }

        scanner.close();
    }
}
