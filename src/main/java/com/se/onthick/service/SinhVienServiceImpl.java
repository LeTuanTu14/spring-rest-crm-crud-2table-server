package com.se.onthick.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.onthick.dao.SinhVienDAO;
import com.se.onthick.entity.SinhVien;

@Service
public class SinhVienServiceImpl implements SinhVienService{
	
	@Autowired
	private SinhVienDAO svDAO;

	@Override
	@Transactional
	public void addSinhVien(SinhVien sv, int id) {
		// TODO Auto-generated method stub
		svDAO.addSinhVien(sv,id);
	}

	@Override
	@Transactional
	public List<SinhVien> getSVByLop(String malop) {
		// TODO Auto-generated method stub
		return svDAO.getSVByLop(malop);
	}

	@Override
	@Transactional
	public SinhVien getSVById(int id) {
		// TODO Auto-generated method stub
		return svDAO.getSVById(id);
	}

	@Override
	@Transactional
	public void deleteSV(int id) {
		// TODO Auto-generated method stub
		svDAO.deleteSV(id);
	}

}
