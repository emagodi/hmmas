package com.hmmas.core.controllers;

import com.hmmas.core.commons.ApiResponse;
import com.hmmas.core.exceptions.BusinessExceptions;
import com.hmmas.core.models.Provider;
import com.hmmas.core.repository.ProviderRepository;
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

    @Autowired
    private ProviderRepository providerRepository;

    @PostMapping("/create")
    public ApiResponse<Provider> create(@RequestBody Provider provider){
        provider = providerService.create(provider).orElseThrow(()->new BusinessExceptions("Could not Save New Provider"));
        return new ApiResponse<>(HttpStatus.OK.value(), "success", provider);
    }

    @PostMapping("/update/{id}")
    public ApiResponse<Provider> update(@RequestBody Provider provider){
        provider = providerService.update(provider).orElseThrow(()->new BusinessExceptions("Could Not Update Provider"));
        return new ApiResponse<>(HttpStatus.OK.value(), "success", provider);
    }

    @GetMapping("/delete/{id}")
    public ApiResponse<Provider> delete(@PathVariable("id") Long id){
        Provider provider = providerService.findById(id).orElseThrow(()->new BusinessExceptions("Resource Not Found"));
        provider.setStatus(Status.DELETED);
        providerService.update(provider);
        return new ApiResponse<>(HttpStatus.OK.value(), "success", provider);
    }

    @GetMapping("/list/")
    public ApiResponse<List<Provider>> findAll(){
        return new ApiResponse<>(HttpStatus.OK.value(), "success", providerRepository.findAll());
    }

    @GetMapping("/findbyid/{id}")
    public ApiResponse<Provider> findById(@PathVariable("id") Long id){
        Provider provider = providerService.findById(id).orElseThrow(()->new BusinessExceptions("Resource Not Found"));
        return new ApiResponse<>(HttpStatus.OK.value(), "success", provider);
    }
}
