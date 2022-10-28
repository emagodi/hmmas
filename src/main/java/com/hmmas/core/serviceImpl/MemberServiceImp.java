package com.hmmas.core.serviceImpl;

import com.hmmas.core.models.Member;
import com.hmmas.core.repository.MemberRepository;
import com.hmmas.core.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImp implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Optional<Member> findById(Object id) {
        return memberRepository.findById((Long) id);
    }

    @Override
    public List<Member> findAll(int page, int size) {
        return null;
    }

    @Override
    public Optional<Member> create(Member member) {
        return Optional.ofNullable(memberRepository.save(member));
    }

    @Override
    public Optional<Member> update(Member member) {
        return Optional.ofNullable(memberRepository.save(member));
    }

    @Override
    public void delete(Member member) {
        memberRepository.delete(member);

    }
}
