package org.mobileOp.repositories;

import org.mobileOp.Objects.Plan;
import org.mobileOp.enums.PlanType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface
PlanRepository extends JpaRepository<Plan, Long> {
    List<Plan> findByType(PlanType type);
}
