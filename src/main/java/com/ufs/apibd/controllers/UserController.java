package com.ufs.apibd.controllers;

import com.ufs.apibd.dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/usuario")
public class UserController {

    @PostMapping
    public ResponseEntity<Object> cadastraUsuario(@RequestBody UserDto userDto){

    }
}
