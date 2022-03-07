package com.business.hrpayroll.Entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Worker implements Serializable {
    private static final long serialVersionUID=1l;


    private Long id;
    private String name;
    private BigDecimal dailyIncome;
}
