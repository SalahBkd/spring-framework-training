package me.boukadi.springdatatp.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "patient")
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom")
    @NotNull
    @Size(min = 5, max = 15/*, message="my message"*/)
    private String nom;

    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaisssance;

    @Column(name = "score")
    @DecimalMin(value = "5")
    private int score;

    @Column(name = "malade")
    private boolean malade;
}
