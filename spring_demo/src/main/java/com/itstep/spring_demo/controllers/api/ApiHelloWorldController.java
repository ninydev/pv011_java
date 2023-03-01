package com.itstep.spring_demo.controllers.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiHelloWorldController {

    @GetMapping("api/tryMe") // Указание типа запроса и маршрута
    public String tryMe() {
        return "tryMe";
    }

}
