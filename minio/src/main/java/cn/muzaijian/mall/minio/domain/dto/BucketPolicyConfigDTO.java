package cn.muzaijian.mall.minio.domain.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * MinIO 存储桶策略 DTO
 * </p>
 *
 * @author muzaijian
 * @date 2021/7/30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class BucketPolicyConfigDTO implements Serializable {
    private String Version;
    private List<Statement> Statement;

    @Data
    @EqualsAndHashCode(callSuper = false)
    @Builder
    public static class Statement {
        private String Effect;
        private String Principal;
        private List<String> Action;
        private String Resource;
    }
}
