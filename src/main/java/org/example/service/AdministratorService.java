package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.pojo.Administrator;
import org.example.pojo.User;
import org.example.utils.Result;

public interface AdministratorService extends IService<Administrator> {

    Result login(User user);

    Result myUpdateAdministrator(Administrator administrator);
}
