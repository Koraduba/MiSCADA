package com.gmail.pratsaunik.ied;

import com.gmail.pratsaunik.pojo.CurrentSensor;
import com.gmail.pratsaunik.pojo.IED;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Set;
import java.util.logging.Logger;

@Controller
@RequestMapping("/add")
public class AddIEDController {

    private static Logger log = Logger.getLogger("AddIEDController");

    @Autowired
    SCADAService scadaService;

    @Autowired
    IEDValidator validator;

    @GetMapping
    public String showAddPage() {
        return "addPage";
    }

    @PostMapping("/ied")
    public String addNewProduct(
            @ModelAttribute("item") IED ied,
            BindingResult result,
            Model model) throws IOException {
        log.info("New ied: " + ied);
        validator.validate(ied, result);
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "addPage";
        }
        if (ied != null) {
            scadaService.saveNewProduct(ied);
            return "redirect:/";
        }

        return "error";
    }

}