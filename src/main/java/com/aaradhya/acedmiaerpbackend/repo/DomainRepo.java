package com.aaradhya.acedmiaerpbackend.repo;

import com.aaradhya.acedmiaerpbackend.entity.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainRepo extends JpaRepository<Domain, Integer> {
}