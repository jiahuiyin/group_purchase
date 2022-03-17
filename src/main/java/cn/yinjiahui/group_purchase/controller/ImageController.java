package cn.yinjiahui.group_purchase.controller;

import cn.yinjiahui.group_purchase.common.Result;
import cn.yinjiahui.group_purchase.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/image")
public class ImageController {

    @Autowired
    ImageService imageService;

    @PostMapping("/upload")
    public Result uploadImage(@RequestParam("image") MultipartFile image){
        if (image.isEmpty()) {
            return Result.fail();
        }
        try {
            String uri = imageService.uploadImage(image);
            Map map=new HashMap<>() {
                {
                    put("uri",uri );
                }
            };
            return Result.success(map);
        } catch (Exception e) {
            log.error("上传图片错误",e);
            return Result.fail();
        }
    }
}
