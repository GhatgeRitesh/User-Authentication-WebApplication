package com.ritesh.UserAuth.Upload;

import com.ritesh.UserAuth.Entity.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
@Log
public class ProfileImageUpload {
    //code to upload and use profile for the user
    @Autowired
    private final User user;
    @Value("${file.base.directory}")
    private String baseDir;

    public ProfileImageUpload(User user) {
        this.user = user;
    }
    public Boolean UploadImage()
    {
        String FilePath=baseDir+ File.separator+user.getId()+File.separator+"Images";
        File file=new File(FilePath);
        if(!file.exists())
        {
            log.warning("User File System Does not Exists");
            return false;
        }
        try{
            String fileName=user.getFileName();
            String tempdir=FilePath+File.separator+fileName;
            MultipartFile Image=user.getFile();
            Files.write(Path.of(tempdir),Image.getBytes());
        }catch(Exception e)
        {
            log.warning("Exception while uploading file :"+e);
            return false;
        }
        return true;
    }
}
