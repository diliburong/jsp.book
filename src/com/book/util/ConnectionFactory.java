package com.book.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	
	
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
	
	private static final ConnectionFactory factory =new ConnectionFactory();
	private static Connection conn;
	
	static{   //静态代码块用于初始化类，可以为类的属性进行赋值
		Properties prop=new Properties(); //保存属性文件中的键值队
		
		try{
			InputStream in=ConnectionFactory.class.getClassLoader() //获取当前类的类加载器
					.getResourceAsStream("dbconfig.properties");
			prop.load(in);
			
			
		}
		catch(Exception e){
			System.out.println("配置文件读取错误");
		}
		
		driver=prop.getProperty("driver");
		dburl=prop.getProperty("dburl");
		user=prop.getProperty("user");
		password=prop.getProperty("password");
		
	}
	
	private ConnectionFactory(){
		
		
		
	}
	
	public static ConnectionFactory getInstance(){   //单例模式
		return factory;
	}
	
	
	public Connection makeConnection(){
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(dburl,user,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return conn;
	}
	
}