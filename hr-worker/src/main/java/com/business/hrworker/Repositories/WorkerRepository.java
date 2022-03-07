package com.business.hrworker.Repositories;

import com.business.hrworker.Entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
