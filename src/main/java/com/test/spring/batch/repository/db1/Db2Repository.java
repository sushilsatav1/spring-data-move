package com.test.spring.batch.repository.db1;

import com.test.spring.batch.entity.LetterHistDb2;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Db2Repository extends PagingAndSortingRepository<LetterHistDb2,String> {

    //
//    Page<LetterHistDb2> findAll( Pageable pageable);

}
