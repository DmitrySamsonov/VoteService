package com.ots.voteservice.service;

import com.ots.voteservice.dto.OptionsDto;
import com.ots.voteservice.entity.Options;
import com.ots.voteservice.repository.OptionsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OptionsService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OptionsRepository optionsRepository;


    public List<OptionsDto> getOptionsDto() {
        List<Options> optionsList = (List<Options>) optionsRepository.findAll();

        List<OptionsDto> optionsDtoList = new ArrayList<>();
        for (Options options : optionsList) {
            OptionsDto optionsDto = modelMapper.map(options, OptionsDto.class);
            optionsDtoList.add(optionsDto);
        }

        return optionsDtoList;
    }
}
