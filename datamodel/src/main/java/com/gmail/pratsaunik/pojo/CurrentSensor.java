package com.gmail.pratsaunik.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(exclude = "sensorValues")
@ToString(exclude = "sensorValues")
public class CurrentSensor implements Serializable {

    @Id
    private Long sensorId;


    @ManyToOne(fetch = FetchType.EAGER)
    private IED ied;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<SensorValue> sensorValues=new ArrayList<>();

}
