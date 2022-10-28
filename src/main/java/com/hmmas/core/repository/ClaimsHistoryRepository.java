package com.hmmas.core.repository;


import com.hmmas.core.models.ClaimsHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimsHistoryRepository extends JpaRepository<ClaimsHistory, Long> {
}
