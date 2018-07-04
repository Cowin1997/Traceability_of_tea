package cn.edu.hqu.lxb.repository;

import cn.edu.hqu.lxb.domain.Factory;

public interface FactoryRepository {
	public void save(Factory factory);
	public Factory findByUserName(String username);
}
