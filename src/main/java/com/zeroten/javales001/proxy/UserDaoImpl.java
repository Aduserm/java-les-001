package com.zeroten.javales001.proxy;

import java.util.List;

/**
 * 数据库读写操作，DAO 层
 */
public class UserDaoImpl implements UserDao, UserCache {
    @Override
    public boolean save(User user) {
        System.out.println("保存用户：" + user.getName() + "," + user.getAge());
        return true;
    }

    @Override
    public List query() {
        return null;
    }

    @Override
    public boolean delete() {
        System.out.println("执行删除");
        return false;
    }

    @Override
    public User getByName(String name) {
        User user = getCacheByName(name);
        if (user == null) {
            user = new User("模拟", 1);
        }
        return user;
    }

    @Override
    public User getCacheByName(String name) {
        return new User(name, 1);
    }
}
