package com.aidsystem.junit.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.aidsystem.service.RegisterService;

public class TestRegisterService {

	@Test
	public void testRegisterUser() {
		int volId = 1001;
		String volName = "孟孟";
		String usrName = "mengmeng";
		String usrPwd = "123";
		try {
			System.out.println(RegisterService.registerUser(volId, volName, usrName, usrPwd));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
