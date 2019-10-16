package com.gyf.dao;

import com.gyf.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDaoImpl implements UserDao {
    private SqlSessionFactory ssf;

    public UserDaoImpl() {
    }

    public UserDaoImpl(SqlSessionFactory ssf) {
        this.ssf = ssf;
    }

    @Override
    public void save(User user) {
        SqlSession session = ssf.openSession();
        session.insert("insertUser",user);
        session.commit();
        session.close();
    }

    @Override
    public User findUserById(int id) {
        SqlSession session = ssf.openSession();
        User user = session.selectOne("findUserById", id);
        session.commit();
        session.close();
        return user;
    }
}
