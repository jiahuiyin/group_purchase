package cn.yinjiahui.group_purchase.service.impl;

import cn.yinjiahui.group_purchase.service.ImageService;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.qiniu.common.QiniuException;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.DownloadUrl;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;

import java.util.UUID;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {
    @Value("${qiniu.accessKey}")
    private String accessKey;
    @Value("${qiniu.secretKey}")
    private String secretKey;
    private String bucket="yinjh";
    @Override
    public String uploadImage(MultipartFile file) throws Exception {
        Configuration cfg = new Configuration(Region.huanan());

        UploadManager uploadManager = new UploadManager(cfg);

        String filename=file.getOriginalFilename();
        filename= UUID.randomUUID()+filename.substring(filename.lastIndexOf("."));

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        uploadManager.put(file.getBytes(), filename, upToken);
        return filename;
    }
}
