package edu.ecnu.tobacco_display.controller;

import edu.ecnu.tobacco_display.utils.FileUploadUtils;
import edu.ecnu.tobacco_display.utils.JsonData;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Objects;

@RestController
@RequestMapping("/images")
@Api(tags = "图片上传下载")
public class ImageController {
    /**
     *
     * @param file 要上传的文件
     * @return
     */
    @PostMapping("imageUpload")
    public JsonData imageUpload(@RequestParam("fileName") MultipartFile file){

        // 要上传的目标文件存放路径
        String localPath = Objects.requireNonNull(Objects.requireNonNull(ClassUtils.getDefaultClassLoader()).getResource("")).getPath();
        if (FileUploadUtils.upload(file, localPath, file.getOriginalFilename())){
            // 上传成功，给出页面提示
            return JsonData.buildSuccess("上传成功！"+file.getOriginalFilename());
        }else {
            return JsonData.buildError("上传失败！" + file.getOriginalFilename());
        }
    }
    @GetMapping("/imageDownload")
    public String imageDownload(HttpServletResponse response, @RequestParam("fileName") String fileName){
        String path = Objects.requireNonNull(Objects.requireNonNull(ClassUtils.getDefaultClassLoader()).getResource("")).getPath();
        File file = new File(path +'/'+ fileName);
        if(!file.exists()){
            return "下载文件不存在";
        }
        response.reset();
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName );

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));) {
            byte[] buff = new byte[1024];
            OutputStream os  = response.getOutputStream();
            int i = 0;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
            return "下载失败";
        }
        return "下载成功";
    }
    @GetMapping("imageDelete")
    public JsonData imageDelete(String filename) throws FileNotFoundException {
        filename = filename.replaceAll("../", "");
        String staticPath = Objects.requireNonNull(Objects.requireNonNull(ClassUtils.getDefaultClassLoader()).getResource("")).getPath();

//        System.out.println(filename);
        File file = new File(staticPath+"/static/"+filename);
        //判断文件不为null或文件目录存在
        if (!file.exists()){
            return JsonData.buildError("文件不存在");
        }
        file.delete();
        return JsonData.buildSuccess("删除成功");
    }
}
