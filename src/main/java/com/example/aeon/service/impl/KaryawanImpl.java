package com.example.aeon.service.impl;

import com.example.aeon.MyResponse;
import com.example.aeon.model.DetailKaryawan;
import com.example.aeon.model.Karyawan;
import com.example.aeon.repository.DetailKaryawanRepository;
import com.example.aeon.repository.KaryawanRepository;
import com.example.aeon.service.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class KaryawanImpl implements KaryawanService {
    @Autowired
    public KaryawanRepository karyawanRepository;
    @Autowired
    public DetailKaryawanRepository detailKaryawanRepository;
    @Autowired
    public MyResponse myResponse;

    @Override
    public Map InsertKaryawanAndDetail(Karyawan karyawan) {
        try {
            if (karyawan.getNama() == null) {
                return myResponse.BadRequest("Nama karyawan tidak boleh kosong");
            }
            if (karyawan.getDetailKaryawan() == null) {
                return myResponse.BadRequest("Detail Karyawan tidak boleh kosong");
            }
            if (karyawan.getDetailKaryawan().getNik() == null || karyawan.getDetailKaryawan().getNpwp() == null) {
                return myResponse.BadRequest("NIK dan NPWP tidak boleh kosong");
            }

            Karyawan dataKaryawan = new Karyawan();
            dataKaryawan.setNama(karyawan.getNama());
            dataKaryawan.setJenisKelamin(karyawan.getJenisKelamin());
            dataKaryawan.setAlamat(karyawan.getAlamat());
            dataKaryawan.setDob(karyawan.getDob());
            dataKaryawan.setStatus(karyawan.getStatus());

            Karyawan dataKaryawanBaru = karyawanRepository.save(dataKaryawan);

            DetailKaryawan dataDetilKaryawan = new DetailKaryawan();
            dataDetilKaryawan.setNik(karyawan.getDetailKaryawan().getNik());
            dataDetilKaryawan.setNpwp(karyawan.getDetailKaryawan().getNpwp());

            dataDetilKaryawan.setKaryawan(dataKaryawanBaru);

            detailKaryawanRepository.save(dataDetilKaryawan);

            dataKaryawanBaru.setDetailKaryawan(dataDetilKaryawan);

            return myResponse.OkRequest(dataKaryawanBaru, "Karyawan berhasil ditambahkan");

        } catch (Exception e) {
            return myResponse.ErrorRequest(e);
        }
    }

    @Override
    public Map UpdateKaryawanAndDetail(Karyawan karyawan) {
        try {

            if (karyawan.getNama() == null) {
                return myResponse.BadRequest("Tolong masukan nama karyawan");
            }
            if (karyawan.getNama().isEmpty()) {
                return myResponse.BadRequest("Tolong masukan nama karyawan dengan benar");
            }
            if (karyawan.getDetailKaryawan() == null) {
                return myResponse.BadRequest("Tolong masukan Detail karyawan dengan benar");
            }
            if (karyawanRepository.getById(karyawan.getId()) == null) {
                return myResponse.BadRequest("Id Karyawan tidak ditemukan");
            }
            if (karyawan.getDetailKaryawan().getNik() == null) {
                return myResponse.BadRequest("Tolong lengkapi NIK karyawan");
            }
            Karyawan dataKaryawan = karyawanRepository.getById(karyawan.getId());
            dataKaryawan.setNama(karyawan.getNama());
            dataKaryawan.setDob(karyawan.getDob());
            dataKaryawan.setStatus(karyawan.getStatus());
            dataKaryawan.setJenisKelamin(karyawan.getJenisKelamin());
            dataKaryawan.setAlamat(karyawan.getAlamat());

            dataKaryawan.getDetailKaryawan().setNpwp(karyawan.getDetailKaryawan().getNpwp());
            dataKaryawan.getDetailKaryawan().setNik(karyawan.getDetailKaryawan().getNik());

            Karyawan updateDataKaryawan = karyawanRepository.save(dataKaryawan);
            return myResponse.OkRequest(updateDataKaryawan, "Data Karyawan berhasil diperbaharui");

        } catch (Exception e) {
            return myResponse.ErrorRequest(e);
        }
    }

}
