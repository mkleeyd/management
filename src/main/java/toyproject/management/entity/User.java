package toyproject.management.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class User {

    @Id @GeneratedValue @Column(name = "userId")
    private Long id;
    private String username;
    private String phoneNum;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Embedded
    private Address address;

}/////
