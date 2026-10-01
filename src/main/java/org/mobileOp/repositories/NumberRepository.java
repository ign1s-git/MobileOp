package org.mobileOp.repositories;

import org.mobileOp.Objects.Number;
import org.mobileOp.enums.NumberType;
import org.mobileOp.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NumberRepository extends JpaRepository<Number, Long> {
    Optional<Number> findByNumber(String number);
    List<Number> findByStatus(Status status);
    List<Number> findByNumberType(NumberType numberType);
    List<Number> findByStatusAndNumberType(Status status, NumberType numberType);
}
