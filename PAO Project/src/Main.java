import Model.*;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}
public class Main {
    public static void main(String[] args) {
        var instance = Service.getInstance();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("1. Add a passenger in system");
            System.out.println("2. List all passengers of the system");
            System.out.println("3. Find a certain passenger in the system with the given last name and change some details");
            System.out.println("4. Choose a number for your train to check the stations for each route");
            System.out.println("5. Add a passenger with some certain details");
            System.out.println("6. Print the routes for a train");
            System.out.println("7. Search a train by id");
            System.out.println("8. Find the passenger for given train, coach and seat IDs");
            System.out.println("9. ");
            System.out.println("10. ");
            System.out.println("11. Find the available seats for a certain train by ID");
            System.out.println("12. ");
            System.out.println("13. Using an train id, find different details, like routes or coaches");
            System.out.println("14. Print all tickets a train has until that moment");
            System.out.println("15. ");
            System.out.println("16. Stop the program!");

            var choice = scanner.next();
            switch (choice) {
                case "1" -> {
                    System.out.println("Enter your name: ");
                    String name = scanner.next();
                    System.out.println("Enter your surname: ");
                    String surname = scanner.next();
                    System.out.println("Enter your age: ");
                    Integer age = scanner.nextInt();
                    System.out.println("Enter your email: ");
                    var email = scanner.next();
                    System.out.println("Enter your phone: ");
                    var phone = scanner.next();
                    System.out.println("Enter your password: ");
                    String password = scanner.next();
                    instance.createPassenger(name, surname, age, email, phone, password);
                }

                case "2" -> {
                    List<Passenger> passengerList = instance.getPassengers();
                    for(Passenger passenger: passengerList) {
                        System.out.println("\n" + "Name: " + passenger.getFirstName() + "\n" + "Surname: " + passenger.getLastName() +
                                "\n" + "Age: " + passenger.getAge() + "\n" + "Email: " + passenger.getEmail() + "\n" + "Phone: " + passenger.getContactNumber() +
                                "\n" + "Hashed password: " + passenger.getPassword().hashCode());
                    }
                }

                case "3" -> {
                    System.out.println("Enter your surname: ");
                    String surname = scanner.next();
                    System.out.println("Enter your email: ");
                    var email = scanner.next();
                    System.out.println("Enter your phone: ");
                    var phone = scanner.next();
                    System.out.println("Enter the name you want to switch: ");
                    var sname = scanner.next();
                    instance.modifyPassengerInformation(surname, sname, email, phone);
                }

                case "4" -> {
                    System.out.println("Enter the number: ");
                    Integer nr = scanner.nextInt();
                    List<List<Station>> routeStat = instance.StationsPerRoute(nr);
                }

                case "5" -> {
                    System.out.println("Enter your name: ");
                    String name = scanner.next();
                    System.out.println("Enter your surname: ");
                    String surname = scanner.next();
                    System.out.println("Enter your age: ");
                    Integer age = scanner.nextInt();
                    System.out.println("Enter your email: ");
                    var email = scanner.next();
                    System.out.println("Enter your phone: ");
                    var phone = scanner.next();
                    System.out.println("Enter your password: ");
                    String password = scanner.next();
                    instance.createPassenger(name, surname, age, email, phone, password);
                    System.out.println("Choose a train: ");
                    Integer number = scanner.nextInt();

                }

                case "6" -> {
                    System.out.println("Enter a number: ");
                    Integer id = scanner.nextInt();
                    List<Route> routes = instance.getTrainRoute(id);
                    for(Route route: routes) {
                        System.out.println(route.toString());
                    }
                }

                case "7" -> {
                    System.out.println("Enter a number: ");
                    Integer id = scanner.nextInt();
                    List<Train> tren = instance.searchTrain(id);
                    tren.toString();
                }

                case "8" -> {
                    System.out.println("Enter train ID: ");
                    Integer id_t = scanner.nextInt();
                    System.out.println("Enter coach ID: ");
                    Integer id_c = scanner.nextInt();
                    System.out.println("Enter seat_id: ");
                    Integer id_s = scanner.nextInt();

                    instance.findPassengerInSeatNumber(id_t, id_c, id_s);
                }

                case "9" -> {

                }

                case "10" -> {

                }

                case "11" -> {
                    System.out.println("Enter train ID: ");
                    Integer id_t = scanner.nextInt();
                    List<Seat> seats = instance.checkSeatAvailability(id_t);
                    for(Seat seat: seats) {
                        System.out.println(seat.toString() + "\n");
                    }
                }

                case "12" -> {

                }

                case "13" -> {
                    System.out.println("Enter a number: ");
                    Integer number = scanner.nextInt();
                    instance.printTrainData(number);
                }

                case "14" -> {
                    System.out.println("Enter a number: ");
                    Integer number = scanner.nextInt();
                    instance.printTrainTickets(number);
                }

                case "15" -> {

                }

                case "16" -> System.exit(0);
            }
            System.out.println("To end the program press 16");
        }
//        Service.createPassenger("Andrei-Daniel", "Tava", 20, "andreiutz@gmail.com", "0777666777", "5t31n3rTr33S");
//        Service.createPassenger("Petrik", "Simion", 20, "petricasimion@gmail.com", "0769776969", "M4t3y3st3l3n3s");
//        Service.createPassenger("Robert", "Rosianu", 20, "rosianurobert@yahoo.com", "0745367507", "t4l3ntb1gb4g");
//        Service.createPassenger("Tiberiu-Nicolae", "Titirga", 20, "titirisca@gmail.com", "0723665048", "b4h01iq102");
//        Service.createPassenger("Andrei", "Lefter", 20, "andlft@gmail.com", "0775662702", "tR45h153k41");
//        Service.createPassenger()
        ///schema: Person -> Passenger
        ///Route -> Intercity

    }
}