package com.ufs.apibd.controllers;

import com.ufs.apibd.dtos.UserDto;
import com.ufs.apibd.models.UserModel;
import com.ufs.apibd.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/usuario")
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Object> cadastraUsuario(@RequestBody UserDto userDto){
        if(userService.existsByCpf(userDto.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um usuario com esse cpf.");
        }
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);
        userModel.setDtaNascimento(LocalDate.parse(userDto.getDtaNascimento()));
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Object> findByCpf(@PathVariable(value = "cpf") long cpf){
        Optional<UserModel> userModelOptional = userService.findByCpf(cpf);
        if (!userModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cpf não cadastrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userModelOptional.get());
    }
}
