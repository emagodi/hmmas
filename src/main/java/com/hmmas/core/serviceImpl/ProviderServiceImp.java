package com.hmmas.core.serviceImpl;

import com.hmmas.core.models.Provider;
import com.hmmas.core.repository.ProviderRepository;
import com.hmmas.core.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderServiceImp implements ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    @Override
    public Optional<Provider> findById(Object id) {
        return providerRepository.findById((Long) id);
    }

    @Override
    public List<Provider> findAll() {
        return null;
    }

    @Override
    public Optional<Provider> create(Provider provider) {
        return Optional.ofNullable(providerRepository.save(provider));
    }

    @Override
    public Optional<Provider> update(Provider provider) {
        return Optional.ofNullable(providerRepository.save(provider));
    }

    @Override
    public void delete(Provider provider) {
        providerRepository.delete(provider);

    }
}
