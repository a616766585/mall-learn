package cn.muzaijian.mall.mapstruct.mbg.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 商品品牌
 * </p>
 *
 * @author muzaijian
 * @since 2021-07-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PmsBrand implements Serializable {


    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 首字母
     */
    private String firstLetter;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否为制造商品牌：0->不是；1->是
     */
    private Integer factoryStatus;

    /**
     * 是否进行显示：0->不显示；1->显示
     */
    private Integer showStatus;

    /**
     * 商品数量
     */
    private Integer productCount;

    /**
     * 商品评论数量
     */
    private Integer productCommentCount;

    /**
     * 品牌 logo
     */
    private String logo;

    /**
     * 专区大图
     */
    private String bigPic;

    /**
     * 品牌故事
     */
    private String brandStory;


}
