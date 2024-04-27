package com.ritesh.UserAuth.DBUtils;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Log
public class Validate_UserName {
    // code for the validating the similar User Names Present into the databases
    @Autowired
    private final DataSource dataSource;

    public Validate_UserName(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public boolean validate_Name(String Name){
         log.info("Scanning Name");

         JdbcTemplate temp=new JdbcTemplate(dataSource);

        String sql = "SELECT CASE WHEN EXISTS (SELECT 1 FROM userlist WHERE Name = ?) THEN 1 ELSE 0 END";
        Integer result = temp.queryForObject(sql, new Object[]{Name}, Integer.class);
        log.info("the query result for Name Validation : "+result );
        return result != 0;
    }
}
