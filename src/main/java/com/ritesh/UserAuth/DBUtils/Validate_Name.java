package com.ritesh.UserAuth.DBUtils;

import com.ritesh.UserAuth.Entity.User;
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
            String query = "SELECT COUNT(*) FROM register WHERE Name=? OR Email=?";
            int count = temp.queryForObject(query, Integer.class, user.getName(), user.getEmail_Id());
            return count==0;
        }
        catch(Exception e){
        log.warning("Sql Exceptrion :"+e.getMessage());
        return false;
    }
    }
}
