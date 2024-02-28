package com.ritesh.UserAuth.DBUtils;

import com.ritesh.UserAuth.Model.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
@Service
@Log
public class JDBC {
    private final User user;
    private final DataSource dataSource;

    private List<String> result=new ArrayList<>();// result set for the email validation (already register)
    @Autowired
    public JDBC(User user, DataSource dataSource) {
        this.user = user;
        this.dataSource = dataSource;
    }

//----------------------------------------------------------------------------------------------------------------------
      // code for the user already register
    public Boolean validate(){
        JdbcTemplate template =new JdbcTemplate(dataSource);
        if(user!=null)
        {
            log.info("validating the user presence");
            String query="SELECT DISTINCT CASE WHEN email = ? THEN 'Email_Already Exists' WHEN Name = ? THEN 'Username' ELSE 'None' END AS conflict_type FROM userlist WHERE email = ? OR Name = ?";
            List<String> queryParameters = new ArrayList<>();
            queryParameters.add(user.getEmail_Id());
            queryParameters.add(user.getName());
            queryParameters.add(user.getEmail_Id());
            queryParameters.add(user.getName());
            try {
                result = template.queryForList(query, queryParameters.toArray(), String.class);
            }catch (Exception e){
                System.out.println(e +"exception while validation in JDBC" );
            }
            if(result!=null)
            {
                return false;
            }
        }
        return true;
    }

//----------------------------------------------------------------------------------------------------------------------
     //code to insert the User Data
    public Boolean save() {
//--------------------------this code specifies the sql exception as email or name already in use ------------------------------------------------
        boolean flag=validate();
        if(!flag){
            log.info("email or user should be changed");
            System.out.println(result.toString());
            return false;
        }
//---------------------------------------------------------------------------------------------------------------------
        JdbcTemplate template=new JdbcTemplate(dataSource);
        if(user!=null) {
            System.out.println("user info -->" + user.getName());
            String query2 = "INSERT  INTO userlist(Name, email, password) VALUES (?, ?, ?)";
            try {
                template.update(query2,user.getName(),user.getEmail_Id(),user.getPassword());
            }catch(Exception e){
                System.out.println(e);
                System.out.println("exception while saving info ");
                return false;
            }
            System.out.println("Sccessfully saved");
        }
        else{
            System.out.println("user has the null input");
        }
        return false;
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
//-------------------------------------------------END OF CLASS---------------------------------------------------------
}

