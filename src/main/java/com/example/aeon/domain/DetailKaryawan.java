package com.example.aeon.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "detail_karyawan")
public class DetailKaryawan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nik;
    private String npwp;
    @OneToOne
    @JoinColumn(name = "id_karyawan")
    private Karyawan karyawan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }

    public Karyawan getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(Karyawan karyawan) {
        this.karyawan = karyawan;
    }
}
