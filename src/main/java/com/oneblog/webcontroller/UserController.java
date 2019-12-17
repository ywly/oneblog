package com.oneblog.webcontroller;

import com.oneblog.entity.User;
import com.oneblog.service.userService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class UserController {
    @Resource
    private userService userService;

//new

    /**
     * service拿到数据放到model并且传到index.jsp页面
     * @param model
     * @return
     */
    @RequestMapping("/userList")
    public String index(Model model){

        List<User> students = userService.selectStudent();
        model.addAttribute("list",students);
        return "index.jsp";
    }

//    @RequestMapping("/userlogin")
//    public String loginuser(String username,String password,Map<String,Object> map, HttpSession session){
//        System.out.println(username);
//        System.out.println(password);
//        List<User> loginuser = userService.loginuser(username,password);
//        System.out.println(loginuser);
//
//
//        session.setAttribute("user",loginuser);
//        map.put("data",loginuser);
//
//        if(loginuser!=null){
//            return "HelloUser.jsp";
//        }else{
//            return "redirect:userlogin";
//        }
//    }

    @RequestMapping("/userlogin")
    public String loginuser(String username,String password,Model model, HttpSession session) {
        System.out.println(username);
        System.out.println(password);
        List<User> loginuser = userService.loginuser(username, password);

        System.out.println(loginuser);

        session.setAttribute("username", username);
//        map.put("data",loginuser);
        model.addAttribute("modeluser", loginuser);
        if (loginuser == null || loginuser.size() == 0) {
            return "login.jsp";
        } else {
            for (User user : loginuser) {
                if (user.getRole() != 1) {
                    return "HelloUser.jsp";

                } else {
                    return "admin.jsp";
                }
            }

        }
        return null;

    }

//    @RequestMapping("/usernameishave")
//    public String usernameishave(String username, Model model){
//        List<User> usernameishave=userService.usernameishave(username);
//        model.addAttribute("usernameishave","");
//        if(usernameishave==null||usernameishave.size()==0){
//            model.addAttribute("usernameishave","username can use");
//            return "login.jsp";
//        }else{
//            model.addAttribute("usernameishave","username is used");
//            return "login.jsp";
//        }
//    }

    @RequestMapping("/usernameishave")
    public String usernameishave(String username, Model model){
        List<User> usernameishave=userService.usernameishave(username);
        System.out.println(username);
        model.addAttribute("usernameishave","");
        if(usernameishave==null||usernameishave.size()==0){
            model.addAttribute("usernameishave","username can use");
            System.out.println("222");
            return "redirect:register.jsp";
        }else{
            model.addAttribute("usernameishave","username is used");
            return "redirect:register.jsp";
        }
    }

    @RequestMapping("/emailishave")
    public String emailishave(String email, Model model){
        List<User> emailishave=userService.emailishave(email);
        model.addAttribute("emailishave","");
        if(emailishave==null||emailishave.size()==0){
            model.addAttribute("emailishave","email can use");
            return "login.jsp";
        }else{
            model.addAttribute("emailishave","email is used");
            return "login.jsp";
        }
    }

    @RequestMapping("/adduser")
    public String adduser(User user,Model model, HttpSession session){
        userService.adduser(user);
        String username = user.getUsername();
        String password = user.getPassword();
        List<User> loginuser = userService.loginuser(username, password);
        session.setAttribute("username",username);
        model.addAttribute("modeluser",loginuser);
        model.addAttribute("emailishave","");
        if(loginuser==null||loginuser.size()==0){
            return "login.jsp";
        }else{
            return "HelloUser.jsp";
        }
    }

}
