package com.example.aeon.service.impl;

import com.example.aeon.domain.DetailKaryawan;
import com.example.aeon.domain.Karyawan;
import com.example.aeon.dto.KaryawanGetByIdDTO;
import com.example.aeon.dto.KaryawanListResponseDTO;
import com.example.aeon.dto.KaryawanUpdateRequestDTO;
import com.example.aeon.dto.KayawanCreateRequestDTO;
import com.example.aeon.exception.ResourceNotFoundException;
import com.example.aeon.repository.DetailKaryawanRepository;
import com.example.aeon.repository.KaryawanRepository;
import com.example.aeon.service.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

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

    @Override
    public KaryawanGetByIdDTO findKaryawanId(Long karyawanId) {
        KaryawanGetByIdDTO dto = new KaryawanGetByIdDTO();
        Karyawan karyawan = karyawanRepository.findById(karyawanId).orElseThrow(() -> new ResourceNotFoundException("karyawan.not.found"));
        DetailKaryawan detailKaryawan = detailKaryawanRepository.findByKaryawanId(karyawan.getId());
        dto.setNama(karyawan.getNama());
        dto.setJenisKelamin(karyawan.getJenisKelamin());
        dto.setAlamat(karyawan.getAlamat());
        dto.setNik(detailKaryawan.getNik());
        dto.setNpwp(detailKaryawan.getNpwp());
        dto.setStatus(karyawan.getStatus());
        return dto;
    }

    @Override
    public List<KaryawanListResponseDTO> findKaryawanLikeName(String nameLike) {
        return null;
    }

    @Override
    public void updateKaryawan(Long karyawanId, KaryawanUpdateRequestDTO dto) {
        Karyawan karyawan = karyawanRepository.findById(karyawanId)
                .orElseThrow(() -> new ResourceNotFoundException("karyawan.not.found"));
        DetailKaryawan detailKaryawan = detailKaryawanRepository.findByKaryawanId(karyawanId);
        karyawan.setNama(dto.getNama());
        karyawan.setAlamat(dto.getAlamat());
        karyawan.setStatus(dto.getStatus());
        karyawan.setJenisKelamin(dto.getJenisKelamin());
        karyawan.setUpdatedAt(Instant.ofEpochSecond(now.getEpochSecond()));
        detailKaryawan.setNpwp(dto.getNpwp());
        detailKaryawan.setNik(dto.getNik());
        karyawanRepository.save(karyawan);
        detailKaryawanRepository.save(detailKaryawan);
    }


}
