package com.ritesh.UserAuth.DBUtils;

import com.ritesh.UserAuth.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;



@Repository
@Service
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
            System.out.println("SUccessfully saved");
        }
        else{
            System.out.println("user has the null input");
        }
        return "redirect:/Login";
    }
}

