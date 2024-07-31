/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vtn.service;

import com.vtn.pojo.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author tuann
 */
public interface UserService  extends UserDetailsService{
    User getUserByUsername(String username);
}
