package com.zeroten.javales001.proxy;

public final class User2Dao {

    public boolean save(User user) {
        System.out.println("保存用户2：" + user.getName() + "," + user.getAge());
        return true;
    }

}
