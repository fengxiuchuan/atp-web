package com.atp.controller;

import com.atp.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    static Map<Long,User> users = Collections.synchronizedMap(new HashMap<Long,User>());

    @ApiOperation(value = "获取用户列表",notes = "获取全部的用户列表")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<User> getUserList(){
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }

    @ApiOperation(value = "创建用户",notes = "根据User对象创建用户")
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        users.put(user.getId(),user);
        return "sucess";
    }

    @ApiOperation(value = "获取用户信息",notes = "根据用户主键ID获取用户信息")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        return users.get(id);
    }

    @ApiOperation(value = "根据用户信息",notes = "根据User对象更新用户信息")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id,@ModelAttribute User user){
        User user1 = users.get(id);
        user1.setName(user.getName());
        user1.setAge(user.getAge());
        users.put(id,user);
        return "success";
    }

    @ApiOperation(value = "删除用户信息",notes = "根据用户主键Id删除用户主键")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String delUser(@PathVariable Long id){
        users.remove(id);
        return "success";
    }
}
