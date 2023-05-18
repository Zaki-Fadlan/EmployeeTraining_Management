package com.example.aeon.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "karyawan_training")
public class KaryawanTraining implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;
    @Column(name = "deleted_at")
    private Instant deletedAt;
    @Column(name = "updated_at")
    private Instant updatedAt;
    @Column(name = "tanggal_training", nullable = false)
    private Instant tanggalTraining;
    @ManyToOne
    @JoinColumn(name = "karyawan_id")
    private Karyawan karyawan;
    @ManyToOne
    @JoinColumn(name = "training_id")
    private Training training;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Instant getTanggalTraining() {
        return tanggalTraining;
    }

    public void setTanggalTraining(Instant tanggalTraining) {
        this.tanggalTraining = tanggalTraining;
    }

    public Karyawan getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(Karyawan karyawan) {
        this.karyawan = karyawan;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }
}
