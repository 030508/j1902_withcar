package com.qf.j1902.controller.carManagerController;

import com.qf.j1902.pojo.Car;
import com.qf.j1902.pojo.CarModel;
import com.qf.j1902.service.CarSeriesService;
import com.qf.j1902.service.CarService;
import com.qf.j1902.vo.PageRelstVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Controller
public class CarSeriesController {
    @Autowired
    private CarService carService;
    @Autowired
    private CarSeriesService carSeriesService;

    @RequestMapping("/valid/car_series_manager")
    public String carSeriesManager(Model model){
        List<CarModel> carModels = carSeriesService.getCarModel();
        model.addAttribute("carModels",carModels);
        return "car_series_manager";
    }

    @RequestMapping("/valid/add_car_series")
    public String addCarSeries(Model model){
        List<Car> cars = carService.cars();
        model.addAttribute("cars",cars);
        return "add_car_series";
    }
    @RequestMapping("/valid/update_car_series")
    public String updateCarSeries(@RequestParam(value = "id",defaultValue = "1")Integer id,
                                  @RequestParam(value = "name",defaultValue = "1")String  name,
                                  @RequestParam(value = "makeName",defaultValue = "1")String  makeName,
                                  @RequestParam(value = "bodyFormName",defaultValue = "1")String  bodyFormName,Model model){
        model.addAttribute("id",id);
        model.addAttribute("name",name);
        model.addAttribute("makeName",makeName);
        model.addAttribute("bodyFormName",bodyFormName);
        return "update_car_series";
    }


    @RequestMapping(value = "/valid/carModelList",method = RequestMethod.POST)
    @ResponseBody
    public Object getCarModel(@RequestParam(value = "page",defaultValue = "1")Integer pageNum, @RequestParam(value = "rows",defaultValue = "10")Integer pageSize
            , @RequestParam(value = "countryId",defaultValue = "0")Integer countryId, @RequestParam(value = "bodyForm",defaultValue = "0")Integer bodyForm, @RequestParam(value = "name",defaultValue = "")String name){
        PageRelstVo pageRelstVo = carSeriesService.getPageRelst(pageNum,pageSize,countryId,bodyForm,name);
        return pageRelstVo;
    }


    @RequestMapping(value = "/valid/add_car_series_reslt",method = RequestMethod.POST)
    @ResponseBody
    public Object addCarSeriesReslt(CarModel carModel){
        Boolean b = carSeriesService.addCarModel(carModel);
        return b?"1":"2";
    }@RequestMapping(value = "/valid/delCarSeries",method = RequestMethod.POST)
    @ResponseBody
    public Object delCarSeriesReslt(@RequestParam(value = "id",defaultValue = "1")Integer id){
        Boolean b = carSeriesService.delCarSeries(id);
        return b?"1":"2";
    }
}
