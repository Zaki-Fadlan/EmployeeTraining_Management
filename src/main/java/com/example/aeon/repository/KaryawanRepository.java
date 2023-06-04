package com.example.aeon.repository;

import com.example.aeon.model.Karyawan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KaryawanRepository extends PagingAndSortingRepository<Karyawan, Long> {
    @Query("SELECT k from Karyawan k WHERE k.id = :id")
    Karyawan getById(@Param("id") Long myId);

}
