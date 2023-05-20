package com.example.aeon.repository;

import com.example.aeon.domain.Karyawan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KaryawanRepository extends JpaRepository<Karyawan, Long> {
    public List<Karyawan> findAllByNamaLike(String nama);
}
