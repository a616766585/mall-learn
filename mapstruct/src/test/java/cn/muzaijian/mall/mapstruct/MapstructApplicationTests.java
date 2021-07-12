package cn.muzaijian.mall.mapstruct;

import cn.muzaijian.mall.mapstruct.convert.PmsBrandConvert;
import cn.muzaijian.mall.mapstruct.domain.dto.PmsBrandItemDTO;
import cn.muzaijian.mall.mapstruct.mbg.entity.PmsBrand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MapstructApplicationTests {

    @Autowired
    private PmsBrandConvert brandConvert;

    @Test
    void contextLoads() {
    }

    @Test
    void testMapStruct() {
        PmsBrandItemDTO brandItemDTO = new PmsBrandItemDTO();
        brandItemDTO.setBigPic("11111");
        brandItemDTO.setBrandStory("22222");
        brandItemDTO.setLogo("33333");
        PmsBrand brand = brandConvert.convert(brandItemDTO);
        System.out.println(brand);
    }
}
