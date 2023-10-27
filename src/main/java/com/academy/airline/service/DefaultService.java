package com.academy.airline.service;

import java.util.List;

public interface DefaultService <T, I> {
    List<T> getAll();
    T getById(I id);
    void remove(T entity);
    void save(T entity);
    void saveAll(List<T> entities);
    void removeSelected(List<T> entities);
}
