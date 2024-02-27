package com.ritesh.UserAuth.DBUtils;

import com.ritesh.UserAuth.Model.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;

@Repository
@Service
@Log
public class JDBC {
    private final User user;
    private final DataSource dataSource;


    @Autowired
    public JDBC(User user, DataSource dataSource) {
        this.user = user;
        this.dataSource = dataSource;
    }

   public void connection(){
//       System.out.println(dataSource.toString());
       System.out.println("all clear"+ user.getName());
      // System.out.println("the datasource properties "+template.toString());

   }

     //code to insert the User Data
    public String save() {
        JdbcTemplate template=new JdbcTemplate(dataSource);
        if(user!=null) {
            System.out.println("user info -->" + user.getName());
            String query2 = "INSERT INTO userlist(Name, email, password) VALUES (?, ?, ?)";
            template.update(query2,user.getName(),user.getEmail_Id(),user.getPassword());
            System.out.println("Sccessfully saved");
        }
        else{
            System.out.println("user has the null input");
        }
        return "redirect:/Login";
    }
//----------------------------------method to verify the input from the login page--------------------------------------
    public Boolean verify() {
        JdbcTemplate template=new JdbcTemplate(dataSource);
        if(user!=null) {
            String userEmail = null;
            String userPassword = null;
            log.info("verification started");
            String query = "Select email from userlist where email =?  ";
            try {
                userEmail = template.queryForObject(query, String.class, user.getEmail_Id());
            } catch (EmptyResultDataAccessException e) {
                log.info("No email found");
                System.out.println(e);
                return false;
            }
            try {
                String query2 = "SELECT password FROM userlist WHERE email=?";
                userPassword = template.queryForObject(query2, String.class, userEmail);
            }
            catch(EmptyResultDataAccessException e){
                log.info("Password not found");
                return false;
            }
                if (userPassword != user.getPassword()) {
                    log.info("Incorrect Password");
                    return false;
                } else
                    return true;
            }

      return true;
    }
}

