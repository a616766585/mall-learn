package cn.muzaijian.mall.mapstruct.convert;

import cn.muzaijian.mall.mapstruct.domain.dto.PmsBrandItemDTO;
import cn.muzaijian.mall.mapstruct.mbg.entity.PmsBrand;
import org.mapstruct.Mapper;

/**
 * <p>
 * 商品品牌 转换
 * </p>
 *
 * @author muzaijian
 * @date 2021/7/12
 */
@Mapper(componentModel = "spring")
public interface PmsBrandConvert {

    /**
     * 商品品牌 ItemDTO 转换商品品牌 entity
     *
     * @param brandItemDTO 商品品牌 ItemDTO
     * @return 商品品牌 entity
     */
    PmsBrand convert(PmsBrandItemDTO brandItemDTO);

}
