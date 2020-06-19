package com.gmail.pratsaunik.ied;

import com.gmail.pratsaunik.pojo.CurrentSensor;
import com.gmail.pratsaunik.pojo.IED;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.logging.Logger;

@Controller
@RequestMapping("/add/sensor")
public class AddSensorController {

    private static Logger log = Logger.getLogger("AddIEDController");

    @Autowired
    SCADAService scadaService;

    @Autowired
    IEDValidator validator;

    @GetMapping
    public String showAddSensorPage(@RequestParam Long deviceId, Model model) {
        model.addAttribute("deviceId",deviceId);
        return "addSensorPage";
    }

    @PostMapping
    public String addNewProduct(
            @ModelAttribute("item")CurrentSensor currentSensor,

            @RequestParam("deviceId")Long deviceId,
            BindingResult result,
            Model model) throws IOException {
        log.info("New sensor: " + currentSensor);
/*        validator.validate(currentSensor, result);
        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "addPage";
        }
        */
        model.addAttribute("deviceId",deviceId);
        if (currentSensor != null) {
            scadaService.saveNewSensor(currentSensor,deviceId);
            return "redirect:/product/item/{deviceId}";
        }

        return "error";
    }

}