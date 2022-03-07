package com.business.hrworker.Entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tb_worker")
public class Worker implements Serializable {
    private static final long serialVersionUID=1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal dailyIncome;
}
