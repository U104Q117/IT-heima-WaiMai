package com.sky.controller.admin;

import com.sky.constant.MessageConstant;
import com.sky.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 通用接口
 */
@RestController
@RequestMapping("/admin/common")
@Slf4j
public class CommonController {

    /**
     * 文件上傳
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file)  {
        log.info("文件上傳",file);

        try {
            //獲取原始文件名
            String originalFilename = file.getOriginalFilename();
            //新的文件名
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFileName = UUID.randomUUID().toString()+extension;
            //保存文件名
            file.transferTo(new File("D:/images/"+newFileName));
            return Result.success("D:/images/"+newFileName);
        } catch (IOException e) {
            log.info("文件上傳失敗:{}",e);
        }
        return Result.error(MessageConstant.UPLOAD_FAILED);
    }
}
