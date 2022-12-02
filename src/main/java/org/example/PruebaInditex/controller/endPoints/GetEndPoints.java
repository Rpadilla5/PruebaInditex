package org.example.PruebaInditex.controller.endPoints;


import org.example.PruebaInditex.application.services.PricesService;
import org.example.PruebaInditex.controller.dto.PricesDto;
import org.example.PruebaInditex.domain.exceptions.BadDateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/prices/")
public class GetEndPoints {

    @Autowired
    PricesService pricesService;

    @GetMapping(path = "/date/{date}")
    public ResponseEntity<?> getByDate(@PathVariable(name = "date") String date) {
        try {
            List<PricesDto> pricesDto = pricesService.getByDate(date);
            return new ResponseEntity<>(pricesDto,HttpStatus.OK);
        } catch (BadDateException e) {
            return new ResponseEntity<>("The date format is wrong", HttpStatus.BAD_REQUEST);
        }
    }
}
