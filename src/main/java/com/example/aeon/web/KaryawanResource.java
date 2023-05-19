package com.example.aeon.web;

import com.example.aeon.dto.KayawanCreateRequestDTO;
import com.example.aeon.service.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class KaryawanResource {
    @Autowired
    private KaryawanService karyawanService;

    @PostMapping("/v1/karyawan")
    public ResponseEntity<Void> createNewKaryawan(@RequestBody KayawanCreateRequestDTO dto) throws URISyntaxException {
        karyawanService.createNewKaryawan(dto);
        return ResponseEntity.created(new URI("/v1/karyawan")).build();
    }
}
