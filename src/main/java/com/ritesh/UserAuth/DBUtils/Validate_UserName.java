package com.ritesh.UserAuth.DBUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class Validate_UserName {
    // code for the validating the similar User Names Present into the databases
    @Autowired
    private final DataSource dataSource;

    public Validate_UserName(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public boolean validate_Name(String Name){
         JdbcTemplate temp=new JdbcTemplate(dataSource);

        String sql = "SELECT EXISTS(SELECT 1 FROM your_table_name WHERE Name LIKE ?)";
        Integer result = temp.queryForObject(sql, new Object[]{ "%" + Name + "%" }, Integer.class);
        return result != null && result == 1;
    }
}
