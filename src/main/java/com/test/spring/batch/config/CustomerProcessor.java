package com.test.spring.batch.config;

import com.test.spring.batch.entity.LetterHistDb2;
import com.test.spring.batch.entity.LetterHistDest;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomerProcessor implements ItemProcessor<LetterHistDb2, LetterHistDest> {

    @Override
    public LetterHistDest process(LetterHistDb2 letterHistDb2) {
        System.out.println("MyBatchProcessor : Processing data : "+letterHistDb2);

        LetterHistDest letterHistDest = new LetterHistDest();
        letterHistDest.setAcctKey(Integer.valueOf(letterHistDb2.getAcctNbr()));
        letterHistDest.setLetterVersion(letterHistDb2.getLtrVer());
        letterHistDest.setLetterId(letterHistDb2.getLetterId());
        letterHistDest.setLetterSentDt(letterHistDb2.getLetterSentDt());

            return letterHistDest;

    }
}
