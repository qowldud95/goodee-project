package com.javateam.pet_project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.javateam.pet_project.entity.Shop;
import com.javateam.pet_project.entity.Walkingroute;

@Mapper
public interface WalkingrouteDao {
	@Select("select * from walkingroute")
	List<Walkingroute> getList();
	
	@Insert("insert into Walkingroute( routeNumber, routeName, routeDistance, routeStart, routeEnd, routeDescription, writer, writeDate, routeImage) values ( #{routeNumber}, #{routeName}, #{routeDistance}, #{routeStart}, #{routeEnd}, #{routeDescription}, #{writer}, #{writeDate}, #{routeImage})")
	boolean routeInsert(Walkingroute walkingroute);
	
	@Select("select * from walkingroute where routeNumber = #{routeNumber}")
	Walkingroute getListByRouteNumber(int routeNumber);
	
	@Update("update walkingroute set routeName=#{routeName}, routeDistance=#{routeDistance}, routeStart=#{routeStart}, routeEnd=#{routeEnd}, routeDescription=#{routeDescription}, writeDate=#{writeDate}, routeImage=#{routeImage} where routeNumber=#{routeNumber}")
	boolean routeUpdate(Walkingroute walkingroute);
	
	@Delete("delete from walkingroute where routeNumber=#{routeNumber}")
	boolean petWalkingDelete(int routeNumber);
	
	
}
