package com.example.aeon.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "rekening")
public class Rekening extends AbstractDate implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "jenis", nullable = false)
    private String jenis;
    @Column(name = "nama", nullable = false)
    private String nama;
    @Column(name = "nomor")
    private String nomor;
    @ManyToOne(targetEntity = Karyawan.class)
    private Karyawan karyawan;

}
