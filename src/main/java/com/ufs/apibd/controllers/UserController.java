package com.ufs.apibd.controllers;

import com.ufs.apibd.dtos.UserDto;
import com.ufs.apibd.models.UserModel;
import com.ufs.apibd.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Usuário", description = "Coleção de endpoints do usuário")
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @Operation(summary = "Cadastrar Usuário.")
    @ApiResponse(responseCode = "201", description = "Sucesso")
    public ResponseEntity<Object> cadastraUsuario(@RequestBody UserDto userDto){
        if(userService.existsByCpf(userDto.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um usuario com esse cpf.");
        }
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);
        userModel.setDtaNascimento(LocalDate.parse(userDto.getDtaNascimento()));
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }
    @Operation(summary = "Buscar Usuário pelo cpf.")
    @GetMapping("/{cpf}")
    public ResponseEntity<Object> findByCpf(@PathVariable(value = "cpf") long cpf){
        Optional<UserModel> userModelOptional = userService.findByCpf(cpf);
        if (!userModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cpf não cadastrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userModelOptional.get());
    }
}
