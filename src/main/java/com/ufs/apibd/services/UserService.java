package com.ufs.apibd.services;

import com.ufs.apibd.models.UserModel;
import com.ufs.apibd.services.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public UserModel save(UserModel userModel){
        return userRepository.save(userModel);
    }

    public boolean existsByCpf(long cpf){
        return userRepository.existsByCpf(cpf);
    }

    public Optional<UserModel> findByCpf(long cpf){
        return userRepository.findByCpf(cpf);
    }

}
