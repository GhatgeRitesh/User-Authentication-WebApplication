package com.ritesh.UserAuth.DBUtils;

import com.ritesh.UserAuth.Entity.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
@Log
public class ResetPassword {
    // code for reseting the password
    @Autowired
    private final User user;
    @Autowired
    private final DataSource dataSource;

    public ResetPassword(User user, DataSource dataSource){
        this.user=user;
        this.dataSource=dataSource;
    }
    public boolean setpassword(){
        JdbcTemplate temp=new JdbcTemplate(dataSource);
        String query="Update  register set password = ? where Name = ? ";
        try{
            int rowsUpdated = temp.update(query, user.getPassword(), user.getName());

            // Check if any rows were updated
            if (rowsUpdated > 0) {
                log.info("Password updated successfully for user: ");
            } else {
                log.info("No user found with username: ");
                return false;
            }
        } catch(Exception e){
             log.warning(" exception :"+ e);
             return false;
        }
        return true;
    }
}
