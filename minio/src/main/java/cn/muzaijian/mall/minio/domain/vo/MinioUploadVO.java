package cn.muzaijian.mall.minio.domain.vo;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * MinIO 文件上传结果 VO
 * </p>
 *
 * @author muzaijian
 * @date 2021/7/30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class MinioUploadVO {

    /**
     * 文件访问 url
     */
    private String url;

    /**
     * 文件名称
     */
    private String name;
}
