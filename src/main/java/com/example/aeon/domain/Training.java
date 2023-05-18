package com.example.aeon.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "training")
public class Training implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_date", nullable = false)
    private Instant createdDate;
    @Column(name = "deleted_date")
    private Instant deletedDate;
    @Column(name = "updated_date")
    private Instant updatedDate;
    @Column(name = "nama_pengajar", nullable = false)
    private String namaPengajar;
    @Column(name = "tema", nullable = false)
    private String tema;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getDeletedDate() {
        return deletedDate;
    }

    public void setDeletedDate(Instant deletedDate) {
        this.deletedDate = deletedDate;
    }

    public Instant getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Instant updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getNamaPengajar() {
        return namaPengajar;
    }

    public void setNamaPengajar(String namaPengajar) {
        this.namaPengajar = namaPengajar;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
}
