package com.demo.apirest.services;

import com.demo.apirest.model.Users;
import com.demo.apirest.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    private final UsersRepository usersRepository;

    @Autowired
    public UserService( UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public Users createUser(Users users){
        return usersRepository.save(users);
    }
    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }
    public Optional<Users> getUser(long id){
        return usersRepository.findById(id);
    }
    public void deleteUser( Users users){
        usersRepository.delete(users);
    }

    public Users updateUser( long id,Users user){
        Optional<Users> aux = usersRepository.findById(id);
        if(aux.isPresent()){
            Users foundUser = aux.get();
            foundUser.setName(foundUser.getName());
            foundUser.setEmail(foundUser.getEmail());
            foundUser.setPassword(foundUser.getPassword());
            foundUser.setModified(java.time.LocalDate.now());
            foundUser.setActive(foundUser.getActive());
            foundUser.setPhone(foundUser.getPhone());
            return usersRepository.save(foundUser);
        }else{
            return null;
        }

    }
    public Optional<Users> findById(Long id) {
        return usersRepository.findById(id);

    }
}
