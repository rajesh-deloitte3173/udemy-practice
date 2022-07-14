package com.assignment.udemy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private int id;
    private String name;
    private String domain;
    private String description;
    private String author;
    private float price;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime duration;
    private String Reviews;
    private int rating;

    @JsonIgnore
    @ManyToMany(mappedBy = "cartList")
    private List<User> userCart;

    @JsonIgnore
    @ManyToMany(mappedBy = "orderList")
    private List<User> userOrder;
}
