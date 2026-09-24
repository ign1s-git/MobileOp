package org.mobileOp.main;

import org.mobileOp.enums.NumberType;
import org.mobileOp.enums.Status;
import org.mobileOp.Objects.*;
import org.mobileOp.Objects.Number;

public class Runner {
    public static void main(String[] args) {

        UserService userService = new UserService();
        NumberService numberService = new NumberService();
        PlanService planService = new PlanService();

        org.mobileOp.Objects.Number number1 = numberService.createNumber("98989899", Status.FREE, NumberType.STANDARD);
        org.mobileOp.Objects.Number number2 = numberService.createNumber("98921129", Status.FREE, NumberType.PREMIUM);
        Number number3 = numberService.createNumber("9922882", Status.TAKEN, NumberType.PREMIUM);

        User user = userService.createUser("Lily", "AA12345");
        User user1 = userService.createUser("Bob", "AA55271");

        BookingService bookingService = new BookingService(userService);
        bookingService.bookingNumber(number2,user1);
        bookingService.bookingNumber(number3,user);
        bookingService.bookingNumber(number1,user);

//        user.cancelUserRequest(1);

        System.out.println(user.getBookingRequests());
        System.out.println(numberService.freeNumbers());
    }
}
