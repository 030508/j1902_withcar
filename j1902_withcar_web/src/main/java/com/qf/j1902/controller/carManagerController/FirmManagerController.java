package com.qf.j1902.controller.carManagerController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/valid")
public class FirmManagerController {

    @RequestMapping("/firm_manager")
    @ResponseBody
    public Object firmManager(){
        return null;
    }
}
