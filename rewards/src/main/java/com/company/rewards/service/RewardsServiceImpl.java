package com.company.rewards.service;

import com.company.rewards.dto.RewardsResponseDTO;
import com.company.rewards.entity.Transaction;
import com.company.rewards.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RewardsServiceImpl implements RewardsService{

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<RewardsResponseDTO> getAllRewards() {

        List<String> customerNames=transactionRepository.findUniqueCustomer();
        List<RewardsResponseDTO> dtoRewardsList=new ArrayList<RewardsResponseDTO>();
        for(String customerName: customerNames){
            RewardsResponseDTO dto=getRewardsByCustomerName(customerName);
            dtoRewardsList.add(dto);
        }
        return dtoRewardsList;
    }

    @Override
    public RewardsResponseDTO getRewardsByCustomerName(String customerName) {

        Integer previousOneMonth=getRewardsCountForTheMonth(customerName,1);
        System.out.println("previousOneMonth: "+previousOneMonth);

        Integer previousTwoMonth=getRewardsCountForTheMonth(customerName,2);
        System.out.println("previousTwoMonth: "+previousTwoMonth);

        Integer previousThreeMonth=getRewardsCountForTheMonth(customerName,3);
        System.out.println("previousThreeMonth: "+previousThreeMonth);

        RewardsResponseDTO rewardsResponseDTO= RewardsResponseDTO.builder().customerName(customerName).previousOneMonthRewardPoints(previousOneMonth)
                .previousTwoMonthRewardPoints(previousTwoMonth).previousThreeMonthRewardPoints(previousThreeMonth).
                totalRewardPoints(previousOneMonth+previousTwoMonth+previousThreeMonth).build();

        return rewardsResponseDTO;
    }

    private Integer getRewardsCountForTheMonth(String customerName,int i) {
        LocalDate now = LocalDate.now();
        LocalDate startDate = now.minusMonths(i).with(TemporalAdjusters.firstDayOfMonth());
        LocalDate endDate = now.minusMonths(i).with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("start : "+startDate);
        System.out.println("end : "+endDate);
        List<Transaction> transactions= (List<Transaction>) transactionRepository.findByCustomerNameAndTransactionDateBetween(customerName,startDate,endDate);
        Integer totalRewards=transactions.stream().map(transaction -> calculateReward(transaction.getTransactionAmount())).collect(Collectors.summingInt(a->a.intValue()));
        System.out.println("totalRewards: "+totalRewards);
        return totalRewards;


    }

    private Integer calculateReward(Integer transactionAmount) {
        Integer rewards = 0;
        if(transactionAmount!=null){
            if(transactionAmount>100){
                rewards=((transactionAmount-100)*2) + 50;
            }
            else if(transactionAmount>50 && transactionAmount <=100){
                rewards=transactionAmount-50;
            }

        }
        return rewards;
    }
}
