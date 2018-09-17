package cn.ncu.dao;

import cn.ncu.entity.User;

public interface UserDao {
	User selectById(Integer id);
}
