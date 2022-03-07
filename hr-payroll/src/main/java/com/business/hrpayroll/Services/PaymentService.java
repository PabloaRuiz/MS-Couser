package com.business.hrpayroll.Services;


import com.business.hrpayroll.Entities.Payment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {

    public Payment getPayment(long WorkerId, BigDecimal days) {
        return new Payment("Bob", new BigDecimal(100.00), days);
    }
}
