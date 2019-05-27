package com.renny.joblogger.repository;

import com.renny.joblogger.domain.LoggerEntity;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by renrodriguez on 5/3/2016.
 */
public interface LoggerRepository extends JpaRepository<LoggerEntity, Long> {
}
