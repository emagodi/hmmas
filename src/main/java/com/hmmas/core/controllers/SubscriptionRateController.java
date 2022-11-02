package com.hmmas.core.controllers;

import com.hmmas.core.commons.ApiResponse;
import com.hmmas.core.exceptions.BusinessExceptions;
import com.hmmas.core.models.SubscriptionRate;
import com.hmmas.core.repository.SubscriptionRateRepository;
import com.hmmas.core.service.SubscriptionRateService;
import com.hmmas.core.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/subscriptionrate")
public class SubscriptionRateController {

    @Autowired
    private SubscriptionRateService subscriptionRateService;

    @Autowired
    private SubscriptionRateRepository subscriptionRateRepository;

    @PostMapping("/create")
    public ApiResponse<SubscriptionRate> create(@RequestBody SubscriptionRate subscriptionRate){
        subscriptionRate = subscriptionRateService.create(subscriptionRate).orElseThrow(()->new BusinessExceptions("Could not Save New Subscription Rate"));
        return new ApiResponse<>(HttpStatus.OK.value(), "success", subscriptionRate);
    }

    @PostMapping("/update/")
    public ApiResponse<SubscriptionRate> update(@RequestBody SubscriptionRate subscriptionRate){
        subscriptionRate = subscriptionRateService.update(subscriptionRate).orElseThrow(()->new BusinessExceptions("Could Not Update Subscription Rate"));
        return new ApiResponse<>(HttpStatus.OK.value(), "success", subscriptionRate);
    }

    @GetMapping("/delete/{id}")
    public ApiResponse<SubscriptionRate> delete(@PathVariable("id") Long id){
        SubscriptionRate subscriptionRate = subscriptionRateService.findById(id).orElseThrow(()->new BusinessExceptions("Resource Not Found"));
        subscriptionRate.setStatus(Status.DELETED);
        subscriptionRateService.update(subscriptionRate);
        return new ApiResponse<>(HttpStatus.OK.value(), "success", subscriptionRate);
    }


    @GetMapping("/list/")
    public ApiResponse<List<SubscriptionRate>> findAll(){
        return new ApiResponse<>(HttpStatus.OK.value(), "success", subscriptionRateRepository.findAll());
    }


    @GetMapping("/findbyid/{id}")
    public ApiResponse<SubscriptionRate> findById(@PathVariable("id") Long id){
        SubscriptionRate subscriptionRate = subscriptionRateService.findById(id).orElseThrow(()->new BusinessExceptions("Resource Not Found"));
        return new ApiResponse<>(HttpStatus.OK.value(), "success", subscriptionRate);
    }
}
