package com.eden.imageparser.repository;

import com.eden.imageparser.model.RequestLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestLogRepository extends JpaRepository<RequestLog, Long> {
}
