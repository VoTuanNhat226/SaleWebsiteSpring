/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vtn.repository;

import com.vtn.pojo.User;

/**
 *
 * @author tuann
 */
public interface UserRepository {
    User getUserByUsername(String username);
}
