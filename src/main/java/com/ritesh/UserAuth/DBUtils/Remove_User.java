package com.ritesh.UserAuth.DBUtils;

import com.ritesh.UserAuth.Entity.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
@Log
public class Remove_User {
    //code to delete the account
    @Autowired
    private final User user;
    @Autowired
    private final DataSource dataSource;
    @Autowired
    private final Verify_User verifyUser;
    public  Remove_User(User user, DataSource dataSource, Verify_User verifyUser){
        this.user=user;
        this.dataSource = dataSource;
        this.verifyUser = verifyUser;
    }

    public Boolean deleteUser()
    {
        // verify the password
        if(!verifyUser.verifyUser())
        {
            log.info("invalid password ");
            return false;
        }
        if(user == null || dataSource == null)
        {
            log.warning("Entity or dataSource is Empty");
            return false;
        }
        try{
            JdbcTemplate temp=new JdbcTemplate(dataSource);
            String query="delete from  register where Email=?";
            temp.update(query,user.getEmail_Id());
            log.info("User Deleted Successfully");
            return true;
        }catch(Exception e){
            log.warning("sql Exception :" +e);
            return false;
        }
    }
}
