package com.traceprice.takeoffer.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerController {
    @GetMapping("/server")
    public String getServerName() {
//
        return "Response from "; }
}