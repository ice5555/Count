package com.count.server.service_mpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.count.server.dao.IUserMapper;
import com.count.server.login.UserDto;
import com.count.server.service.IUserService;

@Service
@Transactional
public class UserService implements IUserService{
    @Autowired
    private IUserMapper mapper;

    @Override
    public UserDto login(UserDto userdto) {

        UserDto userDb = mapper.findByUsername(userdto.getUsername());
        if(userDb != null){

            if(userDb.getPassword().equals(userdto.getPassword())){
                return userDb;
            }
            throw  new RuntimeException("密码输入错误");
        }else{
            throw  new RuntimeException("用户名输入错误");
        }
    }

    @Override
    public void regester(UserDto userDto) {

        if(mapper.findByUsername(userDto.getUsername())==null) {
            mapper.save(userDto);
        }else{
            throw  new RuntimeException("用户名已存在");
        }


    }



}
