package cn.muzaijian.mall.minio.manager;

import cn.muzaijian.mall.minio.domain.vo.MinioUploadVO;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * Minio 通用业务处理类
 * </p>
 *
 * @author muzaijian
 * @date 2021/7/28
 */
public interface MinioManager {

    /**
     * 文件上传
     *
     * @param file 上传的文件
     * @return MinIO 文件上传结果 VO
     */
    MinioUploadVO upload(MultipartFile file);

    /**
     * 文件删除
     *
     * @param objectName 文件所在存储桶的完整路径与名称
     * @return 文件删除结果
     */
    boolean delete(String objectName);
}
