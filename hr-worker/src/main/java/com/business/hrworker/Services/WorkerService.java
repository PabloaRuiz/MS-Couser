package com.business.hrworker.Services;

import com.business.hrworker.Entities.Worker;
import com.business.hrworker.Repositories.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    private WorkerRepository repository;

    public WorkerService(WorkerRepository repository) {
        this.repository = repository;
    }

    public List<Worker> getList() {
        List<Worker> list = repository.findAll();
        return list;
    }

    public Optional<Worker> getId(Long id) {
        return this.repository.findById(id);
    }

    public Worker save(Worker worker) {
        return repository.save(worker);
    }
}
