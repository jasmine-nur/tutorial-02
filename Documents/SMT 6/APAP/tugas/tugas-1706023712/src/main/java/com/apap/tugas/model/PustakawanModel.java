package com.apap.tugas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "pustakawan")
public class PustakawanModel implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPustakawan;
	
	@NotNull
	@Size(max=13)
	@Column(name="nip", nullable = false)
	private String nip;
	
	@NotNull
	@Column(name = "nama", nullable = false)
	private String nama;
	
	@NotNull
	@Column(name = "jenisKelamin", nullable = false)
	private Integer jenisKelamin;
	
	@NotNull
	@Column(name = "tanggalLahir", nullable = false)
	private Date tanggalLahir;
	
	@NotNull
	@Column(name = "tempatLahir", nullable = false)
	private String tempatLahir;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "pustakawan_spesialisasi",
			joinColumns = @JoinColumn(name = "pustakawanId"),
			inverseJoinColumns = @JoinColumn(name = "spesialisasiId")
			)
	private List<SpesialisasiModel> listSpesialisasi;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "pustakawan_perpustakaan",
			joinColumns = @JoinColumn(name = "pustakawanId"),
			inverseJoinColumns = @JoinColumn(name = "perpustakaanId")
			)
	private List<PerpustakaanModel> listPerpustakaan;
	
	public Long getIdPustakawan() {
		return idPustakawan;
	}
	
	public void setIdPustakawan(Long idPustakawan) {
		this.idPustakawan = idPustakawan;
	}
	
	public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip; 
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(Integer jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }
    
    public List<SpesialisasiModel> getListSpesialisasi() {
        return listSpesialisasi;
    }

    public void setListSpesialisasi(List<SpesialisasiModel> listSpesialisasi) {
        this.listSpesialisasi = listSpesialisasi;
    }

    public void addSpesialisasi(SpesialisasiModel spesialisasi){
        listSpesialisasi.add(spesialisasi);
    }
    
    public List<PerpustakaanModel> getListPerpustakaan() {
        return listPerpustakaan;
    }

    public void setListPerpustakaan(List<PerpustakaanModel> listPerpustakaan) {
        this.listPerpustakaan = listPerpustakaan;
    }

    public void addPerpustakaan(PerpustakaanModel perpustakaan){
        listPerpustakaan.add(perpustakaan);
    }
    
    
    
    
}