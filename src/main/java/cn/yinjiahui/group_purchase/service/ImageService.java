package cn.yinjiahui.group_purchase.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

    String uploadImage(MultipartFile file) throws Exception;
}
