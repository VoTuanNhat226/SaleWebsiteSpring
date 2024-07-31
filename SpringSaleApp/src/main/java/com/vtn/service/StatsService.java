/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vtn.service;

import java.util.List;

/**
 *
 * @author tuann
 */
public interface StatsService {

    List<Object[]> statsRevenueByProduct();

    List<Object[]> statsRevenueByPeroid(int year, String peroid);
}
