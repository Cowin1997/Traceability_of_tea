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
import cn.edu.hqu.lxb.domain.inquiry;
import cn.edu.hqu.lxb.repository.ProductionRepository;
import cn.edu.hqu.lxb.toolutils.GetDate;
import cn.edu.hqu.lxb.toolutils.ProIdTool;
import cn.edu.hqu.lxb.toolutils.Sell;


@Repository
public class Productionimpl implements ProductionRepository {
	
	private static final String SQL_INSERT_PRO = "insert into production (username,proid,auth,facname,facaddr,proname,status,date) values(?,?,?,?,?,?,?,?)";
	private static final String SQL_FIND_PRO = "select id,username,proid,auth,facname,facaddr,proname,status,date from production where proid=?";
	private static final String SQL_INSERT_PRODETAIL = "insert into productions (proid,detaiid,status,date) values(?,?,?,?)";
	private static final String SQL_FIND_PROS = "select proid,detaiid from productions where detaiid=?";
	private static final String SQL_FIND_PRO2 = "select id,username,proid,auth,facname,facaddr,proname,status,date from production where username=?";
	
	private static final String SQL_UPDATE_PROINFO="update production SET facname=?,facaddr=?,auth=?,proname=? where proid=?  ";
	
	private static final String SQL_UPDATE_PROSINFO="update productions SET date=? where proid=? ";
	
	
	
	
	
	
	@Autowired
	private JdbcOperations jdbcOperations;
	
	

	@Override
	public void save(Production production) {
		jdbcOperations.update(SQL_INSERT_PRO,production.getUsername(),production.getProid(),production.getAuthord(),production.getFactoryname(),
				production.getFactoryaddr(),production.getProname(),production.getStatus(),production.getDate()
			);
		
	}

	@Override
	public Production findByProductionId(String proid) {
		List<Production> list = new ArrayList<>();
		list = jdbcOperations.query(SQL_FIND_PRO, new RowMapper<Production>() {

			@Override
			public Production mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Production production = new Production();
				production.setId(rs.getLong("id"));
				production.setUsername(rs.getString("username"));
				production.setProid(rs.getString("proid"));
				production.setAuthord(rs.getString("auth"));
				production.setFactoryname(rs.getString("facname"));
				production.setFactoryaddr(rs.getString("facaddr"));
				production.setProname(rs.getString("proname"));
				production.setStatus(rs.getString("status"));
				production.setDate(rs.getString("date"));
				return production;
			}

		}, proid);
		
		if (list.size() >= 1) {
			return list.get(0);
		} else
			return null;
	}

	@Override
	public void savedetail(String proid) {
		for(int i=1;i<=10;i++) {
			jdbcOperations.update(SQL_INSERT_PRODETAIL,proid,ProIdTool.getRandomID(),Sell.NOTSHELL,GetDate.getDate());
		}
			
	}
	
	
	
	
	
	
	
	
	
	public inquiry findBysid(String sid) {
		List<inquiry> list = new ArrayList<>();
		
		list=jdbcOperations.query(SQL_FIND_PROS,new RowMapper<inquiry>() {

			@Override
			public inquiry mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				inquiry inquirys = new inquiry();
				inquirys.setInquiryid(rs.getString("detaiid"));
				inquirys.setProid(rs.getString("proid"));
				return inquirys;
			}

		},sid);
		if (list.size() >= 1) {
			System.out.println("inquiry is no null!!!");
			return list.get(0);
		} else
			System.out.println("inquiry is  null!!!");
			return null;
		
	}
	public Production findBigBySmall(String sid) {
		inquiry inquiry=findBysid(sid);
		if(inquiry!=null) {
			System.out.println("inquiry is no null!");
			Production production = findByProductionId(inquiry.getProid());
			if(production!=null) {
				System.out.println("Production is no null");
				return production;
			}
		}
		System.out.println("production is null");
		return null;
		
	}

	@Override
	public List<Production> findByUserName(String username) {
		List<Production> list = new ArrayList<>();
		list = jdbcOperations.query(SQL_FIND_PRO2, new RowMapper<Production>() {

			@Override
			public Production mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Production production = new Production();
				production.setId(rs.getLong("id"));
				production.setUsername(rs.getString("username"));
				production.setProid(rs.getString("proid"));
				production.setAuthord(rs.getString("auth"));
				production.setFactoryname(rs.getString("facname"));
				production.setFactoryaddr(rs.getString("facaddr"));
				production.setProname(rs.getString("proname"));
				production.setStatus(rs.getString("status"));
				production.setDate(rs.getString("date"));
				return production;
			}

		},username);
		if(list.size()>=1) {
		System.out.println(list.size());
		return list;
		}
		else
			System.out.println("产家的产品为空！");
			return null;
	}

	@Override
	public void updatePro(String name, String proid,Production production) {
		jdbcOperations.update(SQL_UPDATE_PROINFO,production.getFactoryname(),production.getFactoryaddr(),production.getAuthord(),production.getProname() ,proid);
		jdbcOperations.update(SQL_UPDATE_PROSINFO,GetDate.getDate(),proid);
	}
	
	
	}


