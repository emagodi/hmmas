package com.hmmas.core.controllers;

import com.hmmas.core.commons.ApiResponse;
import com.hmmas.core.exceptions.BusinessExceptions;
import com.hmmas.core.models.Provider;
import com.hmmas.core.service.ProviderService;
import com.hmmas.core.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @PostMapping("/create")
    public ApiResponse<Provider> create(@RequestBody Provider provider){
        provider = providerService.create(provider).orElseThrow(()->new BusinessExceptions("Could not Save New Provider"));
        return new ApiResponse<>(HttpStatus.OK.value(), provider);
    }

    @PostMapping("/update/{id}")
    public ApiResponse<Provider> update(@RequestBody Provider provider){
        provider = providerService.update(provider).orElseThrow(()->new BusinessExceptions("Could Not Update Provider"));
        return new ApiResponse<>(HttpStatus.OK.value(), provider);
    }

    @GetMapping("/delete/{id}")
    public ApiResponse<Provider> delete(@PathVariable("id") Long id){
        Provider provider = providerService.findById(id).orElseThrow(()->new BusinessExceptions("Resource Not Found"));
        provider.setStatus(Status.DELETED);
        providerService.update(provider);
        return new ApiResponse<>(HttpStatus.OK.value(), provider);
    }

    @Value("${vms.default.page.size}")
    private int defaultPageSize;

    @GetMapping("/list/page/{page}/size/{size}")
    public ApiResponse<List<Provider>> findAll(@PathVariable("page") int page, @PathVariable("size") int size){
        size = size <= 0 ? defaultPageSize : size;
        return new ApiResponse<>(HttpStatus.OK.value(),providerService.findAll(page, size));
    }

    @GetMapping("/findbyid/{id}")
    public ApiResponse<Provider> findById(@PathVariable("id") Long id){
        Provider provider = providerService.findById(id).orElseThrow(()->new BusinessExceptions("Resource Not Found"));
        return new ApiResponse<>(HttpStatus.OK.value(), provider);
    }
}
