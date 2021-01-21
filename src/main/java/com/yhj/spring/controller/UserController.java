package com.yhj.spring.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yhj.spring.bean.User;
import com.yhj.spring.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Repository
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/insertPage")
    public String index(){
        return "insertPage";
    }

//    @RequestMapping("/select/{id}")
//    public String select(String id,Model model){
//        System.out.print("id is :" + id);
//        List<User> users = userService.select(id);
//        model.addAttribute("users",users);
//        return "queryPage";
//    }

    @RequestMapping("/select")
    public String queryList(
            String id,
            Model model,
            @RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "size", defaultValue = "3") int size
    )
            throws Exception {
        PageHelper.startPage(start,size,"id asc");      //startpage方式分页，按id正序排列，紧跟其后的第一个查询将被分页
        List<User> users= userService.select(id);
        PageInfo<User> page = new PageInfo<>(users);
        model.addAttribute("page", page);
        model.addAttribute("id", id);
        return "queryPage";
    }

//    原始展示页面
//    @RequestMapping("/userList")
//    public String userList(Model model){
//        List<User> users = userService.userList();
//        model.addAttribute("users",users);
//        return "userList";
//    }

//   @RequestParam：将请求参数绑定到你控制器的方法参数上（是springmvc中接收普通参数的注解）
//   语法：
//   @RequestParam(value=”参数名”,required=”true/false”,defaultValue=””)
//   value：参数名
//   required：是否包含该参数，默认为true，表示该请求路径中必须包含该参数，如果不包含就报错。
//   defaultValue：默认参数值，如果设置了该值，required=true将失效，自动为false,如果没有传该参数，就使用默认值

    @RequestMapping("/userList")
    public String userList(
            Model model,
            @RequestParam(value = "start", defaultValue = "0") int start,
            @RequestParam(value = "size", defaultValue = "5") int size
            )
            throws Exception {
        PageHelper.startPage(start,size,"id asc");      //startpage方式分页，按id正序排列，紧跟其后的第一个查询将被分页
        List<User> users= userService.userList();
        PageInfo<User> page = new PageInfo<>(users);
        model.addAttribute("page", page);
        return "userList";
    }

    @RequestMapping("/insert")
    public String save(User user){
        userService.save(user);
        return "redirect:/userList";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        userService.delete(id);
        return "redirect:/userList";
    }

    @GetMapping("/updatePage/{id}")
    public String updatePage(Model model,@PathVariable int id){
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        return "updatePage";
    }

    @PostMapping("/update")
    public String updateUser(User user){
        userService.update(user);
        return "redirect:/userList";
    }
}
