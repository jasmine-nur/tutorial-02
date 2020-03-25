package com.apap.tugas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tugas.model.PustakawanModel;


@Repository
public interface PustakawanDb extends JpaRepository<PustakawanModel, Long> {
    PustakawanModel findByIdPustakawan(Long idPustakawan);
   
}