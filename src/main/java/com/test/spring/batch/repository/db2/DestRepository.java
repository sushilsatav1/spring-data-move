package com.test.spring.batch.repository.db2;

import com.test.spring.batch.entity.LetterHistDest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface DestRepository extends JpaRepository<LetterHistDest,Integer> {
}
