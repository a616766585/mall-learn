package cn.muzaijian.mall.mapstruct.convert;

import cn.muzaijian.mall.mapstruct.domain.dto.PmsBrandItemDTO;
import cn.muzaijian.mall.mapstruct.mbg.entity.PmsBrand;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * <p>
 * 商品品牌 转换 Demo Two
 * </p>
 *
 * @author muzaijian
 * @date 2021/7/13
 */
@Mapper
public interface PmsBrandConvertDemoTwo {

    PmsBrandConvertDemoTwo INSTANCE = Mappers.getMapper(PmsBrandConvertDemoTwo.class);

    /**
     * 商品品牌 ItemDTO 转换商品品牌 entity
     *
     * @param brandItemDTO 商品品牌 ItemDTO
     * @return 商品品牌 entity
     */
    @Mapping(source = "bigPicture", target = "bigPic")
    PmsBrand convert(PmsBrandItemDTO brandItemDTO);
}
