package com.gmail.pratsaunik.ied;


import com.gmail.pratsaunik.pojo.IED;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    ProductCatalogService productCatalogService;

    @RequestMapping(method = RequestMethod.GET)
    public String showCatalog(Model model) {
       List<IED> items= productCatalogService.getAllIED();
       model.addAttribute("items",items);

    return "catalogPage";
    }

}
