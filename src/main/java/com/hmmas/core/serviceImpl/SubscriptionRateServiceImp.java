package com.hmmas.core.serviceImpl;

import com.hmmas.core.models.SubscriptionRate;
import com.hmmas.core.repository.SubscriptionRateRepository;
import com.hmmas.core.service.SubscriptionRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionRateServiceImp implements SubscriptionRateService {

    @Autowired
    private SubscriptionRateRepository subscriptionRateRepository;

    @Override
    public Optional<SubscriptionRate> findById(Object id) {
        return subscriptionRateRepository.findById((Long) id);
    }

    @Override
    public List<SubscriptionRate> findAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<SubscriptionRate> create(SubscriptionRate subscriptionRate) {
        return Optional.ofNullable(subscriptionRateRepository.save(subscriptionRate));
    }

    @Override
    public Optional<SubscriptionRate> update(SubscriptionRate subscriptionRate) {
        return Optional.ofNullable(subscriptionRateRepository.save(subscriptionRate));
    }

    @Override
    public void delete(SubscriptionRate subscriptionRate) {
        subscriptionRateRepository.delete(subscriptionRate);

    }
}
