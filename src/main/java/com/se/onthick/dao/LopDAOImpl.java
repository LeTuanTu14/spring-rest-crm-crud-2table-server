package com.se.onthick.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.onthick.entity.LopHoc;

@Repository
public class LopDAOImpl implements LopDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<LopHoc> getLop() {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();
		Query<LopHoc> query=session.createQuery("from lop order by tenlop",LopHoc.class);
		List<LopHoc> l=query.getResultList();
		return l;
	}

}
