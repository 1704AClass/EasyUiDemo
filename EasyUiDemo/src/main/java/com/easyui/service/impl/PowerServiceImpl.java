package com.easyui.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyui.mapper.PowerMapper;
import com.easyui.pojo.Power;
import com.easyui.service.PowerService;

@Service
public class PowerServiceImpl implements PowerService {
	
	@Autowired
	private PowerMapper powerMapper;

	@Override
	public List<Power> getPowerByUid(Integer uid) {
		
		return powerMapper.getPowerByUid(uid);
	}

}
