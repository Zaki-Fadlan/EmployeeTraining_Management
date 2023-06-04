package com.example.aeon.repository;

import com.example.aeon.model.Karyawan;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KaryawanRepository extends PagingAndSortingRepository<Karyawan, Long> {

}
