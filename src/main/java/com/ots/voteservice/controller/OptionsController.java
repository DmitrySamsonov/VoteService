package com.ots.voteservice.controller;

import com.ots.voteservice.dto.OptionsDto;
import com.ots.voteservice.service.OptionsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class OptionsController {

    @Autowired
    private OptionsService optionsService;

    @RequestMapping(method = RequestMethod.OPTIONS)
    public List<OptionsDto> getOptionsDto() {
        return optionsService.getOptionsDto();
    }

}
