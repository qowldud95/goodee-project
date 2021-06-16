package com.javateam.pet_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javateam.pet_project.dao.WalkingrouteDao;
import com.javateam.pet_project.entity.Walkingroute;

@Service
public class RouteServiceImpl implements RouteService{

	@Autowired
	private WalkingrouteDao walkingrouteDao;
	
	@Override
	public List<Walkingroute> getList() {
		List<Walkingroute> list = walkingrouteDao.getList();
		return list;
	}

	@Override
	public boolean routeInsert(Walkingroute walkingroute) {
		return walkingrouteDao.routeInsert(walkingroute);
	}

	@Override
	public Walkingroute getListByRouteNumber(int routeNumber) {
		Walkingroute route = walkingrouteDao.getListByRouteNumber(routeNumber);
		return route;
	}

	@Override
	public boolean routeUpdate(Walkingroute walkingroute) {
		return walkingrouteDao.routeUpdate(walkingroute);
	}

	@Override
	public boolean petWalkingDelete(int routeNumber) {
		return walkingrouteDao.petWalkingDelete(routeNumber);
	}          

}
