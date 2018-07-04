package cn.edu.hqu.lxb.service;



import java.util.List;

import org.springframework.stereotype.Service;

import cn.edu.hqu.lxb.domain.Production;
import cn.edu.hqu.lxb.domain.RetailerProd;

@Service
public interface RetailerProService {
	public void save(RetailerProd retailerprod);
	public List<RetailerProd> findProductByUsername(String username);
	public void ProdInByBig(String proid,String name);
	public void ProdInBySmall(String detailid,String name);
	public void update(String username,String id);
	public RetailerProd findByDetailid(String detailid);
}
