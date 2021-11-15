package com.projeto_p2.farmacia.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface ControllerInterfaces<T> {

	ResponseEntity<List<T>> getAll();
	ResponseEntity<?> get(Long id);
	ResponseEntity<T> post(T obj);
	ResponseEntity<?> put(T obj);
	ResponseEntity<?> delete(Long id);
}
