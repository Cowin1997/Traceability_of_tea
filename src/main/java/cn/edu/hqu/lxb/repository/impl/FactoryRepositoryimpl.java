package cn.edu.hqu.lxb.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.edu.hqu.lxb.domain.Factory;
import cn.edu.hqu.lxb.domain.Production;
import cn.edu.hqu.lxb.repository.FactoryRepository;

@Repository
public class FactoryRepositoryimpl implements FactoryRepository{
	private static final String SQL_INSERT_FAC_LOGIN = "insert into factorylogin (username,password,email,facname,facaddr) values(?,?,?,?,?)";
	private static final String SQL_FIND_FAC = "select id,username,password,email,facname,facaddr from factorylogin where username=?";

	
	@Autowired
	private JdbcOperations jdbcOperations;
	
	

	@Override
	public void save(Factory factory) {
		jdbcOperations.update(SQL_INSERT_FAC_LOGIN, factory.getUserName(), factory.getPassword(), factory.getEmail(),
				factory.getFactoryname(),factory.getFactoryaddr());
		
	}

	@Override
	public Factory findByUserName(String username) {
		List<Factory> list = new ArrayList<Factory>();
		list = jdbcOperations.query(SQL_FIND_FAC, new RowMapper<Factory>() {

			@Override
			public Factory mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Factory factory = new Factory();
				factory.setId(rs.getLong("id"));
				factory.setUserName(rs.getString("username"));
				factory.setPassword(rs.getString("password"));
				factory.setEmail(rs.getString("email"));
				factory.setFactoryname(rs.getString("facname"));
				factory.setFactoryaddr(rs.getString("facaddr"));
				return factory;
			}

		}, username);
		
		if (list.size() >= 1) {
			return list.get(0);
		} else
			return null;
	}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


