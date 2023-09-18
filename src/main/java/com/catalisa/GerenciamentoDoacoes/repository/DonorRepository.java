package com.catalisa.GerenciamentoDoacoes.repository;

import com.catalisa.GerenciamentoDoacoes.model.DonorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DonorRepository extends JpaRepository<DonorModel, Long> {
  Optional<DonorModel> findByName(String name);
  Optional<DonorModel> findByEmail(String email);
}
