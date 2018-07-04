package cn.edu.hqu.lxb.repository.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import cn.edu.hqu.lxb.domain.Retailer;
import cn.edu.hqu.lxb.repository.RetailerRepository;


@Repository
public class RetailerRepositoryImpl implements RetailerRepository{

	
	private static final String SQL_INSERT_RETAILER_LOGIN = "insert into retailerlogin (username,password,email,retailername,retaileraddr) values(?,?,?,?,?)";
	private static final String SQL_FIND_RETAILER = "select id,username,password,email,retailername,retaileraddr from retailerlogin where username=?";
	
	
	
	@Autowired
	private JdbcOperations jdbcOperations;
	
	
	
	
	@Override
	public void save(Retailer retailer) {
		jdbcOperations.update(SQL_INSERT_RETAILER_LOGIN, retailer.getUserName(), retailer.getPassword(),retailer.getEmail(),
				retailer.getRetailername(),retailer.getRetaileraddr());
		
	}

	@Override
	public Retailer findByUsername(String username) {
		
		List <Retailer>list = new ArrayList<Retailer>();
		list = jdbcOperations.query(SQL_FIND_RETAILER, new RowMapper<Retailer>() {
			Retailer retailer = new Retailer();
			@Override
			public Retailer mapRow(ResultSet rs, int rowNum) throws SQLException {
			retailer.setId(rs.getLong("id"));
				retailer.setId(rs.getLong("id"));
				retailer.setUserName(rs.getString("username"));
				retailer.setPassword(rs.getString("password"));
				retailer.setEmail(rs.getString("email"));
				retailer.setRetailername(rs.getString("retailername"));
				retailer.setRetaileraddr(rs.getString("retaileraddr"));
				return retailer;
			}
			
		},username);
		if(list.size()>=1){
			System.out.println("零售商的信息已找到！"+"找到"+list.size()+"条信息");
			return list.get(0);
		}
		
		else 
			System.out.println("零售商的信息未找到！"+"找到"+list.size()+"条信息");
			return null;
	}

}
