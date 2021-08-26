package cn.muzaijian.mall.minio.manager.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import cn.muzaijian.mall.admin.domain.dto.BucketPolicyConfigDTO;
import cn.muzaijian.mall.admin.domain.vo.MinioUploadVO;
import cn.muzaijian.mall.minio.manager.MinioManager;
import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.ObjectWriteArgs;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import io.minio.SetBucketPolicyArgs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 * Minio 通用业务处理实现类
 * </p>
 *
 * @author muzaijian
 * @date 2021/7/30
 */
@Service
@Slf4j
public class MinioManagerImpl implements MinioManager {

    @Value("${minio.endpoint}")
    private String endpoint;
    @Value("${minio.bucketName}")
    private String bucketName;
    @Value("${minio.accessKey}")
    private String accessKey;
    @Value("${minio.secretKey}")
    private String secretKey;

    @Override
    public MinioUploadVO upload(MultipartFile file) {
        String filename = file.getOriginalFilename();
        try {
            // 创建 MinIO 的 Java 客户端
            MinioClient minioClient = MinioClient.builder()
                    .endpoint(endpoint)
                    .credentials(accessKey, secretKey)
                    .build();
            boolean isExist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if (isExist) {
                log.info("{} 存储桶已经存在。", bucketName);
            } else {
                // 创建存储桶并设置只读权限
                MakeBucketArgs makeBucketArgs = MakeBucketArgs.builder()
                        .bucket(bucketName)
                        .build();
                minioClient.makeBucket(makeBucketArgs);
                BucketPolicyConfigDTO bucketPolicyConfigDTO = initBucketPolicyConfigDTO(bucketName);
                SetBucketPolicyArgs setBucketPolicyArgs = SetBucketPolicyArgs.builder()
                        .bucket(bucketName)
                        .config(JSONUtil.toJsonStr(bucketPolicyConfigDTO))
                        .build();
                minioClient.setBucketPolicy(setBucketPolicyArgs);
            }
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
            // 设置存储对象名称
            String objectName = dtf.format(LocalDate.now()) + "/" + System.currentTimeMillis() + "_" + filename;
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object(objectName)
                    .contentType(file.getContentType())
                    .stream(file.getInputStream(), file.getSize(), ObjectWriteArgs.MIN_MULTIPART_SIZE)
                    .build();
            minioClient.putObject(putObjectArgs);
            log.info("{} 文件上传成功。", filename);
            return MinioUploadVO.builder()
                    .name(filename)
                    .url(endpoint + "/" + bucketName + "/" + objectName)
                    .build();
        } catch (Exception e) {
            log.warn("{} 文件上传发生错误： {}", filename, e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(String objectName) {
        try {
            // 创建 MinIO 的 Java 客户端
            MinioClient minioClient = MinioClient.builder()
                    .endpoint(endpoint)
                    .credentials(accessKey, secretKey)
                    .build();
            RemoveObjectArgs removeObjectArgs = RemoveObjectArgs.builder()
                    .bucket(bucketName)
                    .object(objectName)
                    .build();
            minioClient.removeObject(removeObjectArgs);
            log.info("{} 文件删除成功。", objectName);
            return true;
        } catch (Exception e) {
            log.warn("{} 文件删除发生错误： {}", objectName, e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据存储桶名称初始化存储桶策略
     *
     * @param bucketName 存储桶名称
     * @return MinIO 存储桶策略 DTO
     */
    private BucketPolicyConfigDTO initBucketPolicyConfigDTO(String bucketName) {
        BucketPolicyConfigDTO.Statement statement = BucketPolicyConfigDTO.Statement.builder()
                .Effect("Allow")
                .Principal("*")
                .Action(CollUtil.toList("s3:GetObject"))
                .Resource("arn:aws:s3:::" + bucketName + "/*")
                .build();
        return BucketPolicyConfigDTO.builder()
                .Version("2012-10-17")
                .Statement(CollUtil.toList(statement))
                .build();
    }
}
