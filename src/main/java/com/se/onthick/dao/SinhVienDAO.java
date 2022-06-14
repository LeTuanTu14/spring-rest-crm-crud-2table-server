package com.se.onthick.dao;

import java.util.List;

import com.se.onthick.entity.SinhVien;

public interface SinhVienDAO {
	
	public void addSinhVien(SinhVien sv, int id);
	public List<SinhVien> getSVByLop(String malop);
	public SinhVien getSVById(int id);
	public void deleteSV(int id);
	

}
