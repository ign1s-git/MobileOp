package org.mobileOp.repositories;

import org.mobileOp.Objects.Booking;
import org.mobileOp.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId);
    List<Booking> findByNumberId(Long numberId);
    List<Booking> findByBookingStatus(BookingStatus status);
    Optional<Booking> findByUserIdAndNumberId(Long userId, Long numberId);
}
