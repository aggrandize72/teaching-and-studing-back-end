package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.mapper.AdministratorMapper;
import org.example.pojo.Administrator;
import org.example.pojo.User;
import org.example.service.AdministratorService;
import org.example.utils.Result;
import org.example.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl extends ServiceImpl<AdministratorMapper, Administrator> implements AdministratorService {
    @Autowired
    AdministratorMapper administratorMapper;

    @Override
    public Result login(User user){
        Administrator loginAdministrator = administratorMapper.selectById(user.getUsername());

        if (loginAdministrator == null){
            return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }

        if (!user.getPassword().isEmpty() && loginAdministrator.getPassword().equals(user.getPassword())){
            return Result.ok(loginAdministrator);
        }
        return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
    }

    @Override
    public Result myUpdateAdministrator(Administrator administrator) {
        return Result.ok(saveOrUpdate(administrator));
    }
}
