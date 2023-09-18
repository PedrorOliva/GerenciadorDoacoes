package com.catalisa.GerenciamentoDoacoes.repository;

import com.catalisa.GerenciamentoDoacoes.model.DonationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<DonationModel, Long> {

}
