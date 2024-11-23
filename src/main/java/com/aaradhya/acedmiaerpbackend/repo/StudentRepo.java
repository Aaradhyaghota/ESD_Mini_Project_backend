package com.aaradhya.acedmiaerpbackend.repo;

import com.aaradhya.acedmiaerpbackend.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepo extends JpaRepository<Students, Integer> {
    @Query("SELECT s.rollNumber FROM Students s WHERE s.domain.domainId = :domainId AND s.graduationYear = :batchYear ORDER BY s.rollNumber DESC LIMIT 1")
    String findLastRollNumberByDomainAndBatch(@Param("domainId") int domainId, @Param("batchYear") int batchYear);

}
