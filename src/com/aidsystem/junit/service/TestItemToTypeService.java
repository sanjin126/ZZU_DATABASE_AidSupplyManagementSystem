package com.aidsystem.junit.service;

import org.junit.Test;

import com.aidsystem.service.ItemToTypeService;

public class TestItemToTypeService {
	
	@Test //ac
	public void test() {
		ItemToTypeService.saveType("test4", " 111箱");
	}

}
