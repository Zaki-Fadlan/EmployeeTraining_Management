package com.example.aeon.controller;

import com.example.aeon.MyResponse;
import com.example.aeon.model.Karyawan;
import com.example.aeon.repository.KaryawanRepository;
import com.example.aeon.service.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/karyawan")
public class KaryawanController {
    @Autowired
    public KaryawanRepository karyawanRepository;
    @Autowired
    KaryawanService karyawanService;
    @Autowired
    MyResponse myResponse;

    @PostMapping("/add")
    public ResponseEntity<Map> save(@RequestBody Karyawan objekKaryawan) {
        Map map = new HashMap<>();
        Map objek = karyawanService.InsertKaryawanAndDetail(objekKaryawan);
        return new ResponseEntity<Map>(objek, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Map> update(@RequestBody Karyawan objekKaryawan) {
        Map objek = karyawanService.UpdateKaryawanAndDetail(objekKaryawan);
        return new ResponseEntity<Map>(objek, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map> getId(@PathVariable(value = "id") Long id) {
        Karyawan objek = karyawanRepository.getById(id);
        return new ResponseEntity<Map>((myResponse.OkRequest(objek, "Berhasil menemukan data")), HttpStatus.OK);
    }


}
