package com.company.rewards.controller;

import com.company.rewards.dto.RewardsResponseDTO;
import com.company.rewards.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RewardsController {

    @Autowired
    RewardsService rewardsService;

    @GetMapping("/rewards")
    List<RewardsResponseDTO> getAllRewards(){
        List<RewardsResponseDTO> rewardsResponseDTO= rewardsService.getAllRewards();
        return rewardsResponseDTO;
    }

    @GetMapping("/rewards/{customerName}")
    RewardsResponseDTO getRewardsByCustomerId(@PathVariable(name = "customerName")String customerName){
        RewardsResponseDTO rewardsResponseDTO=rewardsService.getRewardsByCustomerName(customerName);
        return rewardsResponseDTO;
    }
}
