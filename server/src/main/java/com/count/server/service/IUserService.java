package com.count.server.service;


import com.count.server.login.UserDto;;
public interface IUserService {
    UserDto login(UserDto userDto);
    void register(UserDto userDto);
}
