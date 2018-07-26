package com.ots.voteservice.service;

import com.ots.voteservice.dto.OptionsDto;
import com.ots.voteservice.entity.Options;
import com.ots.voteservice.repository.OptionsRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OptionsServiceTest {

    @Autowired
    private OptionsService optionsService;

    @Autowired
    private OptionsRepository optionsRepository;

    @Before
    public void clearBefore(){
        clearDatabase();
    }

    @After
    public void clearAfter() {
        clearDatabase();
    }

    @Test
    public void clearDatabase() {
        optionsRepository.deleteAll();
    }

    @Test
    public void saveOptions1() {
        String link = "http://localhost:8090/";
        String method = "OPTIONS";
        String description = "get REST API OPTIONS";

        Options options = new Options(link, method, description);

        optionsRepository.save(options);

        List<Options> results = (List<Options>) optionsRepository.findAll();

        assertEquals(results.size(), 1);
        assertEquals(results.get(0).getLink(),link );
        assertEquals(results.get(0).getMethod(),method );
        assertEquals(results.get(0).getDescription(),description );


        clearDatabase();
    }


    @Test
    public void saveOptions2() {
        String[] link = {"http://localhost:8090/", "http://localhost:8090/rest/voting/create"};
        String[] method = {"OPTIONS", "POST"};
        String[] description = {"get REST API OPTIONS", "generate voting JSON and send HTTP-request for create voting"};

        Options options1 = new Options(link[0], method[0], description[0]);
        Options options2 = new Options(link[1], method[1], description[1]);

        optionsRepository.save(options1);
        optionsRepository.save(options2);


        List<Options> results = (List<Options>) optionsRepository.findAll();

        assertEquals(results.size(), 2);
        assertEquals(results.get(0).getLink(),link[0] );
        assertEquals(results.get(0).getMethod(),method[0] );
        assertEquals(results.get(0).getDescription(),description[0] );

        assertEquals(results.get(1).getLink(),link[1] );
        assertEquals(results.get(1).getMethod(),method[1] );
        assertEquals(results.get(1).getDescription(),description[1] );


        clearDatabase();
    }


    @Test
    public void getOptionsDto() {
        String[] link = {"http://localhost:8090/", "http://localhost:8090/rest/voting/create"};
        String[] method = {"OPTIONS", "POST"};
        String[] description = {"get REST API OPTIONS", "generate voting JSON and send HTTP-request for create voting"};

        Options options1 = new Options(link[0], method[0], description[0]);
        Options options2 = new Options(link[1], method[1], description[1]);

        optionsRepository.save(options1);
        optionsRepository.save(options2);


        List<OptionsDto> optionsDtoList = optionsService.getOptionsDto();

        assertEquals(optionsDtoList.size(), 2);

        assertEquals(optionsDtoList.get(0).getLink(), link[0]);
        assertEquals(optionsDtoList.get(0).getMethod(), method[0]);
        assertEquals(optionsDtoList.get(0).getDescription(), description[0]);

        assertEquals(optionsDtoList.get(1).getLink(), link[1]);
        assertEquals(optionsDtoList.get(1).getMethod(), method[1]);
        assertEquals(optionsDtoList.get(1).getDescription(), description[1]);


        clearDatabase();
    }

}
