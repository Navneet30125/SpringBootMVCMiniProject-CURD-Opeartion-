package com.nav.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nav.entity.DoctorEntity;

public interface IDoctorRepository extends JpaRepository<DoctorEntity, Integer> {

}
