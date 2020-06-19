package com.gmail.pratsaunik.repo;

import com.gmail.pratsaunik.pojo.CurrentSensor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends CrudRepository<CurrentSensor, Long> {



}
