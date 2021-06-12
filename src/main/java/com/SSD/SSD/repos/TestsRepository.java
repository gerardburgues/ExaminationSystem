package com.SSD.SSD.repos;

import com.SSD.SSD.model.Tests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestsRepository extends JpaRepository<Tests, Integer> {
}
