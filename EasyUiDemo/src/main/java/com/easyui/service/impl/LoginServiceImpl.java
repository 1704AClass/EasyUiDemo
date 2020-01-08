package com.easyui.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.easyui.mapper.UserMapper;
import com.easyui.pojo.User;
import com.easyui.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserMapper userMapper;
	/*
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private TeacherMapper teacherMapper;
	
	@Autowired
	private StudentMapper studentMapper;*/

	@Override
	public User login(String nameOrIphone) {
		return userMapper.loginName(nameOrIphone);
	}

	/*@Override
	public void Demo() {*/
		/*List<Role> list = roleMapper.getRoleAllAndPower(1);
		for (Role role : list) {
			System.out.println(role.getRname());
			for (Power powers : role.getPowers()) {
				System.out.println(powers.getPname());
			}
		}*/
		/*List<Teacher> list = teacherMapper.selectAll();
		for (Teacher teacher : list) {
			System.out.println(teacher.getTname());
			for (Student student : teacher.getStudents()) {
				System.out.println(student.getSname());
			}
		}*/
		
		/*List<Student> list = studentMapper.selectAll();
		for (Student student : list) {
			System.out.println(student.getSname()+":"+student.getTeacher().getTname());
		}*/
		
		
	/* } */

}
