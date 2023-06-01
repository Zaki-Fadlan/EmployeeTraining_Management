package com.example.aeon.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "karyawan_training")
public class KaryawanTraining extends AbstractDate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tanggal_training", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyMMdd")
    private Date tanggalTraining;

    @ManyToOne(targetEntity = Karyawan.class)
    private Karyawan karyawan;
    @ManyToOne(targetEntity = Training.class)
    private Training training;

}
