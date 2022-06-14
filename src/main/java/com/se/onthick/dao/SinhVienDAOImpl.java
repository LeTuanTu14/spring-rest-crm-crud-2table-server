package com.se.onthick.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.onthick.entity.LopHoc;
import com.se.onthick.entity.SinhVien;

@Repository
public class SinhVienDAOImpl implements SinhVienDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void addSinhVien(SinhVien sv, int id) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();
		LopHoc lop= session.get(LopHoc.class, id);
		if(sv.getId() == 0) {
			lop.addSinhVien(sv);
			session.saveOrUpdate(sv);
		}else {
			SinhVien s=lop.getSV(sv.getId());
			s.setHoTen(sv.getHoTen());
			s.setEmail(sv.getEmail());
			session.saveOrUpdate(s);
		}
		
	}

	@Override
	public List<SinhVien> getSVByLop(String malop) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();
		Query<SinhVien> query= session.createQuery("from sinhvien where malop="+malop,SinhVien.class);
		return query.getResultList();
	}

	@Override
	public SinhVien getSVById(int id) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();
		
		return session.get(SinhVien.class, id);
	}

	@Override
	public void deleteSV(int id) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();
		Query query= session.createQuery("delete from sinhvien where id="+id);
		query.executeUpdate();
	}

}
