package mobileOp;

import mobileOp.Enums.NumberType;
import mobileOp.Enums.Status;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {

        BookingService bookingService = new BookingService();
        UserService userService = new UserService();
        Number number1 = new Number("98989899", Status.FREE, NumberType.STANDARD);
        Number number2 = new Number("98921129", Status.FREE, NumberType.PREMIUM);
        Number number3 = new Number("9922882", Status.FREE, NumberType.PREMIUM);

        User user = userService.createUser("Lily", "AA12345");
        User user1 = userService.createUser("Bob", "AA55271");
        bookingService.bookingNumber(number2,user1);
        bookingService.bookingNumber(number3,user);
        bookingService.bookingNumber(number1,user);

        bookingService.cancelRequest(1,1);

        System.out.println(user.getAllRequests());
//        System.out.println(user1.getAllRequests());
//        System.out.println(bookingService.getAllBookings().size());
//        System.out.println("\n");
    }
}
