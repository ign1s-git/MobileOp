package org.mobileOp.main;

import org.mobileOp.config.AppConfig;
import org.mobileOp.enums.NumberType;
import org.mobileOp.enums.Status;
import org.mobileOp.Objects.*;
import org.mobileOp.Objects.Number;
import org.mobileOp.services.BookingService;
import org.mobileOp.services.NumberService;
import org.mobileOp.services.PlanService;
import org.mobileOp.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        // Initialize Spring Context (Pure Spring Framework without Spring Boot)
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve Spring-managed beans from IoC container
        UserService userService = context.getBean(UserService.class);
        NumberService numberService = context.getBean(NumberService.class);
        PlanService planService = context.getBean(PlanService.class);
        BookingService bookingService = context.getBean(BookingService.class);

        org.mobileOp.Objects.Number number1 = numberService.createNumber("98989899", Status.FREE, NumberType.STANDARD);
        org.mobileOp.Objects.Number number2 = numberService.createNumber("98921129", Status.FREE, NumberType.PREMIUM);
        Number number3 = numberService.createNumber("9922882", Status.TAKEN, NumberType.PREMIUM);

        User user = userService.createUser("Lily", "AA12345");
        User user1 = userService.createUser("Bob", "AA55271");

        bookingService.bookingNumber(number2, user1);
        bookingService.bookingNumber(number3, user);
        bookingService.bookingNumber(number1, user);

        System.out.println("User booking requests: " + user.getBookingRequests());
        System.out.println("Free numbers: " + numberService.getFreeNumbers());

        context.close();
    }
}
