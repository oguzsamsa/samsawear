package com.workintech.samsawear.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "card", schema = "ecommerce")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "no")
    private long no;

    @Column(name = "expire_month")
    private long expireMonth;

    @Column(name = "expire_year")
    private long expireYear;

    @Column(name = "cvv")
    private long cvv;

    @Column(name = "name_on_card")
    private String nameOnCard;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
    @JoinColumn(name = "user_id")
    private User user;
}
