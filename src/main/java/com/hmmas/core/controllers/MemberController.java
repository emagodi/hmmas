package com.hmmas.core.controllers;

import com.hmmas.core.commons.ApiResponse;
import com.hmmas.core.exceptions.BusinessExceptions;
import com.hmmas.core.models.Member;
import com.hmmas.core.models.MemberScheme;
import com.hmmas.core.service.MemberSchemeService;
import com.hmmas.core.service.MemberService;
import com.hmmas.core.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/create")
    public ApiResponse<Member> create(@RequestBody Member member){
        member = memberService.create(member).orElseThrow(()->new BusinessExceptions("Could not Save New Member Scheme"));
        return new ApiResponse<>(HttpStatus.OK.value(), member);
    }

    @PostMapping("/update/{id}")
    public ApiResponse<Member> update(@RequestBody Member member){
        member = memberService.update(member).orElseThrow(()->new BusinessExceptions("Could Not Update Member Scheme"));
        return new ApiResponse<>(HttpStatus.OK.value(), member);
    }

    @GetMapping("/delete/{id}")
    public ApiResponse<Member> delete(@PathVariable("id") Long id){
        Member member = memberService.findById(id).orElseThrow(()->new BusinessExceptions("Resource Not Found"));
        member.setStatus(Status.DELETED);
        memberService.update(member);
        return new ApiResponse<>(HttpStatus.OK.value(), member);
    }

    @Value("${vms.default.page.size}")
    private int defaultPageSize;

    @GetMapping("/list/page/{page}/size/{size}")
    public ApiResponse<List<Member>> findAll(@PathVariable("page") int page, @PathVariable("size") int size){
        size = size <= 0 ? defaultPageSize : size;
        return new ApiResponse<>(HttpStatus.OK.value(), memberService.findAll(page, size));
    }

    @GetMapping("/findbyid/{id}")
    public ApiResponse<Member> findById(@PathVariable("id") Long id){
        Member member = memberService.findById(id).orElseThrow(()->new BusinessExceptions("Resource Not Found"));
        return new ApiResponse<>(HttpStatus.OK.value(), member);
    }
}
