package com.gauro.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Chandra
 */

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name="person")
public class Person implements Serializable {
    private static  final  long serialVersionUID=1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_Name", nullable = false, length = 80)
    private String firstName;

    @Column(nullable = false,length = 80)
    private String lastName;

    @Column(nullable = false,length = 100)
    private String address;

    @Column(nullable = false, length = 6)
    private String gender;

}
