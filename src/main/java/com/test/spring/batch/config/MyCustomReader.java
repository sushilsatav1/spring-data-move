//package com.test.spring.batch.config;
//
//
//   import java.sql.ResultSet;
//import java.sql.SQLException;
//   import java.time.LocalDate;
//
//   import javax.sql.DataSource;
//
//   import com.test.spring.batch.entity.LetterHistDb2;
//   import lombok.extern.slf4j.Slf4j;
//   import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.database.JdbcCursorItemReader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Component;
//
//
//
//    @Component
//    @Slf4j
//    public class MyCustomReader extends JdbcCursorItemReader<LetterHistDb2> implements ItemReader<LetterHistDb2>{
//
//        public MyCustomReader(@Autowired DataSource primaryDataSource) {
//            log.info("sushil");
//            setDataSource(primaryDataSource);
//            setSql("SELECT acct_nbr, letter_id, letter_sent_dt, ltr_ver FROM ssmysqldb.letter_hist_db2");
//            setFetchSize(100);
//            setRowMapper(new EmployeeRowMapper());
//
//        }
//
//        public class EmployeeRowMapper implements RowMapper<LetterHistDb2> {
//            @Override
//            public LetterHistDb2 mapRow(ResultSet rs, int rowNum) throws SQLException {
//                LetterHistDb2 employee  = new LetterHistDb2();
////                log.info("sushil"+ rs.toString());
//                employee.setLetterId(rs.getString("letter_id"));
//                employee.setAcctNbr(rs.getString("acctNbr"));
//
//                employee.setLetterSentDt(LocalDate.parse(rs.getString("letter_sent_dt")));
//
//                employee.setLtrVer(rs.getString("ltr_ver"));
//                return employee;
//            }
//        }
//    }
//
