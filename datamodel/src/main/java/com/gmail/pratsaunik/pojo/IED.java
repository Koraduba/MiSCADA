package com.gmail.pratsaunik.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "currentSensorSet")
@ToString(exclude = "currentSensorSet")
public class IED implements Serializable {

    @Id
    private Long deviceId;

    private int deviceIp;

    private String feederName;

    @OneToMany(mappedBy = "ied", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CurrentSensor> currentSensorSet;

}

