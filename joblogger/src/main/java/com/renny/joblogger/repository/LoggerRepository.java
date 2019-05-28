package com.renny.joblogger.repository;

import com.renny.joblogger.domain.LoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by renrodriguez on 5/3/2016.
 */
public interface LoggerRepository extends JpaRepository<LoggerEntity, Long> {
}
