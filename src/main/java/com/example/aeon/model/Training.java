package com.example.aeon.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "training")
public class Training extends AbstractDate implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_pengajar", nullable = false)
    private String namaPengajar;
    @Column(name = "tema", nullable = false)
    private String tema;

    @JsonIgnore
    @OneToMany(mappedBy = "training", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<KaryawanTraining> karyawanTraining;
}
