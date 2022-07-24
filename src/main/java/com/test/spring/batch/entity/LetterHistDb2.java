package com.test.spring.batch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "letter_hist_db2")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
public class LetterHistDb2 {
    @Id
    @Column(name = "acct_nbr")
    private String acctNbr;
    @Column(name = "letter_id")
    private String letterId;
    @Column(name = "letter_sent_dt")
    private LocalDate letterSentDt;
    @Column(name = "ltr_ver")
    private String ltrVer;


}
