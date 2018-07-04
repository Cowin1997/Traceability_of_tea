package cn.edu.hqu.lxb.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.edu.hqu.lxb.domain.Production;
import cn.edu.hqu.lxb.domain.RetailerProd;
import cn.edu.hqu.lxb.repository.ProductionRepository;
import cn.edu.hqu.lxb.repository.RetailerProRepository;
import cn.edu.hqu.lxb.toolutils.GetDate;
import cn.edu.hqu.lxb.toolutils.Sell;

@Repository
public class RetailerProdImpl implements RetailerProRepository{
	
	private static final String RETAILERPRO_INSERT ="insert into retailerprod (username,proid,detailid,proname,proaddr,status,datein,datesell) "
			+ "values (?,?,?,?,?,?,?,?)";
	private static final String RETAILERPRO_FIND ="select id,username,proid,detailid,proname,proaddr,status,datein,datesell from retailerprod where username =?";
	private static final String UPDATE_PROD="update production SET status=? where proid=? ";
	private static final String FIND_ALL_BYBIG="select proid,detaiid,status,date from productions where proid=?";
	private static final String UPDATE_RETAILERPTO="update retailerprod SET status=?,datesell=? where detailid=? ";
	private static final String RETAILERPRO_FINDBYDETAILID ="select id,username,proid,detailid,proname,proaddr,status,datein,datesell from retailerprod where detailid =?";
	private static final String UPDATE_PRODS="update productions SET status=? where proid=? ";
	@Autowired
	private JdbcOperations jdbcOperations;
	@Autowired
	private ProductionRepository ProductionRepository;
	
	
	@Override
	public void save(RetailerProd retailerprod) {
		jdbcOperations.update(RETAILERPRO_INSERT,retailerprod.getUserName(),retailerprod.getProid(),retailerprod.getDetailid(),retailerprod.getProname(),retailerprod.getProaddr(),retailerprod.getStatus(),retailerprod.getDatein(),retailerprod.getDatesell());
		System.out.println("零售商的产品已经保存");
		
	}

	@Override
	public RetailerProd findByDetailid(String detailid) {
		List<RetailerProd>list=new ArrayList<>();
		list=jdbcOperations.query(RETAILERPRO_FINDBYDETAILID, new RowMapper<RetailerProd>() {

			@Override
			public RetailerProd mapRow(ResultSet rs, int rowNum) throws SQLException {
				RetailerProd retailerProd = new RetailerProd();
				retailerProd.setId(rs.getLong("id"));
				retailerProd.setUserName(rs.getString("username"));
				retailerProd.setProid(rs.getString("proid"));
				retailerProd.setDetailid(rs.getString("detailid"));
				retailerProd.setProname(rs.getString("proname"));
				retailerProd.setProaddr(rs.getString("proaddr"));
				retailerProd.setStatus(rs.getString("status"));
				retailerProd.setDatein(rs.getString("datein"));
				retailerProd.setDatesell(rs.getString("datesell"));
				return retailerProd;
			}
			
		},detailid);
		if(list.size()>0) return list.get(0);
		else return null;
	}

	@Override
	public RetailerProd findByProid(String proid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RetailerProd> findByUsername(String username) {
		List<RetailerProd>list=new ArrayList<>();
		list=jdbcOperations.query(RETAILERPRO_FIND, new RowMapper<RetailerProd>() {

			@Override
			public RetailerProd mapRow(ResultSet rs, int rowNum) throws SQLException {
				RetailerProd retailerProd = new RetailerProd();
				retailerProd.setId(rs.getLong("id"));
				retailerProd.setUserName(rs.getString("username"));
				retailerProd.setProid(rs.getString("proid"));
				retailerProd.setDetailid(rs.getString("detailid"));
				retailerProd.setProname(rs.getString("proname"));
				retailerProd.setProaddr(rs.getString("proaddr"));
				retailerProd.setStatus(rs.getString("status"));
				retailerProd.setDatein(rs.getString("datein"));
				retailerProd.setDatesell(rs.getString("datesell"));
				return retailerProd;
			}
			
		},username);
		if(list.size()>0) return list;
		else 
			System.out.println("查询的零售商的仓库列表为空！");
		return null;
			
		
	}

	@Override
	public void ProdInByBig(String proid,String username) {
		List<String>list=new ArrayList<>();
	 if(ProductionRepository.findByProductionId(proid)!=null) {
		Production production=ProductionRepository.findByProductionId(proid);
		list=jdbcOperations.query(FIND_ALL_BYBIG, new RowMapper<String>() {

			@Override
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				return rs.getString("detaiid");
			}
			
		},proid);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.size());
			jdbcOperations.update(UPDATE_PRODS, Sell.SHELL,proid);
			jdbcOperations.update(UPDATE_PROD, Sell.SHELL,proid);
		jdbcOperations.update(RETAILERPRO_INSERT,username,proid,list.get(i),production.getProname(),production.getFactoryaddr(),Sell.NOTSHELL,GetDate.getDate(),GetDate.getEmptyDate());
		}
	 }  
	 else {
		 
		 
		 System.out.println("大包不存在！");
	 }
	
		
	}



	@Override
	public List<Production> findByProduction(Production production) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ProdInBySmall(String detailid, String username) {
		 if(ProductionRepository.findBysid(detailid)!=null) {
			Production production=ProductionRepository.findBigBySmall(detailid);
			jdbcOperations.update(RETAILERPRO_INSERT,username,production.getProid(),detailid,production.getProname(),production.getFactoryaddr(),Sell.NOTSHELL,GetDate.getDate(),GetDate.getEmptyDate());
	}
		 else	 System.out.println("小包不存在");
		 
	}

	@Override
	public void update(String username, String id) {
		jdbcOperations.update(UPDATE_RETAILERPTO, Sell.SHELL,GetDate.getDate(),id);
		
	}

	

}
