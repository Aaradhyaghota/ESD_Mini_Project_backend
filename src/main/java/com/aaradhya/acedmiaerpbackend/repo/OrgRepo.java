package com.aaradhya.acedmiaerpbackend.repo;

import com.aaradhya.acedmiaerpbackend.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrgRepo extends JpaRepository<Organization, Integer> {
}
