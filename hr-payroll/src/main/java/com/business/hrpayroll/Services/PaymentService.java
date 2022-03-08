package com.business.hrpayroll.Services;


import com.business.hrpayroll.Entities.Payment;
import com.business.hrpayroll.Entities.Worker;
import com.business.hrpayroll.FeignClients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;


@Service
public class PaymentService {


    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long WorkerId, BigDecimal days) {

        Worker worker = workerFeignClient.findById(WorkerId);

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
