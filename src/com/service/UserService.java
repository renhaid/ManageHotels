package com.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.UserDao;
import com.pojo.AdminUser;

@Service
public class UserService {
	@Resource
	private UserDao userdao;
	
	public AdminUser login(String username, String pwd) {
		Map<String,String> map=new HashMap<>();
		map.put("username", username);
		map.put("password", pwd);
		AdminUser user=userdao.login(map);
		return user;
	}

	public AdminUser query(AdminUser user) {
		AdminUser u=userdao.queryUser(user);
		return u;
	}

	public void insert(AdminUser user) {
		userdao.insertUser(user);
	}

	public void updateTime(int id, String time) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("id", id);
		map.put("last_time", time);
		userdao.uptime(map);
		
	}

	public void editor(AdminUser user) {
		userdao.edit(user);
	}

	public AdminUser find(int id) {
		AdminUser ad=userdao.findPwd(id);
		return ad;
	}

}
