package com.hmmas.core.controllers;

import com.hmmas.core.commons.ApiResponse;
import com.hmmas.core.exceptions.BusinessExceptions;
import com.hmmas.core.models.Speciality;
import com.hmmas.core.service.SpecialityService;
import com.hmmas.core.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/speciality")
public class SpecialityController {

    @Autowired
    private SpecialityService specialityService;

    @PostMapping("/create")
    public ApiResponse<Speciality> create(@RequestBody Speciality speciality){
        speciality = specialityService.create(speciality).orElseThrow(()->new BusinessExceptions("Could not Save New Speciality"));
        return new ApiResponse<>(HttpStatus.OK.value(), speciality);
    }

    @PostMapping("/update/{id}")
    public ApiResponse<Speciality> update(@RequestBody Speciality speciality){
        speciality = specialityService.update(speciality).orElseThrow(()->new BusinessExceptions("Could Not Update Speciality"));
        return new ApiResponse<>(HttpStatus.OK.value(), speciality);
    }

    @GetMapping("/delete/{id}")
    public ApiResponse<Speciality> delete(@PathVariable("id") Long id){
        Speciality speciality = specialityService.findById(id).orElseThrow(()->new BusinessExceptions("Resource Not Found"));
        speciality.setStatus(Status.DELETED);
        specialityService.update(speciality);
        return new ApiResponse<>(HttpStatus.OK.value(), speciality);
    }

    @Value("${vms.default.page.size}")
    private int defaultPageSize;

    @GetMapping("/list/page/{page}/size/{size}")
    public ApiResponse<List<Speciality>> findAll(@PathVariable("page") int page, @PathVariable("size") int size){
        size = size <= 0 ? defaultPageSize : size;
        return new ApiResponse<>(HttpStatus.OK.value(),specialityService.findAll(page, size));
    }

    @GetMapping("/findbyid/{id}")
    public ApiResponse<Speciality> findById(@PathVariable("id") Long id){
        Speciality speciality = specialityService.findById(id).orElseThrow(()->new BusinessExceptions("Resource Not Found"));
        return new ApiResponse<>(HttpStatus.OK.value(), speciality);
    }
}
