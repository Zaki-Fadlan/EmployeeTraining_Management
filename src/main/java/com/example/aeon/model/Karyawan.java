package com.example.aeon.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "karyawan")
public class Karyawan extends AbstractDate implements Serializable {
    @JsonIgnore
    @OneToMany(mappedBy = "karyawan")
    List<KaryawanTraining> karyawanTraining;
    @JsonIgnore
    @OneToMany(mappedBy = "karyawan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<KaryawanTraining> KaryawanTraining;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "alamat", nullable = false, columnDefinition = "TEXT")
    private String alamat;
    @Column(name = "dob")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyMMdd")
    private Date dob;
    @Column(name = "jk", nullable = false)
    private String jenisKelamin;
    @Column(name = "nama", nullable = false)
    private String nama;
    @Column(name = "status", nullable = false)
    private String status;
    //    Join Column
    @OneToOne(mappedBy = "karyawan")
    private DetailKaryawan detailKaryawan;
    @JsonIgnore
    @OneToMany(mappedBy = "karyawan", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Rekening> rekening;


}
