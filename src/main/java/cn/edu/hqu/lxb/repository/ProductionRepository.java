package cn.edu.hqu.lxb.repository;



import java.util.List;

import cn.edu.hqu.lxb.domain.Production;
import cn.edu.hqu.lxb.domain.inquiry;

public interface ProductionRepository {
	public void save(Production production);
	public Production findByProductionId(String proid);
	public void savedetail(String proid);
	public inquiry findBysid(String sid);
	public Production findBigBySmall(String sid);
	public List<Production>findByUserName(String username);
	public void updatePro(String name,String proid,Production production);
}
