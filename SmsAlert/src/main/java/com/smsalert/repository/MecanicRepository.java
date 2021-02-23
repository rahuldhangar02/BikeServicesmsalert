package com.smsalert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smsalert.model.Mecanic;
@Repository
public interface MecanicRepository extends JpaRepository<Mecanic,Integer> {

}
