package com.aidsystem.junit.service;

import org.junit.Test;

import com.aidsystem.service.LoginService;

public class TestLoginService {
	@Test
	public void test() {
		System.out.println(LoginService.login("root", "1234"));
	}

}
