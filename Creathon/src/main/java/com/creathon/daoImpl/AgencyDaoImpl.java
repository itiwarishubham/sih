package com.creathon.daoImpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.creathon.bean.Agency;
import com.creathon.dao.AgencyDao;

@Transactional
@Repository
public class AgencyDaoImpl implements AgencyDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Agency findAgencyByEmail(String email) {
		Agency agency;
		try {
			agency = (Agency) sessionFactory.getCurrentSession().createQuery("from Agency where email =:email")
					.setString("email", email).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return agency;
	}

}