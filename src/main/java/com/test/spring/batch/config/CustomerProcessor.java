package com.test.spring.batch.config;

import com.test.spring.batch.entity.LetterHistDb2;
import com.test.spring.batch.entity.LetterHistDest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomerProcessor implements ItemProcessor<LetterHistDb2, LetterHistDest> {

    @Override
    public LetterHistDest process(LetterHistDb2 letterHistDb2) {
        System.out.println("MyBatchProcessor : Processing data : "+letterHistDb2);
     log.info("MyBatchProcessor : Processing data : "+letterHistDb2);

        LetterHistDest letterHistDest = new LetterHistDest();
        letterHistDest.setAcctKey(Integer.valueOf(letterHistDb2.getAcctNbr()));
        letterHistDest.setLetterVersion(letterHistDb2.getLtrVer());
        letterHistDest.setLetterId(letterHistDb2.getLetterId());
        letterHistDest.setLetterSentDt(letterHistDb2.getLetterSentDt());

            return letterHistDest;

    }
}
