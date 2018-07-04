package cn.edu.hqu.lxb.repository;

import java.util.List;

import cn.edu.hqu.lxb.domain.Production;
import cn.edu.hqu.lxb.domain.RetailerProd;

public interface RetailerProRepository {
	public void update(String username,String id);
	public void save(RetailerProd retailerprod);
	public RetailerProd findByDetailid(String detailid);
	public RetailerProd findByProid(String proid);
	public List<RetailerProd> findByUsername(String username);
	public void ProdInByBig(String proid,String username);
	public void ProdInBySmall(String detailid,String username);
	public List<Production> findByProduction(Production production);

}
