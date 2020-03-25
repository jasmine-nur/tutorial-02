package com.apap.tugas.controller;

import com.apap.tugas.model.PerpustakaanModel;
import com.apap.tugas.model.PustakawanModel;
import com.apap.tugas.model.SpesialisasiModel;
import com.apap.tugas.other.AddPustakawanHandler;
import com.apap.tugas.other.ChangePustakawanHandler;
import com.apap.tugas.other.JadwalHandler;
import com.apap.tugas.service.PerpustakaanService;
import com.apap.tugas.service.SpesialisasiService;
import com.apap.tugas.service.PustakawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PustakawanController {
    @Autowired
    private PustakawanService pustakawanService;
    
    @Autowired
    private PerpustakaanService perpustakaanService;
    
    @Autowired
    private SpesialisasiService spesialisasiService;

    
    //membuka halaman utama SIP
    @GetMapping("/")
    public String home(Model model) {
    	List<PustakawanModel> pustakawanList = pustakawanService.getPustakawanList();
    	model.addAttribute("pustakawanList", pustakawanList);
    	return "homepage";
    }
    
    //menambahkan pustakawan
    //membuka form untuk menambahkan pustakawan
    @GetMapping(value="/pustakawan/tambah")
    public String showAddPustakawanForm(@ModelAttribute("addHandler") AddPustakawanHandler addHandler, Model model) {
    	List<SpesialisasiModel> spesialisasiList = spesialisasiService.getSpesialisasiList();
    	model.addAttribute("spesialisasiList", spesialisasiList);
    	return "pustakawan-add.html";
    }
    
    //melakukan submit form untuk menambahkan pustakawan
    @PostMapping(value = "/pustakawan/tambah")
    public String submitAddPustakawanForm(@ModelAttribute("addHandler") AddPustakawanHandler addHandler, Model model) {
    	String idPustakawan = pustakawanService.addPustakawan(addHandler);
    	model.addAttribute(
    			"pesan", "Pustakawan " + addHandler.getNamaPustakawan()+ " dengan kode pustakawan " + idPustakawan + " berhasil ditambahkan!"
    	);
    	return "message-info";
    	
    }
    
    //membuka detail dari pustakawan 
    @GetMapping(value = "/pustakawan/detail/{idPustakawan}")
    public String showPustakawanInfoById(@PathVariable(value = "idPustakawan") Long idPustakawan, Model model) {
    	PustakawanModel pustakawan = pustakawanService.getPustakawanByIdPustakawan(idPustakawan);
        model.addAttribute("pustakawan", pustakawan);
        return "pustakawan-detail";
    }
    
    //mengubah data pustakawan
    //membuka form untuk mengubah data pustakawan
    @GetMapping(value = "/pustakawan/ubah/{idPustakawan}")
    public String showChangePustakawanForm(@PathVariable Long idPustakawan,
    										@ModelAttribute("changeHandler") ChangePustakawanHandler changeHandler, Model model) {
    	PustakawanModel pustakawan = pustakawanService.getPustakawanByIdPustakawan(idPustakawan);
    	model.addAttribute("pustakawan", pustakawan);
    	return "pustakawan-change";
    }
    
    //submit form untuk mengubah data pustakawan
    @PostMapping(value = "/pustakawan/ubah/{idPustakawan}")
    public String showChangePustakawanForm(@PathVariable String idPustakawan,
								    		@ModelAttribute PustakawanModel pustakawan,
								    		@ModelAttribute PerpustakaanModel perpustakaan,
								    		@ModelAttribute("changeHandler") ChangePustakawanHandler changeHandler,
								    		Model model) {
    	String nipPustakawan = pustakawanService.changePustakawanData(pustakawan, changeHandler);
    	model.addAttribute("pesan", "Pustakawan " + changeHandler.getNamaPustakawan()+ " berhasil diubah, Nip pustakawan: " + nipPustakawan);
    	return "message-info";
    }
    
    @GetMapping(value = "/pustakawan/delete/{idPustakawan}")
	public String deletePustakawan(@PathVariable("idPustakawan") Long idPustakawan, Model model) {
		PustakawanModel pustakawan = pustakawanService.getPustakawanByIdPustakawan(idPustakawan);
    	pustakawanService.deletePustakawan(pustakawan);
		model.addAttribute("pesan", "Data pustakawan berhasil dihapus");
		return "message-info";
	}
    
    @GetMapping(value = "/pustakawan/jadwal/tambah{nipPustakawan}")
    public String showAddJadwalForm(@ModelAttribute("addHandler") JadwalHandler addHandler, Model model) {
    	List<PerpustakaanModel> perpustakaanList = perpustakaanService.getPerpustakaanList();
    	model.addAttribute("perpustakaanList", perpustakaanList);
    	return "jadwal-add.html";
    }
    
    //melakukan submit form untuk menambahkan pustakawan
    @PostMapping(value = "/pustakawan/jadwal/tambah{nipPustakawan}")
    public String submitAddJadwalForm(@ModelAttribute("addHandler") JadwalHandler addHandler, Model model) {
    	//String idPustakawan = pustakawanService.addPustakawan(addHandler);
    	model.addAttribute(
    			"pesan",  "Jadwal berhasil ditambahkan!"
    	);
    	return "message-info";
    	
    }
    
 // Membuka halaman pencarian pasien berdasarkan Spesialisasi dan/atau perpustakaan penyakit
	/*
	 * @GetMapping(value = "/pasien/cari/spesialisasi-perpustakaan") public String
	 * showPustakawanInfoBySpesialisasiPerpustakaanForm(@ModelAttribute(
	 * "searchHandler") HandlingSpesialisasiPerpustakaanSearch searchHandler, Model
	 * model) { List<PerpustakaanModel> perpustakaanList =
	 * perpustakaanService.getPerpustakaanList(); List<SpesialisasiModel>
	 * spesialisasiList = spesialisasiService.getSpesialisasiList();
	 * 
	 * model.addAttribute("perpustakaanList", perpustakaanList);
	 * model.addAttribute("spesialisasiList", spesialisasiList);
	 * model.addAttribute("searchHandler", new
	 * HandlingSpesialisasiPerpustakaanSearch()); return
	 * "pasien-find-spesialisasi-perpustakaan"; }
	 * 
	 * // Submit form pencarian pustakawan berdasarkan Spesialisasi dan/atau
	 * perpustakaan penyakit
	 * 
	 * @PostMapping(value = "/pasien/cari/spesialisasi-perpustakaan") public String
	 * submitPustakawanInfoBySpesialisasiPerpustakaanForm(@ModelAttribute(
	 * "searchHandler") HandlingSpesialisasiPerpustakaanSearch searchHandler, Model
	 * model) { Long idPerpustakaan = searchHandler.getIdPerpustakaan(); Long
	 * idSpesialisasi = searchHandler.getIdSpesialisasi();
	 * 
	 * PerpustakaanModel perpustakaan =
	 * perpustakaanService.getPerpustakaanByIdPerpustakaan(idPerpustakaan);
	 * SpesialisasiModel spesialisasi =
	 * spesialisasiService.getSpesialisasiByIdSpesialisasi(idSpesialisasi);
	 * 
	 * if (idPerpustakaan.equals((long) 0) || idSpesialisasi.equals((long) 0)) { if
	 * (idPerpustakaan.equals((long) 0) && idSpesialisasi.equals((long) 0)) {
	 * model.addAttribute("searchSuccess", 0); } else { List<PustakawanModel>
	 * listBertugas = perpustakaan.getListBertugas();
	 * model.addAttribute("dataPencarian", listBertugas);
	 * model.addAttribute("searchSuccess", 1);
	 * 
	 * } else { List<PustakawanModel> listBertugas = spesialisasi.getListBertugas();
	 * 
	 * 
	 * if (listBertugas.size() == 0) { model.addAttribute("searchSuccess", 0); }
	 * else { System.out.println(listBertugas); model.addAttribute("dataPencarian",
	 * listBertugas); model.addAttribute("searchSuccess", 1); } } return
	 * "pasien-find-spesialisasi-perpustakaan-result"; }
	 */
}