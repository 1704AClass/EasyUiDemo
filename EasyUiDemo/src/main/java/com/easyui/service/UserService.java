package com.easyui.service;

import java.util.List;
import java.util.Map;

import com.easyui.pojo.User;
import com.github.pagehelper.Page;

public interface UserService {
	public Page<User> getAll(Map<String, String> map,Integer page,Integer limit);
	public void addUser(User user);
	public User findOne(Integer uid);
	public void editUser(User user);
	public void deleteUser(String ids);
}
