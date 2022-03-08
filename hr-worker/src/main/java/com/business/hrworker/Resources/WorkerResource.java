package com.business.hrworker.Resources;


import com.business.hrworker.Entities.Worker;
import com.business.hrworker.Services.WorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping( value = "/v1/workers")
public class WorkerResource {

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    @Autowired
    private Environment env;

    private WorkerService service;

    public WorkerResource(WorkerService service) {
        this.service = service;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Worker> findAll() {
        return service.getList();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public Worker findById(@PathVariable  Long id) {
        logger.info("PORT = " + env.getProperty("local.server.port"));
        return service.getId(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Worker save(@PathVariable Worker worker) {
        return service.save(worker);
    }

}
