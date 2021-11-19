package com.firstWeb.config.auth.dto;

import com.firstWeb.domain.user.User;
import lombok.Getter;
import java.io.Serializable;

@Getter
public class SessionUser implements Serializable{
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.name=user.getName();
        this.picture=user.getPicture();
        this.email=user.getEmail();
    }
}
