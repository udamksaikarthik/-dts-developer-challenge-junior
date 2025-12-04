// src/test/java/com/karthik/developerchallengejr/service/TaskServiceImplTest.java
package com.karthik.developerchallengejr;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.karthik.developerchallengejr.model.Task;
import com.karthik.developerchallengejr.repository.TaskRepository;
import com.karthik.developerchallengejr.service.TaskServiceImpl;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    @Test
    void createTask_savesTaskAndReturnsSavedEntity() {
        Task input = new Task();
        input.setTitle("Test Task");
        input.setDescription("Some description");
        input.setStatus("TODO");
        input.setDueDateTime(LocalDateTime.of(2025, 12, 31, 23, 0));

        Task saved = new Task();
        saved.setId(1L);
        saved.setTitle(input.getTitle());
        saved.setDescription(input.getDescription());
        saved.setStatus(input.getStatus());
        saved.setDueDateTime(input.getDueDateTime());

        when(taskRepository.save(any(Task.class))).thenReturn(saved);

        Task result = taskService.createTask(input);

        // verify repository called
        ArgumentCaptor<Task> captor = ArgumentCaptor.forClass(Task.class);
        verify(taskRepository).save(captor.capture());
        Task passedToRepo = captor.getValue();

        assertThat(passedToRepo.getTitle()).isEqualTo("Test Task");
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getStatus()).isEqualTo("TODO");
    }

    @Test
    void getAllTasks_returnsListFromRepository() {
        Task t1 = new Task();
        t1.setTitle("Task 1");
        Task t2 = new Task();
        t2.setTitle("Task 2");

        List<Task> repoList = new ArrayList<>();
        repoList.add(t1);
        repoList.add(t2);

        when(taskRepository.findAll()).thenReturn(repoList);

        ArrayList<Task> result = taskService.getAllTasks();

        verify(taskRepository).findAll();
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getTitle()).isEqualTo("Task 1");
    }
}
