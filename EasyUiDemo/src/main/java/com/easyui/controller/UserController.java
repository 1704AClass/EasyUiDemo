package com.easyui.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyui.pojo.User;
import com.easyui.pojo.entity.PageResult;
import com.easyui.service.UserService;
import com.github.pagehelper.Page;

@Controller
@RequestMapping("/userController")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/addUser")
	//鍓嶇浼氱粰鎴戜紶杈撹繃鏉ヤ袱绉嶆牸寮�  涓�绉峧son瀵硅薄  application/json  涓�绉峟orm琛ㄥ崟Content-Type: application/x-www-form-urlencoded 
	public void addUser(User user) {
		userService.addUser(user);
	}
	
	@RequestMapping("/editUser.do")
	public void editUser(User user){
		
		userService.editUser(user);
	}
	
	
	@RequestMapping("/getUserAll")
	@ResponseBody
	public PageResult getUserAll(String name,String iphone,@RequestParam(value="page",defaultValue="1")Integer page,@RequestParam(value="rows",defaultValue="10")Integer rows){
		System.out.println(name+":"+iphone);
		Map<String, String> map = new HashMap<>();
		map.put("name", name);
		map.put("tel", iphone);
		Page<User> page2 = userService.getAll(map,page, rows);
		return new PageResult(page2.getTotal(), page2.getResult());
	}
	
	@RequestMapping("/findOne")
	@ResponseBody
	public User findOne(Integer uid){
		return userService.findOne(uid);
	}
	
	@RequestMapping("/deleteUser")
	@ResponseBody
	public String deleteUser(String ids){
		try {
			userService.deleteUser(ids);
			return "ok";
		} catch (Exception e) {
			return "no";
		}
		
	}
	
	/*@RequestMapping("/getUserAll")
	@ResponseBody
	public Object getUserAll(@RequestParam(value="page",defaultValue="1")Integer page,@RequestParam(value="rows",defaultValue="10")Integer rows){
		JSONObject jsonObject = new JSONObject();
		//page: 1
		//rows: 22
		Page<User> page2 = userService.getAll(page, rows);
		JSONArray jsonArray = new JSONArray();
		for (User user : page2) {
			JSONObject jsonObject1 =  new JSONObject();
			jsonObject1.put("uids", user.getUid());
			jsonObject1.put("names", user.getName());
			jsonObject1.put("pwds", user.getPwd());
			jsonObject1.put("iphones", user.getIphone());
			
			jsonArray.add(jsonObject1);
		}
		jsonObject.put("rows",jsonArray);
		jsonObject.put("rows",page2.getResult());
		jsonObject.put("total", page2.getTotal());
		return jsonObject;
	}*/
}
