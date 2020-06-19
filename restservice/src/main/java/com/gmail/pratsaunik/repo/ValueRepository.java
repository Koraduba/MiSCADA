package com.gmail.pratsaunik.repo;

import com.gmail.pratsaunik.pojo.SensorValue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValueRepository extends CrudRepository<SensorValue, Long> {


}

