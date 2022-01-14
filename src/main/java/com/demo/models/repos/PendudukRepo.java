package com.demo.models.repos;

import com.demo.models.Penduduk;

import org.springframework.data.repository.CrudRepository;

public interface PendudukRepo extends CrudRepository<Penduduk, Long> {
    
}
