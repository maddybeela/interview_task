package com.company.rewards.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RewardsResponseDTO {

    String customerName;
    Integer previousOneMonthRewardPoints;
    Integer previousTwoMonthRewardPoints;
    Integer previousThreeMonthRewardPoints;
    Integer totalRewardPoints;
}
