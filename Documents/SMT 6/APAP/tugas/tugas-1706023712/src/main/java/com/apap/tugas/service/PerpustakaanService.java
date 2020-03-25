package com.apap.tugas.service;

import java.util.List;
import com.apap.tugas.model.PerpustakaanModel;


/**
 * PerpustakaanService
 */
public interface PerpustakaanService {
	void addPerpustakaan(PerpustakaanModel perpustakaan);
    List<PerpustakaanModel> getPerpustakaanList();
    PerpustakaanModel getPerpustakaanByIdPerpustakaan(Long idPerpustakaan);
    void deletePerpustakaan(Long idPerpustakaan);
}