package com.test.spring.batch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "letter_hist_dest")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LetterHistDest {
    @Id
    @Column(name = "acct_key")
    private Integer acctKey;
    @Column(name = "letter_id")
    private String letterId;
    @Column(name = "letter_sent_dt")
    private LocalDate letterSentDt;
    @Column(name = "letter_version")
    private String letterVersion;
}
