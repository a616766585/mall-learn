package cn.muzaijian.mall.mapstruct;

import cn.muzaijian.mall.mapstruct.convert.PmsBrandConvertDemoOne;
import cn.muzaijian.mall.mapstruct.convert.PmsBrandConvertDemoTwo;
import cn.muzaijian.mall.mapstruct.domain.dto.PmsBrandItemDTO;
import cn.muzaijian.mall.mapstruct.mbg.entity.PmsBrand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MapstructApplicationTests {

    @Autowired
    private PmsBrandConvertDemoOne brandConvertDemoOne;

    @Test
    void testMapStructDemoOne() {
        PmsBrandItemDTO brandItemDTO = new PmsBrandItemDTO();
        brandItemDTO.setBigPicture("picture");
        brandItemDTO.setBrandStory("阿里云故事");
        brandItemDTO.setLogo("阿里云 logo");
        PmsBrand brand = brandConvertDemoOne.convert(brandItemDTO);
        System.out.println(brand);
    }

    @Test
    void testMapStructDemoTwo() {
        PmsBrandItemDTO brandItemDTO = new PmsBrandItemDTO();
        brandItemDTO.setBigPicture("picture");
        brandItemDTO.setBrandStory("腾讯云故事");
        brandItemDTO.setLogo("腾讯云 logo");
        PmsBrand brand = PmsBrandConvertDemoTwo.INSTANCE.convert(brandItemDTO);
        System.out.println(brand);
    }

}
