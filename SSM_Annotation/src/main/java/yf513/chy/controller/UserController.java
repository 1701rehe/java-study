package yf513.chy.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yf513.chy.controller.results.Code;
import yf513.chy.controller.results.Result;
import yf513.chy.domain.User;
import yf513.chy.service.UserService;
import yf513.chy.system.exception.BusinessException;

/**
 * @author CHY
 * @date 2020/12/17 14:07
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{uuid}")
    public Result find(@PathVariable Integer uuid) {
        User user = userService.findById(uuid);
        //模拟出现异常，使用条件控制，便于测试结果
        if (uuid == 10) throw new BusinessException("查询出错啦，请重试！", Code.GET_ERROR);
        return new Result(null != user ? Code.GET_OK : Code.GET_ERROR, user);
    }


    @PostMapping()
    public Result save(User user) {
        boolean flag = userService.save(user);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERROR);
    }

    @PutMapping()
    public Result update(User user) {
        boolean flag = userService.update(user);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERROR);
    }

    @DeleteMapping("/{uuid}")
    public Result delete(@PathVariable Integer uuid) {
        boolean flag = userService.delete(uuid);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERROR);
    }

    @GetMapping("/{page}/{size}")
    public Result findAll(@PathVariable int page, @PathVariable int size) {
        PageInfo<User> all = userService.findAll(page, size);
        return new Result(null != all ? Code.GET_OK : Code.GET_ERROR, all);
    }

    @PostMapping("/login")
    public Result login(String userName, String password) {
        User user = userService.login(userName, password);
        return new Result(null != user ? Code.GET_OK : Code.GET_ERROR, user);
    }

}
