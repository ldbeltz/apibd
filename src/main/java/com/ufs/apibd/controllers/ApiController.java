package com.ufs.apibd.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/usuario")
public class ApiController {
    @PostMapping
    public ResponseEntity<Object> cadastraUsuario(){

    }
}
