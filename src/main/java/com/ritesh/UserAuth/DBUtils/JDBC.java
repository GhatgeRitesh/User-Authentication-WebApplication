package com.ritesh.UserAuth.DBUtils;

import com.ritesh.UserAuth.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.SQLException;


@Repository
@Service
public class JDBC {
    private final User user;

    @Autowired
    public JDBC(User user) {
        this.user = user;

    }

   public void connection(){
//       System.out.println(dataSource.toString());
       System.out.println("all clear"+ user.getName());
   }
//
//     //code to insert the User Data
//    public String save(User user) {
//        if(user!=null) {
//            System.out.println("user info -->" + user.getName());
//            String query2 = "INSERT INTO userlist (Name, email, password) VALUES (?, ?, ?)";
//            jdbcTemplate.update(query2,user.getName(),user.getEmail_Id(),user.getPassword());
//        }
//        else{
//            System.out.println("user has the null input");
//        }
//        return "redirect:/Login";
//    }
}

