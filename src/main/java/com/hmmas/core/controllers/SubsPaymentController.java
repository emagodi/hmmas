package com.hmmas.core.controllers;

import com.hmmas.core.commons.ApiResponse;
import com.hmmas.core.exceptions.BusinessExceptions;
import com.hmmas.core.models.SubsPayment;
import com.hmmas.core.repository.SubsPaymentRepository;
import com.hmmas.core.service.SubsPaymentService;
import com.hmmas.core.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/subspayment")
public class SubsPaymentController {

    @Autowired
    private SubsPaymentService subsPaymentService;

    @Autowired
    private SubsPaymentRepository subsPaymentRepository;

    @PostMapping("/create")
    public ApiResponse<SubsPayment> create(@RequestBody SubsPayment subsPayment){
        subsPayment = subsPaymentService.create(subsPayment).orElseThrow(()->new BusinessExceptions("Could not Save New Subscription Payment"));
        return new ApiResponse<>(HttpStatus.OK.value(), "success", subsPayment);
    }

    @PostMapping("/update/")
    public ApiResponse<SubsPayment> update(@RequestBody SubsPayment subsPayment){
        subsPayment = subsPaymentService.update(subsPayment).orElseThrow(()->new BusinessExceptions("Could Not Update Member Scheme"));
        return new ApiResponse<>(HttpStatus.OK.value(), "success", subsPayment);
    }

    @GetMapping("/delete/{id}")
    public ApiResponse<SubsPayment> delete(@PathVariable("id") Long id){
        SubsPayment subsPayment = subsPaymentService.findById(id).orElseThrow(()->new BusinessExceptions("Resource Not Found"));
        subsPayment.setStatus(Status.DELETED);
        subsPaymentService.update(subsPayment);
        return new ApiResponse<>(HttpStatus.OK.value(), "success", subsPayment);
    }

    @GetMapping("/list/")
    public ApiResponse<List<SubsPayment>> findAll(){
        return new ApiResponse<>(HttpStatus.OK.value(), "success", subsPaymentRepository.findAll());
    }


    @GetMapping("/findbyid/{id}")
    public ApiResponse<SubsPayment> findById(@PathVariable("id") Long id){
        SubsPayment subsPayment = subsPaymentService.findById(id).orElseThrow(()->new BusinessExceptions("Resource Not Found"));
        return new ApiResponse<>(HttpStatus.OK.value(), "success", subsPayment);
    }

}
