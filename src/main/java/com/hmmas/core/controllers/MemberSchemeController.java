package com.hmmas.core.controllers;

import com.hmmas.core.commons.ApiResponse;
import com.hmmas.core.exceptions.BusinessExceptions;
import com.hmmas.core.service.MemberSchemeService;
import com.hmmas.core.models.MemberScheme;
import com.hmmas.core.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/memberscheme")
public class MemberSchemeController {

    @Autowired
    private MemberSchemeService memberSchemeService;

    @PostMapping("/create")
    public ApiResponse<MemberScheme> create(@RequestBody MemberScheme memberScheme){
        memberScheme = memberSchemeService.create(memberScheme).orElseThrow(()->new BusinessExceptions("Could not Save New Member Scheme"));
        return new ApiResponse<>(HttpStatus.OK.value(), memberScheme);
    }

    @PostMapping("/update/{id}")
    public ApiResponse<MemberScheme> update(@RequestBody MemberScheme memberScheme){
        memberScheme = memberSchemeService.update(memberScheme).orElseThrow(()->new BusinessExceptions("Could Not Update Member Scheme"));
        return new ApiResponse<>(HttpStatus.OK.value(), memberScheme);
    }

    @GetMapping("/delete/{id}")
    public ApiResponse<MemberScheme> delete(@PathVariable("id") Long id){
        MemberScheme memberScheme = memberSchemeService.findById(id).orElseThrow(()->new BusinessExceptions("Resource Not Found"));
        memberScheme.setStatus(Status.DELETED);
        memberSchemeService.update(memberScheme);
        return new ApiResponse<>(HttpStatus.OK.value(), memberScheme);
    }

    @Value("${vms.default.page.size}")
    private int defaultPageSize;

    @GetMapping("/list/page/{page}/size/{size}")
    public ApiResponse<List<MemberScheme>> findAll(@PathVariable("page") int page, @PathVariable("size") int size){
        size = size <= 0 ? defaultPageSize : size;
        return new ApiResponse<>(HttpStatus.OK.value(), memberSchemeService.findAll(page, size));
    }

    @GetMapping("/findbyid/{id}")
    public ApiResponse<MemberScheme> findById(@PathVariable("id") Long id){
        MemberScheme memberScheme = memberSchemeService.findById(id).orElseThrow(()->new BusinessExceptions("Resource Not Found"));
        return new ApiResponse<>(HttpStatus.OK.value(), memberScheme);
    }
}
