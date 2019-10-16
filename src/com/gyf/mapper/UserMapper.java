package com.gyf.mapper;

import com.gyf.model.User;
import com.gyf.vo.UserQueryVO;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    public void save(User user);
    public User findUserById(int id);
    public List<User> findUserByUserQueryVo(UserQueryVO vo);
    public List<User> findUserByUserMap(Map<String,Object> map);
    public List<User> findUserByIdResultMap(int userId);
    public int findUserCount(UserQueryVO userQueryVO);
    public List<User> findUserList(UserQueryVO vo);
    public List<User> findUserByIds(UserQueryVO vo);
    public List<User> findUserAndOrderInfo();
}
