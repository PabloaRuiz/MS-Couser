package com.business.hrworker.Service;


import com.business.hrworker.Entities.Worker;
import com.business.hrworker.Repositories.WorkerRepository;
import com.business.hrworker.Services.WorkerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class WorkerServiceTest {

    WorkerService service;

    @MockBean
    WorkerRepository repository;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
        this.service = new WorkerService(repository);
    }



    @Test
    @DisplayName("Trazer um trabalhador por id")
    void WorkerGet() {
        Long id = 1l;
        Worker worker = new Worker(null, "Salgadinho", new BigDecimal(250.0));
        worker.setId(id);

        Mockito.when(repository.findById(id))
                .thenReturn(Optional.of(worker));

        Optional<Worker> FindWorker = service.getId(id);

        Assertions.assertThat(FindWorker.isPresent()).isTrue();
        Assertions.assertThat(FindWorker.get().getId()).isEqualTo(id);
        Assertions.assertThat(FindWorker.get().getName()).isEqualTo(worker.getName());
        Assertions.assertThat(FindWorker.get().getDailyIncome()).isEqualTo(worker.getDailyIncome());

    }

    @Test
    @DisplayName("Trazer uma lista de trabalador")
    void WorkerList() {
        Long id = 1l;
        Worker worker = new Worker(null, "Salgadinho", new BigDecimal(250.0));
        worker.setId(id);

        Mockito.when(repository.findAll())
                .thenReturn(List.of(worker));

        List<Worker> ListWorker = service.getList();

        Assertions.assertThat(ListWorker).isNotEmpty();
    }


    @Test
    @DisplayName("Salvar um trabalhador")
    void WorkerSave() {
        Long id = 1l;
        Worker worker = new Worker(null, "Salgadinho", new BigDecimal(250.0));
        worker.setId(id);

        Mockito.when(repository.save(worker))
                .thenReturn(worker);

        Worker SaveWorker = service.save(worker);

        Assertions.assertThat(SaveWorker.getId()).isEqualTo(id);
        Assertions.assertThat(SaveWorker.getName()).isEqualTo(worker.getName());
        Assertions.assertThat(SaveWorker.getDailyIncome()).isEqualTo(worker.getDailyIncome());
    }


}
