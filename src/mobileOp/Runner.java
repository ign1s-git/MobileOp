package mobileOp;

import mobileOp.Enums.NumberType;
import mobileOp.Enums.Status;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {

        BookingService bookingService = new BookingService();
        UserService userService = new UserService();
        NumberService numberService = new NumberService();
        PlanService planService = new PlanService();


        Number number1 = numberService.createNumber("98989899", Status.FREE, NumberType.STANDARD);
        Number number2 = numberService.createNumber("98921129", Status.FREE, NumberType.PREMIUM);
        Number number3 = numberService.createNumber("9922882", Status.TAKEN, NumberType.PREMIUM);

        User user = userService.createUser("Lily", "AA12345");
        User user1 = userService.createUser("Bob", "AA55271");
        bookingService.bookingNumber(number2,user1);
        bookingService.bookingNumber(number3,user);
        bookingService.bookingNumber(number1,user);
//        user.cancelUserRequest(1);

        System.out.println(user.getBookingRequests());
        System.out.println(numberService.freeNumbers());
    }
}
