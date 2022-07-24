package com.test.spring.batch.repository.db1;

import com.test.spring.batch.entity.LetterHistDb2;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Db2Repository extends PagingAndSortingRepository<LetterHistDb2,String> {
}
