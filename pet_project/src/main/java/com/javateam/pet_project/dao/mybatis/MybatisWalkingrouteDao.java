package com.javateam.pet_project.dao.mybatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.javateam.pet_project.dao.WalkingrouteDao;
import com.javateam.pet_project.entity.Shop;
import com.javateam.pet_project.entity.Walkingroute;

@Repository
public class MybatisWalkingrouteDao implements WalkingrouteDao{
	@Override
	public List<Walkingroute> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean routeInsert(Walkingroute walkingroute) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Walkingroute getListByRouteNumber(int routeNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean routeUpdate(Walkingroute walkingroute) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean petWalkingDelete(int routeNumber) {
		// TODO Auto-generated method stub
		return false;
	}


}
