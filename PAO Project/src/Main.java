import Model.*;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDateTime;

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}
public class Main {
    public static void main(String[] args) {
        Service.createPassenger("Andrei-Daniel", "Tava", 20, "andreiutz@gmail.com", "0777666777", "5t31n3rTr33S");
        Service.createPassenger("Petrik", "Simion", 20, "petricasimion@gmail.com", "0769776969", "M4t3y3st3l3n3s");
        Service.createPassenger("Robert", "Rosianu", 20, "rosianurobert@yahoo.com", "0745367507", "t4l3ntb1gb4g");
        Service.createPassenger("Tiberiu-Nicolae", "Titirga", 20, "titirisca@gmail.com", "0723665048", "b4h01iq102");
        Service.createPassenger("Andrei", "Lefter", 20, "andlft@gmail.com", "0775662702", "tR45h153k41");

    }
}