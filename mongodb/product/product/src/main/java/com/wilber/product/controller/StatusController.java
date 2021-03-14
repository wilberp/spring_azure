package com.wilber.product.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
@Api(value = "Status endpoint",tags = {"Produtos end"})
@CrossOrigin(origins = "*")
public class StatusController {

    @GetMapping("/get")
    @ApiOperation(value = "Retorna o status")
    public String getStatus(){
        return "online";
    }
}
