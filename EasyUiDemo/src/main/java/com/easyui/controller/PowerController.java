package com.easyui.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.easyui.pojo.Power;
import com.easyui.pojo.User;
import com.easyui.service.PowerService;

@Controller
@RequestMapping("/powerController")
public class PowerController {

	@Autowired
	private PowerService powerService;

	@RequestMapping(value="/getPowerByUid")//produces使用此属性
	@ResponseBody
	public Object getPowerByUid(HttpServletRequest request){
		//可能有  新对象把原有的对象覆盖？逻辑问题（bug）打断点
		JSONArray jsonArray = new JSONArray();//[]
		JSONObject jsonObject = new JSONObject();//{}-->[{}]
		jsonObject.put("id", 1000);
		jsonObject.put("text", "我的菜单");
		jsonObject.put("iconCls", "icon-save");
		JSONArray jsonArray2 = new JSONArray();
		jsonObject.put("children", jsonArray2);
		//手动拼接json
		User user = (User)request.getSession().getAttribute("user");
		if(user!=null){
			
			List<Power> list = powerService.getPowerByUid(user.getUid());
			for (Power power : list) {
				JSONObject jObject = new JSONObject();
				jObject.put("id", power.getPid());
				jObject.put("text", power.getPname());
				jObject.put("code", power.getCode());
				jsonArray2.add(jObject);
			}
		}else{
			System.out.println();
		}
		jsonArray.add(jsonObject);
		return jsonArray.toString();
	}
}
