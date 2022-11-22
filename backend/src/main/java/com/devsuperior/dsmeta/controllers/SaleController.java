package com.devsuperior.dsmeta.controllers;


import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;
import com.devsuperior.dsmeta.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

//import java.awt.print.Pageable;
import java.util.List;
//TWILIO_KEY=114a6d4d598090a372ea210b1b4fc6ae;TWILIO_PHONE_FROM=+14793338614;TWILIO_PHONE_TO=+5551995228122;TWILIO_SID=ACc3e03ebce2f528d438a560557c754624
@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @Autowired
    private SmsService smsService;
    @GetMapping
    public Page<Sale> findSales(
            @RequestParam(value="minDate", defaultValue = "") String minDate,
            @RequestParam(value="maxDate", defaultValue = "") String maxDate,
            Pageable pageable){
        return service.findSales(minDate, maxDate, pageable);

    }
    @GetMapping("/{id}/notification")
    public void notifySms(@PathVariable Long id) {
        smsService.sendSms(id);

    }

}
