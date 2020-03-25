package com.apap.tugas.service;

import java.util.List;

import com.apap.tugas.model.SpesialisasiModel;
import com.apap.tugas.model.PustakawanModel;
import com.apap.tugas.model.PerpustakaanModel;
import com.apap.tugas.other.AddPustakawanHandler;
import com.apap.tugas.other.ChangePustakawanHandler;


public interface PustakawanService {
	String addPustakawan(AddPustakawanHandler dataHandler);
    List<PustakawanModel> getPustakawanList();
    PustakawanModel getPustakawanByIdPustakawan(Long idPustakawan);
    String changePustakawanData(PustakawanModel pustakawan, ChangePustakawanHandler dataHandler);
    void deletePustakawan(PustakawanModel pustakawan);
    String createNipPustakawan(int jenisKelamin, String dateOfBirth);
    void addPerpustakaanToPustakawan(PustakawanModel pustakawan, PerpustakaanModel perpustakaan);
    //String addJadwal(JadwalHandler dataHandler);
   
}