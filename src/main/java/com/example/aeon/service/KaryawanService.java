package com.example.aeon.service;

import com.example.aeon.model.Karyawan;

import java.util.Map;

public interface KaryawanService {
    public Map InsertKaryawanAndDetail(Karyawan karyawan);
    public Map UpdateKaryawanAndDetail(Karyawan karyawan);
}
