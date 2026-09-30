package org.mobileOp.repositories;

import org.mobileOp.Objects.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
