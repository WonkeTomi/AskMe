package com.askme.AskMe.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table
public class Client {

    @Column
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String userName;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;
}
