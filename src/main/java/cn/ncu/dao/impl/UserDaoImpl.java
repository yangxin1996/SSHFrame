package cn.ncu.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.ncu.dao.UserDao;
import cn.ncu.entity.User;

@Repository("UserDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public User selectById(Integer id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(User.class, id);
	}

}
