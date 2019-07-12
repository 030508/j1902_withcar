package com.qf.j1902.controller.carManagerController;


import com.qf.j1902.pojo.Car;
import com.qf.j1902.service.BrandManagerService;
import com.qf.j1902.service.CarService;
import com.qf.j1902.shiro.utils.ImageFloadUtils;
import com.qf.j1902.vo.PageRelstVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class BrandManagerController {
    @Autowired
    private BrandManagerService brandManagerService;
    @Autowired
    private CarService carService;

    @RequestMapping(value = "/valid/brand_manager",method = RequestMethod.GET)
    public String brandManager(Model model){
        List<Car> cars = carService.cars();
        model.addAttribute("cars",cars);
        return "brand_manager";
    }


    @RequestMapping(value = "/member/brandCar",method = RequestMethod.POST)
    @ResponseBody
    public Object brandCar(@RequestParam(value = "page",defaultValue = "1")Integer pageNum, @RequestParam(value = "rows",defaultValue = "10")Integer pageSize,@RequestParam(value = "countryId",defaultValue = "0")Integer countryId ,@RequestParam(value = "name",defaultValue = "")String name){
       PageRelstVo pageRelstVo= brandManagerService.selectAll(pageNum ,pageSize,countryId,name);
        return pageRelstVo;
    }
    @RequestMapping(value = "/valid/updateBrand",method = RequestMethod.GET)
    public String updateBrand(Model model,@RequestParam(value = "id",defaultValue = "")Integer id, @RequestParam(value = "name",defaultValue = "")String name, @RequestParam(value = "logoUrl",defaultValue = "")String logoUrl){
        model.addAttribute("name",name);
        model.addAttribute("id",id);
        model.addAttribute("logoUrl",logoUrl);
        return "updateBrand";
    }
    @RequestMapping(value = "/valid/updateBrandreslt",method = RequestMethod.POST)
    @ResponseBody
    public String updateBrandreslt(@RequestParam(value = "id",defaultValue = "")Integer id,@RequestParam(value = "name",defaultValue = "")String name, @RequestParam(value = "image",defaultValue = "") MultipartFile mf){

        String logoUrl = ImageFloadUtils.imageUpload(mf);
        System.out.println(logoUrl);
        if (logoUrl.equals("url")){ return "2"; }
       boolean b = brandManagerService.updateCarBrandById(name,logoUrl,id);
        return b? "1":"2";
    }
    @RequestMapping(value = "/valid/delBrand",method = RequestMethod.POST)
    @ResponseBody
    public String delBrand( @RequestParam(value = "id",defaultValue = "0")Integer id){
        boolean b = brandManagerService.deleteCarBrand(id);
        return b? "1":"2";
    }
    @RequestMapping(value = "/valid/addBrandreslt",method = RequestMethod.POST)
    @ResponseBody
    public Object addBrandreslt(@RequestParam(value = "brandName",defaultValue = "")String brandName,@RequestParam(value = "image",defaultValue = "") MultipartFile mf){
        String logoUrl = ImageFloadUtils.imageUpload(mf);
        if (logoUrl.equals("url")){ return "2"; }
        boolean b =  brandManagerService.addCarBrand(brandName,logoUrl);
        return b?"1":"2";
    }
}
