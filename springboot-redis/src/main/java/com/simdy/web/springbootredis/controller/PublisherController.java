package com.simdy.web.springbootredis.controller;

import com.simdy.web.springbootredis.service.ProducerService;
import com.simdy.web.springbootredis.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author simdy
 * @time 2019/8/13
 */

@RestController
@RequestMapping("/publisher")
public class PublisherController {
    @Autowired
    private ProducerService producerService;
    @Autowired
    private ReceiverService receiverService;

    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    public String sendMessage(@PathVariable("name") String name) {
        return producerService.sendMessage(name);
    }


    @RequestMapping(value = "/get",method =RequestMethod.GET )
    public String getMessage() {
        return receiverService.getMessage();
    }

}
