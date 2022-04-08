package com.revature.Track2gether.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "amount")
    double amount;

    @Column(name= "date")
    Timestamp date;

    @ManyToOne
    private Categories category;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(referencedColumnName = "id")
    private Users user;

}
