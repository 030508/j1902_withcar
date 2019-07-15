package com.qf.j1902.controller.carManagerController;


import com.qf.j1902.service.CarService;
import com.qf.j1902.vo.PageRelstVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CarSeriesManagerController {
        @Autowired
        private CarService carService;


    @RequestMapping("/valid/car_style_manager")
    public String carStyleManager(){
        return "car_style_manager";
    }

    @RequestMapping(value = "/valid/car_style_manager_list",method = RequestMethod.POST)
    @ResponseBody
    public Object getCarStyleManagerList(@RequestParam(value = "page",defaultValue = "1")Integer pageNum, @RequestParam(value = "rows",defaultValue = "10")Integer pageSize
        ){
        PageRelstVo cars = carService.findAll(pageNum,pageSize);
        return cars;
    }

}
