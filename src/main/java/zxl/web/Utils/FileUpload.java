package zxl.web.Utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.MultipartFile;

public class FileUpload {

    /*
     *图片上传工具类
     */
    public static String upload(HttpServletRequest request, MultipartFile file, String path) throws IOException {
        String fileName = file.getOriginalFilename();
        fileName=UUID.randomUUID()+fileName.substring(fileName.indexOf("."),fileName.length());
        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thumbnails.of(path+"\\"+fileName).size(548, 350).toFile(path+"\\"+fileName);
        return fileName;
    }

}
