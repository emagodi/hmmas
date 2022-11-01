package com.hmmas.core.serviceImpl;

import com.hmmas.core.models.Speciality;
import com.hmmas.core.repository.SpecialityRepository;
import com.hmmas.core.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialityServiceImp implements SpecialityService {

    @Autowired
    private SpecialityRepository specialityRepository;

    @Override
    public Optional<Speciality> findById(Object id) {
        return specialityRepository.findById((Long) id);
    }

    @Override
    public List<Speciality> findAll() {
        return null;
    }

    @Override
    public Optional<Speciality> create(Speciality speciality) {
        return Optional.ofNullable(specialityRepository.save(speciality));
    }

    @Override
    public Optional<Speciality> update(Speciality speciality) {
        return Optional.ofNullable(specialityRepository.save(speciality));
    }

    @Override
    public void delete(Speciality speciality) {
        specialityRepository.delete(speciality);

    }
}
