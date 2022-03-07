package com.business.hrpayroll.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {
    private static final long serialVersionUID = 1l;

    private String name;
    private BigDecimal dailyIncome;
    private BigDecimal days;


    public BigDecimal getTotal() {
        return days.multiply(dailyIncome);
    }

}
