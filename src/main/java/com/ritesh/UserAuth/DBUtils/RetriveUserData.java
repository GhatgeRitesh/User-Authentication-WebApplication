package com.ritesh.UserAuth.DBUtils;

import com.ritesh.UserAuth.Entity.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
@Log
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
      if(user == null || dataSource == null)
      {
          log.warning("User Entity or dataSource Empty ");
      }
      try{
          JdbcTemplate temp=new JdbcTemplate(dataSource);
          String query="Select Id , Name from register where Email=?";
          temp.queryForObject(query,new Object[]{user.getEmail_Id()},(resultSet,rowNum)->{
              user.setId(resultSet.getLong("Id"));
              user.setName(resultSet.getString("Name"));
              return null;
          });
      }catch(Exception e){
          log.warning("Sql Exception:"+e);
          return;
      }
    }

}
