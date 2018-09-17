package cn.ncu.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ncu.dao.UserDao;
import cn.ncu.entity.User;
import cn.ncu.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	
	@Override
	public User Login(User user) {
		// TODO Auto-generated method stub
		User temp = userDao.selectById(user.getId());
		if(temp!=null){
			if(user.getPassword().equals(temp.getPassword())){
				return temp;
			}
		}
		return user;
	}

}
