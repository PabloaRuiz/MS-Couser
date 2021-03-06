package com.business.hrpayroll.FeignClients;

import com.business.hrpayroll.Entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker", path = "v1/workers")
public interface WorkerFeignClient {

    @GetMapping(value = "/{id}")
    public Worker findById(@PathVariable Long id);


}
