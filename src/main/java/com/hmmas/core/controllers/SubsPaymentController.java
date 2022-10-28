package com.hmmas.core.controllers;

import com.hmmas.core.commons.ApiResponse;
import com.hmmas.core.exceptions.BusinessExceptions;
import com.hmmas.core.models.Member;
import com.hmmas.core.models.SubsPayment;
import com.hmmas.core.service.MemberService;
import com.hmmas.core.service.SubsPaymentService;
import com.hmmas.core.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/subspayment")
public class SubsPaymentController {

    @Autowired
    private SubsPaymentService subsPaymentService;

    @PostMapping("/create")
    public ApiResponse<SubsPayment> create(@RequestBody SubsPayment subsPayment){
        subsPayment = subsPaymentService.create(subsPayment).orElseThrow(()->new BusinessExceptions("Could not Save New Subscription Payment"));
        return new ApiResponse<>(HttpStatus.OK.value(), subsPayment);
    }

    @PostMapping("/update/{id}")
    public ApiResponse<SubsPayment> update(@RequestBody SubsPayment subsPayment){
        subsPayment = subsPaymentService.update(subsPayment).orElseThrow(()->new BusinessExceptions("Could Not Update Member Scheme"));
        return new ApiResponse<>(HttpStatus.OK.value(), subsPayment);
    }

    @GetMapping("/delete/{id}")
    public ApiResponse<SubsPayment> delete(@PathVariable("id") Long id){
        SubsPayment subsPayment = subsPaymentService.findById(id).orElseThrow(()->new BusinessExceptions("Resource Not Found"));
        subsPayment.setStatus(Status.DELETED);
        subsPaymentService.update(subsPayment);
        return new ApiResponse<>(HttpStatus.OK.value(), subsPayment);
    }

    @Value("${vms.default.page.size}")
    private int defaultPageSize;

    @GetMapping("/list/page/{page}/size/{size}")
    public ApiResponse<List<SubsPayment>> findAll(@PathVariable("page") int page, @PathVariable("size") int size){
        size = size <= 0 ? defaultPageSize : size;
        return new ApiResponse<>(HttpStatus.OK.value(), subsPaymentService.findAll(page, size));
    }

    @GetMapping("/findbyid/{id}")
    public ApiResponse<SubsPayment> findById(@PathVariable("id") Long id){
        SubsPayment subsPayment = subsPaymentService.findById(id).orElseThrow(()->new BusinessExceptions("Resource Not Found"));
        return new ApiResponse<>(HttpStatus.OK.value(), subsPayment);
    }


}
