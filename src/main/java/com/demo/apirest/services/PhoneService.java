package com.demo.apirest.services;

import com.demo.apirest.model.Phone;
import com.demo.apirest.model.Users;
import com.demo.apirest.repository.PhonesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PhoneService {

    private PhonesRepository phonesRepository;

    @Autowired
    public void PhoneService(PhonesRepository phoneRepository){
        this.phonesRepository = phoneRepository;
    }

    public PhoneService(PhonesRepository phoneRepository) {
        this.phonesRepository = phoneRepository;
    }

    public Phone createPhone(Phone phones){
        return phonesRepository.save(phones);
    }

    public List<Phone> getAllPhone(){
        return phonesRepository.findAll();
    }

    public Optional<Phone> getPhone(long id){
        return phonesRepository.findById(id);
    }
    public void deletePhone( Phone phones){
        phonesRepository.delete(phones);
    }

    public Optional<Phone> findById(Long id) {
        return phonesRepository.findById(id);

    }

    public Phone updatePhone( long id,Phone phone){
        Optional<Phone> aux = phonesRepository.findById(id);
        if(aux.isPresent()){
            Phone foundPhone = aux.get();
            foundPhone.setNumber(foundPhone.getNumber());
            foundPhone.setCityCode(foundPhone.getCityCode());
            foundPhone.setCountryCode(foundPhone.getCountryCode());
            return phonesRepository.save(foundPhone);
        }else{
            return null;
        }

    }
}
