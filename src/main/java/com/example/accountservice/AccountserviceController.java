package com.example.accountservice;

import com.example.model.AccountDTO;
import com.example.model.MessageDTO;
import com.example.model.StatisticDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/account")
public class AccountserviceController {
    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping("/new")
    public AccountDTO create(@RequestBody AccountDTO account) {
        StatisticDTO stat = new StatisticDTO( new Date(), "Account" + account.getEmail() + " is created");

        //send notification
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setTo(account.getEmail());
        messageDTO.setToName(account.getName());
        messageDTO.setSubject("Hello Word");
        messageDTO.setContent("I am online!");

        kafkaTemplate.send("notification", messageDTO);
        kafkaTemplate.send("statistic", stat);
        return account;
    }
}
