package com.javateam.pet_project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javateam.pet_project.entity.Walkingroute;

@Service
public interface RouteService {
	List<Walkingroute> getList();
	
	boolean routeInsert(Walkingroute walkingroute);
	
	Walkingroute getListByRouteNumber(int routeNumber);
	
	boolean routeUpdate(Walkingroute walkingroute);
	
	boolean petWalkingDelete(int routeNumber);
}
