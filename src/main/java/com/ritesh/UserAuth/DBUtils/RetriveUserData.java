package com.ritesh.UserAuth.DBUtils;

import com.ritesh.UserAuth.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class RetriveUserData {
    // code to retrive the user data while in use
    @Autowired
    private final User user;
    @Autowired
    private final DataSource dataSource;

    public RetriveUserData(User user, DataSource dataSource) {
        this.user = user;
        this.dataSource = dataSource;
    }

    public void getData()
    {

    }

}
