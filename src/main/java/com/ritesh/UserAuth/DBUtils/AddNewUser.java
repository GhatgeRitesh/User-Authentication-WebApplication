package com.ritesh.UserAuth.DBUtils;

import com.ritesh.UserAuth.Model.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;


@Repository
@Log
public class AddNewUser {
    // code to add new user in db
    @Autowired
    private final User user;
    @Autowired
    private final DataSource dataSource;

    public AddNewUser(User user, DataSource dataSource) {
        this.user = user;
        this.dataSource = dataSource;
    }

    public Boolean save()
    {
        if(user == null || dataSource== null)
        {
            log.warning("User Entity or dataSource is empty");
            return false;
        }
        try {
            JdbcTemplate temp = new JdbcTemplate(dataSource);
            String query = "INSERT INTO register(Id,Name,Email,Password) VALUES(?,?,?,?)";
            temp.update(query, user.getId(), user.getName(), user.getEmail_Id(), user.getPassword());
            return true;
        }
        catch(Exception e){
            log.warning("Sql Exceptrion :"+e);
            return false;
        }
    }
}
