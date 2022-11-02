package com.hmmas.core.controllers;

import com.hmmas.core.commons.ApiResponse;
import com.hmmas.core.exceptions.BusinessExceptions;
import com.hmmas.core.models.ClaimsHistory;
import com.hmmas.core.models.Member;
import com.hmmas.core.repository.ClaimsHistoryRepository;
import com.hmmas.core.service.ClaimsHistoryService;
import com.hmmas.core.service.MemberService;
import com.hmmas.core.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/claimshistory")
public class ClaimsHistoryController {

    @Autowired
    private ClaimsHistoryService claimsHistoryService;

    @Autowired
    private ClaimsHistoryRepository claimsHistoryRepository;

    @PostMapping("/create")
    public ApiResponse<ClaimsHistory> create(@RequestBody ClaimsHistory claimsHistory){
        claimsHistory = claimsHistoryService.create(claimsHistory).orElseThrow(()->new BusinessExceptions("Could not Save New Claim History"));
        return new ApiResponse<>(HttpStatus.OK.value(), "success", claimsHistory);
    }

    @PostMapping("/update/")
    public ApiResponse<ClaimsHistory> update(@RequestBody ClaimsHistory claimsHistory){
        claimsHistory = claimsHistoryService.update(claimsHistory).orElseThrow(()->new BusinessExceptions("Could Not Update Claim History"));
        return new ApiResponse<>(HttpStatus.OK.value(), "success", claimsHistory);
    }

    @GetMapping("/delete/{id}")
    public ApiResponse<ClaimsHistory> delete(@PathVariable("id") Long id){
        ClaimsHistory claimsHistory = claimsHistoryService.findById(id).orElseThrow(()->new BusinessExceptions("Resource Not Found"));
        claimsHistory.setStatus(Status.DELETED);
        claimsHistoryService.update(claimsHistory);
        return new ApiResponse<>(HttpStatus.OK.value(), "success", claimsHistory);
    }


    @GetMapping("/list/")
    public ApiResponse<List<ClaimsHistory>> findAll(){
        return new ApiResponse<>(HttpStatus.OK.value(), "success", claimsHistoryRepository.findAll());
    }

    @GetMapping("/findbyid/{id}")
    public ApiResponse<ClaimsHistory> findById(@PathVariable("id") Long id){
        ClaimsHistory claimsHistory = claimsHistoryService.findById(id).orElseThrow(()->new BusinessExceptions("Resource Not Found"));
        return new ApiResponse<>(HttpStatus.OK.value(), "success", claimsHistory);
    }
}
