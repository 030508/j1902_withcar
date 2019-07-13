package com.qf.j1902.controller.carManagerController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CarSeriesManagerController {

    @RequestMapping("/valid/car_style_manager")
    public String carStyleManager(){
        return "car_style_manager";
    }
}
