/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtn.service.impl;

import com.vtn.repository.StatsRepository;
import com.vtn.service.StatsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tuann
 */
@Service
public class StatsServiceImpl implements StatsService{
    @Autowired
    private StatsRepository statsRepository;

    @Override
    public List<Object[]> statsRevenueByProduct() {
      return this.statsRepository.statsRevenueByProduct();
    }

    @Override
    public List<Object[]> statsRevenueByPeroid(int year, String peroid) {
       return this.statsRepository.statsRevenueByPeroid(year, peroid);
    }
    
}
