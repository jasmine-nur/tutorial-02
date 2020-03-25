package com.apap.tugas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.tugas.model.PerpustakaanModel;
import com.apap.tugas.repository.PerpustakaanDb;

/**
 * PeprustakaanServiceImpl
 */
@Service
public class PerpustakaanServiceImpl implements PerpustakaanService {
    @Autowired
    private PerpustakaanDb perpustakaanDb;

    @Override
    public void addPerpustakaan(PerpustakaanModel perpustakaan){
        perpustakaanDb.save(perpustakaan);
    }

    @Override
    public List<PerpustakaanModel> getPerpustakaanList(){
        return perpustakaanDb.findAll();
    }

    @Override
    public PerpustakaanModel getPerpustakaanByIdPerpustakaan(Long idPerpustakaan){
        return perpustakaanDb.findByIdPerpustakaan(idPerpustakaan);
    }

    @Override
    public void deletePerpustakaan(Long idPerpustakaan){
    	PerpustakaanModel perpustakaan = getPerpustakaanByIdPerpustakaan(idPerpustakaan);
        perpustakaanDb.delete(perpustakaan);
    }
}