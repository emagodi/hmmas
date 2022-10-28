package com.hmmas.core.serviceImpl;

import com.hmmas.core.models.ClaimsHistory;
import com.hmmas.core.models.Member;
import com.hmmas.core.repository.ClaimsHistoryRepository;
import com.hmmas.core.repository.MemberRepository;
import com.hmmas.core.service.ClaimsHistoryService;
import com.hmmas.core.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaimsHistoryServiceImp implements ClaimsHistoryService {

    @Autowired
    private ClaimsHistoryRepository claimsHistoryRepository;

    @Override
    public Optional<ClaimsHistory> findById(Object id) {
        return claimsHistoryRepository.findById((Long) id);
    }

    @Override
    public List<ClaimsHistory> findAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<ClaimsHistory> create(ClaimsHistory claimsHistory) {
        return Optional.ofNullable(claimsHistoryRepository.save(claimsHistory));
    }

    @Override
    public Optional<ClaimsHistory> update(ClaimsHistory claimsHistory) {
        return Optional.ofNullable(claimsHistoryRepository.save(claimsHistory));
    }

    @Override
    public void delete(ClaimsHistory claimsHistory) {
        claimsHistoryRepository.delete(claimsHistory);

    }
}
