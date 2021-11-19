package com.firstWeb.web;

import com.firstWeb.config.auth.LoginUser;
import com.firstWeb.config.auth.dto.SessionUser;
import com.firstWeb.domain.posts.PostsRepository;
import com.firstWeb.service.posts.PostsService;
import com.firstWeb.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    //private final HttpSession httpSession;
    @GetMapping("/")
    public String index(Model model , @LoginUser SessionUser user){
        model.addAttribute("posts",postsService.findAllDesc());
//로그인 성공시 세션에 유저정보 저장
       // SessionUser user =(SessionUser)httpSession.getAttribute("user");
// 저장된 값이 있을때만 유저 정보 보임 --> 값이 없으면 로그인 버튼이 보임
        if(user!=null){
            model.addAttribute("googleName",user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id ,Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);

        return "posts-update";
    }
}
