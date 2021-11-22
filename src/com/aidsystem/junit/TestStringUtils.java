package com.aidsystem.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.aidsystem.util.StringUtils;

public class TestStringUtils extends StringUtils {

	StringUtils stringUtils = new StringUtils();
	@Test
	public void test() {
		String s = "你好     我 是\n你  叔       叔";
		String string = stringUtils.removeUnimportantChar(s);
		System.out.println(s);
		System.out.println("-------------");
		System.out.println(string);
		
	}
	
	@Test
	public void test1() {
		String s = " 500  箱  \ndasd ";
		int num = StringUtils.getNumberFromString(s);
		System.out.println(num);
	}
	
	@Test
	public void test2() {
		String s = " 500  箱  \ndasd ";
		String num = StringUtils.getOnlyStringFromString(s);
		System.out.println(num);
	}

}
