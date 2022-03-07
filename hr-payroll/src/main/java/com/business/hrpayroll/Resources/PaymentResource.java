package com.business.hrpayroll.Resources;


import com.business.hrpayroll.Entities.Payment;
import com.business.hrpayroll.Services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/v1/payments")
public class PaymentResource {

    private PaymentService service;

    public PaymentResource(PaymentService service) {
        this.service = service;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{workedId}/days/{days}")
    public Payment getPayment(@PathVariable Long workedId, @PathVariable BigDecimal days) {
        Payment payment = service.getPayment(workedId, days);
        return payment;

    }
}
