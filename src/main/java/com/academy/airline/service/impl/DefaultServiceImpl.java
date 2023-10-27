package com.academy.airline.service.impl;

import com.academy.airline.service.DefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class DefaultServiceImpl<T, I> implements DefaultService<T, I> {
    JpaRepository<T,I> repository;

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public T getById(I id) {
        return repository.getReferenceById(id);
    }

    @Override
    public void remove(T entity) {
        repository.delete(entity);
    }

    @Override
    public void save(T entity) {
        repository.saveAndFlush(entity);
    }

    @Override
    public void saveAll(List<T> entities) {
        repository.saveAllAndFlush(entities);
    }

    @Override
    public void removeSelected(List<T> entities) {
        repository.deleteAll(entities);
    }
}
