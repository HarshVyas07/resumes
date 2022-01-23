package com.exam.examserver.Model;

import org.springframework.security.core.GrantedAuthority;

public class Autority  implements GrantedAuthority{

    private String authority;

    public Autority(String a){
        this.authority=a;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }



}
