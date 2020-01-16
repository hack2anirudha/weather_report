package com.ptmd.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ptmd.entity.WeatherReportEntity;

/**
 * WeatherRepository extends from MongoRepository.
 * 
 * @author ANNI
 *
 */
@Repository
public interface WeatherRepository extends MongoRepository<WeatherReportEntity, Long> {
}
