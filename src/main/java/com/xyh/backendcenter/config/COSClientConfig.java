package com.xyh.backendcenter.config;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import com.xyh.backendcenter.exception.BackendException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Component
public class COSClientConfig {

    @Value("${cos.client.secretId}")
    private String secretId;

    @Value("${cos.client.secretKey}")
    private String secretKey;

    @Value("${cos.client.region}")
    private String region;

    @Value("${cos.client.bucket}")
    private String bucket;

    public COSClient createCOSClient() {
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.setRegion(new Region(region));
        clientConfig.setHttpProtocol(HttpProtocol.https);
        return new COSClient(cred, clientConfig);
    }

    /**
     * 上传文件
     *
     * @param file 文件
     * @return 返回文件路径
     */
    public String uploadFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new BackendException(500, "请选择要上传的文件");
        }
        String originalFilename = file.getOriginalFilename();
        COSClient cosClient = createCOSClient();
        String bucketName = bucket;
        DateTime date = DateUtil.date();
        String format = DateUtil.format(date, "yyyy/MM/dd/");
        //存储路径
        String key = "backend-center/" + format + originalFilename;
        try {
            InputStream inputStream = file.getInputStream();
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, inputStream, null);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            //获取服务器文件地址
            URL url = cosClient.generatePresignedUrl(bucketName, key, null);
            String fileUrl = url.toString();
            int endIndex = fileUrl.indexOf("?"); // 找到问号的位置作为截取的结束位置
            String imgUrl = fileUrl.substring(0, endIndex);
            return imgUrl;
        } catch (CosServiceException e) {
            throw new BackendException(e.getStatusCode(), e.getErrorMessage());
        } catch (IOException e) {
            throw new BackendException(500, "文件上传异常");
        } finally {
            cosClient.shutdown();
        }
    }
}
