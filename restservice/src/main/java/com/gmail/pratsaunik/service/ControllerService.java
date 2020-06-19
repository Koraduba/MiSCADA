package com.gmail.pratsaunik.service;

import com.gmail.pratsaunik.controller.ValueCmd;
import com.gmail.pratsaunik.pojo.CurrentSensor;
import com.gmail.pratsaunik.pojo.SensorValue;
import com.gmail.pratsaunik.repo.SensorRepository;
import com.gmail.pratsaunik.repo.ValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

@Service
public class ControllerService {

    @Autowired
    private ValueRepository valueRepository;

    @Autowired
    private SensorRepository sensorRepository;


/*
    public void create(CreateCmd createCmd) {
        IED ied = new IED();
        ied.setFeeder(createCmd.getFeeder());
        ied.setCurrentSensorSet(createCmd.getSensors());
        ied.setDeviceId(createCmd.getDeviceId());
        ied.setDeviceIp(createCmd.getDeviceIp());
        repository.save;
    }
*/
@Transactional
    public void value(ValueCmd valueCmd) {
        Instant instant = Instant.now();
        SensorValue sensorValue = new SensorValue();
        sensorValue.setSensorValue(valueCmd.getValue());
        sensorValue.setTimeStamp(instant.getEpochSecond());

        CurrentSensor currentSensor = sensorRepository.findById(valueCmd.getSensorId()).orElse(null);
    if (currentSensor != null) {
        sensorValue.setCurrentSensor(currentSensor);

        List<SensorValue> sensorValues=currentSensor.getSensorValues();
        sensorValues.add(sensorValue);

        sensorRepository.save(currentSensor);
    }
    }
}
