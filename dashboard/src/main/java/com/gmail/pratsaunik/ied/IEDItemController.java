package com.gmail.pratsaunik.ied;


import com.gmail.pratsaunik.pojo.CurrentSensor;
import com.gmail.pratsaunik.pojo.IED;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/product")
public class IEDItemController {
    @Autowired
    ProductCatalogService productCatalogService;


    @GetMapping("/item/{id}")
    public String showIEDItem(@PathVariable Long id, Model model){
        IED productItem = productCatalogService.getIED(id);
        model.addAttribute("item",productItem);
        List<CurrentSensor> sensors =productItem.getCurrentSensorSet();
        model.addAttribute("sensors",sensors);
        return "productItemPage";
    }
/*
    @GetMapping("item/{id}/image")
    public @ResponseBody
    byte[] ShowProductImage(@PathVariable Long id){
        return productCatalogService.getProductItem(id).getPicture();
    }

    */
}


