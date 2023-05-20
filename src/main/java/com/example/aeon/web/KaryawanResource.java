package com.example.aeon.web;

import com.example.aeon.dto.KaryawanGetByIdDTO;
import com.example.aeon.dto.KaryawanUpdateRequestDTO;
import com.example.aeon.dto.KayawanCreateRequestDTO;
import com.example.aeon.service.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class KaryawanResource {
    @Autowired
    private KaryawanService karyawanService;

    @PostMapping("/v1/karyawan")
    public ResponseEntity<String> createNewKaryawan(@RequestBody KayawanCreateRequestDTO dto) throws URISyntaxException {
        karyawanService.createNewKaryawan(dto);
        return ResponseEntity.created(new URI("/v1/karyawan")).body("Berhasil Menambahkan Karyawan");
    }

    @GetMapping("/v1/karyawan/{ID}")
    public ResponseEntity<KaryawanGetByIdDTO> findKaryawanById(@PathVariable("ID") Long karyawanId) {
        KaryawanGetByIdDTO dto = karyawanService.findKaryawanId(karyawanId);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("v1/karyawan/{ID}")
    public ResponseEntity<Void> updateKaryawanById(@PathVariable("ID") Long karyawanId, @RequestBody KaryawanUpdateRequestDTO dto) throws URISyntaxException {
        karyawanService.updateKaryawan(karyawanId, dto);
        return ResponseEntity.ok().build();
    }
}
