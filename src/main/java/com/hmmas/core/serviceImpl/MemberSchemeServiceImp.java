package com.hmmas.core.serviceImpl;


import com.hmmas.core.models.MemberScheme;
import com.hmmas.core.repository.MemberSchemeRepository;
import com.hmmas.core.service.MemberSchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class MemberSchemeServiceImp implements MemberSchemeService {

    @Autowired
    private MemberSchemeRepository memberSchemeRepository;

    @Override
    public Optional<MemberScheme> findById(Object id) {
        return memberSchemeRepository.findById((Long) id);
    }

    @Override
    public List<MemberScheme> findAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<MemberScheme> create(MemberScheme memberScheme) {
        return Optional.ofNullable(memberSchemeRepository.save(memberScheme));
    }

    @Override
    public Optional<MemberScheme> update(MemberScheme memberScheme) {
        return Optional.ofNullable(memberSchemeRepository.save(memberScheme));
    }

    @Override
    public void delete(MemberScheme memberScheme) {
        memberSchemeRepository.delete(memberScheme);

    }
}
