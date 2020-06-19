package com.gmail.pratsaunik.pojo;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity

public class AppUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameOfUser;

    private String email;

    private String username;

    private String password;

    @ManyToOne(cascade=CascadeType.ALL)
    private AppRole roleOfUser;

}
