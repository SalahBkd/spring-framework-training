package com.salahbkd.todoapp.dao;

import com.salahbkd.todoapp.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
}
