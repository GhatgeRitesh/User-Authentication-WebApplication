package com.ritesh.UserAuth.DBUtils;

import com.ritesh.UserAuth.Model.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
@Log
public class Validate_Name {
    // code to verify the userName available or Not

    @Autowired
    private final User user;
    @Autowired
    private final DataSource dataSource;

    public Validate_Name(User user, DataSource dataSource) {
        this.user = user;
        this.dataSource = dataSource;
    }

    public Boolean isNameAvailable()
    {
        if(user==null)
        {
            log.info("User Entity is Empty");
            return false;
        }
        try {
            JdbcTemplate temp = new JdbcTemplate(dataSource);
            String sql = "SELECT EXISTS (SELECT 1 FROM register WHERE name = ?)";
            return temp.queryForObject(sql, Boolean.class, user.getName());
        }
        catch(Exception e){
        log.warning("Sql Exceptrion :"+e);
        return false;
    }
    }
}
