package com.apap.tugas.service;

import java.util.List;
import com.apap.tugas.model.SpesialisasiModel;

public interface SpesialisasiService {
	void addSpesialisasi(SpesialisasiModel spesialisasi);
	List<SpesialisasiModel> getSpesialisasiList();
	SpesialisasiModel getSpesialisasiByIdSpesialisasi(Long idSpesialisasi);
	void deleteSpesialisasi(SpesialisasiModel spesialisasi);

}
