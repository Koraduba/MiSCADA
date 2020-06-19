package com.gmail.pratsaunik.controller;

import com.gmail.pratsaunik.pojo.CurrentSensor;
import lombok.Data;

@Data
public class CreateCmd {

    private Long deviceId;

    private int deviceIp;

    private String feeder;

    private CurrentSensor[] sensors;
}
