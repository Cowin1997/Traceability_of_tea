package cn.edu.hqu.lxb.repository;

import cn.edu.hqu.lxb.domain.Retailer;

public interface RetailerRepository {
	public void save (Retailer retailer);
	public Retailer findByUsername(String username);

}
