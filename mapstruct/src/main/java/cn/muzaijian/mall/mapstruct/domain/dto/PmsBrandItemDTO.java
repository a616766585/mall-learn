package cn.muzaijian.mall.mapstruct.domain.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 品牌 DTO
 * </p>
 *
 * @author muzaijian
 * @date 2021/2/26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PmsBrandItemDTO implements Serializable {

    private String name;

    private String firstLetter;

    private Integer sort;

    private Integer factoryStatus;

    private Integer showStatus;

    private String logo;

    private String bigPicture;

    private String brandStory;
}
