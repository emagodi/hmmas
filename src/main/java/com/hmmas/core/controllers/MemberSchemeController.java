package com.hmmas.core.controllers;

import com.hmmas.core.commons.ApiResponse;
import com.hmmas.core.exceptions.BusinessExceptions;
import com.hmmas.core.repository.MemberSchemeRepository;
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

    @Autowired
    private MemberSchemeRepository memberSchemeRepository;

    @PostMapping("/create")
    public ApiResponse<MemberScheme> create(@RequestBody MemberScheme memberScheme){
        memberScheme = memberSchemeService.create(memberScheme).orElseThrow(()->new BusinessExceptions("Could not Save New Member Scheme"));
        return new ApiResponse<>(HttpStatus.OK.value(), "success", memberScheme);
    }

    @PostMapping("/update/{id}")
    public ApiResponse<MemberScheme> update(@RequestBody MemberScheme memberScheme){
        memberScheme = memberSchemeService.update(memberScheme).orElseThrow(()->new BusinessExceptions("Could Not Update Member Scheme"));
        return new ApiResponse<>(HttpStatus.OK.value(), "success", memberScheme);
    }

    @GetMapping("/delete/{id}")
    public ApiResponse<MemberScheme> delete(@PathVariable("id") Long id){
        MemberScheme memberScheme = memberSchemeService.findById(id).orElseThrow(()->new BusinessExceptions("Resource Not Found"));
        memberScheme.setStatus(Status.DELETED);
        memberSchemeService.update(memberScheme);
        return new ApiResponse<>(HttpStatus.OK.value(), "success", memberScheme);
    }


    @GetMapping("/list/")
    public ApiResponse<List<MemberScheme>> findAll(){
        return new ApiResponse<>(HttpStatus.OK.value(), "success", memberSchemeRepository.findAll());
    }


    @GetMapping("/findbyid/{id}")
    public ApiResponse<MemberScheme> findById(@PathVariable("id") Long id){
        MemberScheme memberScheme = memberSchemeService.findById(id).orElseThrow(()->new BusinessExceptions("Resource Not Found"));
        return new ApiResponse<>(HttpStatus.OK.value(), "success", memberScheme);
    }
}
