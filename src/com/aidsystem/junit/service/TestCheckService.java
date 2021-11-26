package com.aidsystem.junit.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.aidsystem.bean.AidSupply;
import com.aidsystem.bean.DemandSupply;
import com.aidsystem.service.CheckService;
public class TestCheckService {
	

	@Test //ac
	public void testCheckAidSupllyService() {
		AidSupply aid = new AidSupply(1, "test1", 500, "郑州大学图书馆", null, true, null, 1009, true, false);
		CheckService.checkAidSupplyService(1, false, aid);
	}

	@Test //ac
	public void testCheckDemSupllyService() {
		DemandSupply dem = new DemandSupply(10017, "test1", 500, null,"", 1003, 1009, true, true);
//		CheckService.checkDemSupplyService(10017, true, dem);
	}

}
