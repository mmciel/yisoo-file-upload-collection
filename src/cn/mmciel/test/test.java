package cn.mmciel.test;

import cn.mmciel.utils.JdbcUtils;

public class test {
	public static void main(String[] args) {
		System.out.println("test");
		System.out.println(JdbcUtils.getConnection());
	}
}
