package com.jeanpaul.exampleshop.schedulings;

import com.jeanpaul.exampleshop.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OrderSchedule {

    private final Logger log = LoggerFactory.getLogger(OrderSchedule.class);

    @Autowired
    OrderService orderService;

    @Scheduled(cron = "0 * * ? * *")
    public void scheduleOrders(){
        orderService.updateState(5);
    }
}
