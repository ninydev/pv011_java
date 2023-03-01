package com.itstep.spring_demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // Указание, что данный класс является контроллером
@RequestMapping("try")
public class HelloWorldController {

    @GetMapping("tryMe") // Указание типа запроса и маршрута
    public String tryMe() {
        return ("tryMe"); // Указатие - какой тип вьюшки мы отдаем
    }

}
