package com.gmail.pratsaunik.ied;


import com.gmail.pratsaunik.pojo.CurrentSensor;
import com.gmail.pratsaunik.pojo.IED;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class SCADAService {



    @Autowired
    IEDRepository repository;

@Transactional
    public void saveNewProduct(IED ied) {
    ied.setCurrentSensorSet(new ArrayList<>());
    repository.save(ied);
    }
@Transactional
    public void saveNewSensor(CurrentSensor currentSensor, Long deviceId) {
    IED ied= repository.fndIEDbyId(deviceId);

    currentSensor.setIed(ied);

    List<CurrentSensor> list=ied.getCurrentSensorSet();
    list.add(currentSensor);
    repository.update(ied);
    }
}