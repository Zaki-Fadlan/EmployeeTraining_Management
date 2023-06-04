package com.example.aeon.controller;

import com.example.aeon.model.Karyawan;
import com.example.aeon.service.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/karyawan")
public class KaryawanController {
    @Autowired
    KaryawanService karyawanService;

    @PostMapping("/add")
    public ResponseEntity<Map> save(@RequestBody Karyawan objekKaryawan) {
        Map map = new HashMap<>();
        Map objek = karyawanService.InsertKaryawanAndDetail(objekKaryawan);
        return new ResponseEntity<Map>(objek, HttpStatus.OK);
    }
}
