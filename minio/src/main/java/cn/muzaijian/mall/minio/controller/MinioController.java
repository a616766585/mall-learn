package cn.muzaijian.mall.minio.controller;

import cn.muzaijian.mall.admin.manager.MinioManager;
import cn.muzaijian.mall.common.api.CommonResult;
import cn.muzaijian.mall.common.util.CommonResultUtil;
import cn.muzaijian.mall.minio.domain.vo.MinioUploadVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * Minio 对象存储 前端控制器
 * </p>
 *
 * @author muzaijian
 * @date 2021/7/23
 */
@RestController
@RequestMapping("/minio")
public class MinioController {

    @Autowired
    MinioManager minioManager;

    /**
     * 文件上传
     *
     * @param file 上传的文件
     * @return MinIO 文件上传结果 VO
     */
    @PostMapping
    public MinioUploadVO upload(@RequestParam("file") MultipartFile file) {
        return minioManager.upload(file);
    }

    @ApiOperation("文件删除")
    @DeleteMapping
    public CommonResult delete(@RequestParam String objectName) {
        boolean result = minioManager.delete(objectName);
        return CommonResultUtil.booleanReturn(result);
    }

}
