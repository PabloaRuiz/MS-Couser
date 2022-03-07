package com.business.hrpayroll.Services;


import com.business.hrpayroll.Entities.Payment;
import com.business.hrpayroll.Entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;


    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(long WorkerId, BigDecimal days) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", ""+WorkerId);

        Worker worker = restTemplate.getForObject(
                workerHost + "/v1/workers/{id}",
                Worker.class,
                uriVariables
        );

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
