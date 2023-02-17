package com.codegym.hospital.controller;

import com.codegym.hospital.model.MedicalFile;
import com.codegym.hospital.service.medical_file.impl.MedicalFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")

public class RestHospitalController {
    @Autowired
    private MedicalFileService medicalFileService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<MedicalFile>> listMedicalFile() {
        List<MedicalFile> medicalFileList = medicalFileService.getAll();
        if (medicalFileList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicalFileList, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MedicalFile> deleteMedicalFile(@PathVariable("id") int id) {
        medicalFileService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping(value = "/update/{id}")
    public ResponseEntity<MedicalFile> updateMedicalFile(@RequestBody MedicalFile medicalFile, @PathVariable("id") int id) {
        medicalFileService.update(medicalFile.getDoctor(), medicalFile.isFlag(), medicalFile.getHospitalDischargeDate(), medicalFile.getHospitalizedDay(), medicalFile.getPatientName(), medicalFile.getPatientCode(), medicalFile.getReason(), medicalFile.getTreatments(), id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<MedicalFile> createMedicalFile(@RequestBody MedicalFile medicalFile) {
        medicalFileService.create(medicalFile);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/findById/{id}")
    private ResponseEntity<MedicalFile> findByIdMedicalFile(@PathVariable("id") Integer id) {
        MedicalFile medicalFile = medicalFileService.findByIdMedicalFile(id);
        return new ResponseEntity<>(medicalFile, HttpStatus.OK);
    }

}
