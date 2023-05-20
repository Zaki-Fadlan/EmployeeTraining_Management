package com.example.aeon.service;

import com.example.aeon.dto.KaryawanGetByIdDTO;
import com.example.aeon.dto.KaryawanListResponseDTO;
import com.example.aeon.dto.KaryawanUpdateRequestDTO;
import com.example.aeon.dto.KayawanCreateRequestDTO;

import java.util.List;

public interface KaryawanService {
    public void createNewKaryawan(KayawanCreateRequestDTO dto);

    public KaryawanGetByIdDTO findKaryawanId(Long karyawanId);

    //    Update Karyawan +detail
    public void updateKaryawan(Long karyawanId, KaryawanUpdateRequestDTO dto);

    //    Get List Karyawan   like by nama karyawan, Pagination
    public List<KaryawanListResponseDTO> findKaryawanLikeName(String nameLike);

}
