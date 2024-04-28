package com.ritesh.UserAuth.Upload;

import com.ritesh.UserAuth.Entity.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
@Log
public class NewUserFileSystem {
    // code to create the file system for new User

    @Value("${file.base.directory}")
    private String baseDir;

    @Autowired
    private final User user;

    public NewUserFileSystem(User user) {
        this.user = user;
    }

    public boolean createFolder() throws IOException
    {
        if(user==null)
        {
            log.warning("user is null");
            return false;
        }
        String UserPath=baseDir+ File.separator+user.getId();
        File UserFolder=new File(UserPath);
        if(!UserFolder.exists())
        {
            UserFolder.mkdirs();
            String[] folders={"Images","Videos","Files.jsp"};
            for(String folds:folders)
            {
                File subs=new File(baseDir+File.separator+user.getId()+File.separator+folds);
                subs.mkdirs();
            }
        }
        else{
            log.info("UserId Folder Already Present : ");
            return false;
        }
        return true;
    }
}
