package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardConfig {

    @Bean
    public Board getBoard() {
        return new Board(toDoList(), inProgressList(), doneList());
    }

    @Bean(name = "taskList1")
    public TaskList toDoList() {
        return new TaskList();
    }

    @Bean(name = "taskList2")
    public TaskList inProgressList() {
        return new TaskList();
    }

    @Bean(name = "taskList3")
    public TaskList doneList() {
        return new TaskList();
    }
}
