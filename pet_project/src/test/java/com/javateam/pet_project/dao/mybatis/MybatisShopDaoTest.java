package com.javateam.pet_project.dao.mybatis;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.javateam.pet_project.dao.ShopDao;
import com.javateam.pet_project.entity.Shop;

@SpringBootTest
class MybatisShopDaoTest {
	
	@Autowired
	private ShopDao shopDao;

	@Test
	void test() {
		List<Shop> list = shopDao.getList();
		System.out.println(list);
	}

}
