package com.kam.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.kam.dao.UserDao;
import com.kam.entity.User;
import com.kam.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userdao;
	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return userdao.getUserList();
	}

}
