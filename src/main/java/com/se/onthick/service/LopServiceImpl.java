package com.se.onthick.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.se.onthick.dao.LopDAO;
import com.se.onthick.entity.LopHoc;

@Service
public class LopServiceImpl implements LopService{
	
	@Autowired
	private LopDAO lopDAO;
	

	@Override
	@Transactional
	public List<LopHoc> getLop() {
		// TODO Auto-generated method stub
		return lopDAO.getLop();
	}

}
