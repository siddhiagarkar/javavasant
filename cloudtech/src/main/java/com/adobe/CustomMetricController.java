package com.adobe;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class CustomMetricController {
    @Autowired
    MeterRegistry meterRegistry;

    @GetMapping("/customMetric")
    public String createCustomMetric()
    {
        meterRegistry.counter("myapp_let_say_order_increment_counter").increment();
        meterRegistry.gauge("myapp_gauge_1_100", ((new Random().nextInt(100)+1)));
        return "yess success!";
    }


}
