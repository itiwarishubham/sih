package com.creathon.dao;

import com.creathon.bean.Agency;

public interface AgencyDao {

	public Agency findAgencyByEmail(String email);
	public Boolean saveandupdate(Agency agency); 
}
