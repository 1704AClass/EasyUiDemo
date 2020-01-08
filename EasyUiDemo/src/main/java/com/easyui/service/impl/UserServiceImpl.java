package com.easyui.service.impl;

import java.util.List;
import java.util.Map;

import javax.accessibility.AccessibleRelation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyui.mapper.UserMapper;
import com.easyui.pojo.User;
import com.easyui.pojo.UserExample;
import com.easyui.pojo.UserExample.Criteria;
import com.easyui.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Page<User> getAll(Map<String, String> map,Integer page, Integer limit) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		if(map.get("name")!=null && !map.get("name").equals("")){
			criteria.andNameLike("%"+map.get("name")+"%");
		}
		if(map.get("tel")!=null && !map.get("tel").equals("")){
			criteria.andIphoneLike("%"+map.get("tel")+"%");
		}
		//分页
		PageHelper.startPage(page, limit);
		Page<User> userList = (Page<User>)userMapper.selectByExample(example);
		return userList;
	}

	@Override
	public void addUser(User user) {
		userMapper.insertSelective(user);
		
	}

	@Override
	public User findOne(Integer uid) {
		return userMapper.selectByPrimaryKey(uid);
	}

	@Override
	public void editUser(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public void deleteUser(String ids) {
		System.out.println(ids);
		try {
			String[] uids =  ids.split(",");
			for (String uid : uids) {
				//先删除子表
				userMapper.deleteUserANDROleByKey(Integer.valueOf(uid));
				//再删除主表
				userMapper.deleteByPrimaryKey(Integer.valueOf(uid));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
