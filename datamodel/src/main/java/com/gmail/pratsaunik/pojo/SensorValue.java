package com.gmail.pratsaunik.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.crypto.Cipher;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
public class SensorValue implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    CurrentSensor currentSensor;

    Double sensorValue;

    Long timeStamp;

    }
}
