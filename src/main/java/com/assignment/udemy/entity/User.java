package com.assignment.udemy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(
        name = "user_tbl",
        uniqueConstraints = @UniqueConstraint(
                name = "emailid_unique",
                columnNames = "email"
        )
)
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private int id;
    private String name;
    private String bio;
    private String interest;
    @Column(
            name = "email",
            nullable = false
    )
    private String email;

    @ManyToMany
    @JoinTable(
            name = "user_course_cart",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    private List<Course> cartList;

    @ManyToMany
    @JoinTable(
            name = "user_course_order",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    private List<Course> orderList;

    public void addCourse(Course course){
        if (orderList.size() == 0){
            orderList = new ArrayList<>();
        }
        orderList.add(course);
    }

    public void addCart(Course course){
        if(cartList.size() == 0){
            cartList = new ArrayList<>();
        }
        cartList.add(course);
    }
}
