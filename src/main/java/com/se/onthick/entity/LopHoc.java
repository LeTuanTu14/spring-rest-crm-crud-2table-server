package com.se.onthick.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "lop")
public class LopHoc {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "tenlop")
	private String tenLop;
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="malop")
	private List<SinhVien> dsSinhVien;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	
	public List<SinhVien> getDsSinhVien() {
		return dsSinhVien;
	}
	public void setDsSinhVien(List<SinhVien> dsSinhVien) {
		this.dsSinhVien = dsSinhVien;
	}
	public LopHoc(int id, String tenLop) {
		super();
		this.id = id;
		this.tenLop = tenLop;
	}
	public LopHoc() {
		super();
	}
	
	public SinhVien getSV(int id) {
		for (int i=0;i<dsSinhVien.size();i++) {
			if(dsSinhVien.get(i).getId()==id)
				return dsSinhVien.get(i);
			
		}
		return null;
	}
	
	public void addSinhVien(SinhVien sv) {
		if(dsSinhVien == null) {
			dsSinhVien= new ArrayList<SinhVien>();
		}
		dsSinhVien.add(sv);
	}

}
