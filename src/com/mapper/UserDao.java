package com.mapper;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pojo.AdminUser;

@Repository
public interface UserDao {

	AdminUser login(Map<String, String> map);

	AdminUser queryUser(AdminUser user);

	void insertUser(AdminUser user);

	void uptime(Map<String, Object> map);

	void edit(AdminUser user);

	AdminUser findPwd(int id);


}
