package com.hmmas.core.serviceImpl;

import com.hmmas.core.models.Member;
import com.hmmas.core.models.SubsPayment;
import com.hmmas.core.repository.MemberRepository;
import com.hmmas.core.repository.SubsPaymentRepository;
import com.hmmas.core.service.MemberService;
import com.hmmas.core.service.SubsPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubsPaymentServiceImp implements SubsPaymentService {

    @Autowired
    private SubsPaymentRepository subsPaymentRepository;

    @Override
    public Optional<SubsPayment> findById(Object id) {
        return subsPaymentRepository.findById((Long) id);
    }

    @Override
    public List<SubsPayment> findAll() {
        return null;
    }

    @Override
    public Optional<SubsPayment> create(SubsPayment subsPayment) {
        return Optional.ofNullable(subsPaymentRepository.save(subsPayment));
    }

    @Override
    public Optional<SubsPayment> update(SubsPayment subsPayment) {
        return Optional.ofNullable(subsPaymentRepository.save(subsPayment));
    }

    @Override
    public void delete(SubsPayment subsPayment) {
        subsPaymentRepository.delete(subsPayment);

    }
}
