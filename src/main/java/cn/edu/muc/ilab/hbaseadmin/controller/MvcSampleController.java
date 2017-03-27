package cn.edu.muc.ilab.hbaseadmin.controller;

import cn.edu.muc.ilab.hbaseadmin.demo.User;
import cn.edu.muc.ilab.hbaseadmin.demo.UserRepository;
import cn.edu.muc.ilab.hbaseadmin.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class MvcSampleController {
    @Resource
    private GreetingService greetingService;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(Model model){
        //userRepository.save("admin","admin@test.com","123456");
        boolean singleton_user = userRepository.isTableExist("Singleton_user");
        System.out.println(singleton_user);
        List<User> all = userRepository.findAll();
        System.out.println(all.toString());
        model.addAttribute("a","hello world");
        return "home";
    }
}
