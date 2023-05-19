package com.example.aeon.service.impl;

import com.example.aeon.domain.DetailKaryawan;
import com.example.aeon.domain.Karyawan;
import com.example.aeon.dto.KayawanCreateRequestDTO;
import com.example.aeon.repository.DetailKaryawanRepository;
import com.example.aeon.repository.KaryawanRepository;
import com.example.aeon.service.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class KaryawanServiceImpl implements KaryawanService {
    Instant now = Instant.now();
    @Autowired
    private KaryawanRepository karyawanRepository;
    @Autowired
    private DetailKaryawanRepository detailKaryawanRepository;

    @Override
    public void createNewKaryawan(KayawanCreateRequestDTO dto) {
        Karyawan karyawan = new Karyawan();
        DetailKaryawan detailKaryawan = new DetailKaryawan();
        karyawan.setNama(dto.getNama());
        karyawan.setAlamat(dto.getAlamat());
        karyawan.setJenisKelamin(dto.getJenisKelamin());
        karyawan.setStatus(dto.getStatus());
        karyawan.setCreatedAt(Instant.ofEpochSecond(now.getEpochSecond()));
        detailKaryawan.setKaryawan(karyawan);
        detailKaryawan.setNik(dto.getNik());
        detailKaryawan.setNpwp(dto.getNpwp());
        karyawanRepository.save(karyawan);
        detailKaryawanRepository.save(detailKaryawan);
    }
}
