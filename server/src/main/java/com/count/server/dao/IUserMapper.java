package com.count.server.dao;


import org.apache.ibatis.annotations.Mapper;

import com.count.server.login.UserDto;
@Mapper
public interface IUserMapper {
    UserDto findByUsername(String username);
    void save(UserDto userDto);
}
