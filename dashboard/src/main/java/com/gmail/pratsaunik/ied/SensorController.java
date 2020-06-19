package com.gmail.pratsaunik.ied;


import com.gmail.pratsaunik.pojo.CurrentSensor;
import com.gmail.pratsaunik.pojo.IED;
import com.gmail.pratsaunik.pojo.SensorValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sensor")
public class SensorController {
    @Autowired
    ProductCatalogService productCatalogService;


    @GetMapping("/item/{id}")
    public String showIEDItem(@PathVariable Long id, Model model){
        CurrentSensor currentSensor = productCatalogService.getSensorById(id);
        List<SensorValue> sensorValues=productCatalogService.getSensorValues(id,20);
        model.addAttribute("item",currentSensor);
        model.addAttribute("values", sensorValues);
        return "sensorPage";
    }
/*
    @GetMapping("item/{id}/image")
    public @ResponseBody
    byte[] ShowProductImage(@PathVariable Long id){
        return productCatalogService.getProductItem(id).getPicture();
    }

    */
}


