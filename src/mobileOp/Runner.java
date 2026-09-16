package mobileOp;

import mobileOp.Enums.NumberType;
import mobileOp.Enums.Status;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        int counter = 1;

        // Создаём номера
        mobileOp.Number number1 = new mobileOp.Number(123456, Status.Free, NumberType.Standard);
        mobileOp.Number number2 = new Number(789012, Status.Free, NumberType.Premium);

        // Создаём пользователя
        User user = new User("Иван", 12345, new ArrayList<>(), new ArrayList<>());

        // Бронируем номера
        user.bookingNumber(number1, counter++);
        user.bookingNumber(number2, counter++);

        // Выводим результаты
        System.out.println("Пользователь: " + user.getName());
        System.out.println("Количество номеров: " + user.getNumbers().size());
        System.out.println("Количество бронирований: " + user.getBookingRequests().size());

        // Выводим ID бронирований
        for (Booking booking : user.getBookingRequests()) {
            System.out.println("Booking ID: " + booking.getId());
        }
    }


}