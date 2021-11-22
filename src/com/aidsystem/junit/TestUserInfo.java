package com.aidsystem.junit;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.aidsystem.log.UserInfo;

public class TestUserInfo {
	UserInfo usr = new UserInfo();
	@Test
	public void testSaveOrgInfo() throws IOException {
		usr.saveOrgInfo(1008);
	}

	@Test
	public void testSaveDonInfoInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOrgInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveDonInfo() {
		fail("Not yet implemented");
	}

}
