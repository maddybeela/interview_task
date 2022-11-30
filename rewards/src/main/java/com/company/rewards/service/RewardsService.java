package com.company.rewards.service;

import com.company.rewards.dto.RewardsResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RewardsService {

    List<RewardsResponseDTO> getAllRewards();

    RewardsResponseDTO getRewardsByCustomerName(String customerId);
}
