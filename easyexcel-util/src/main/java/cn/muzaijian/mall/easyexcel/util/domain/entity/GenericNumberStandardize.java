package cn.muzaijian.mall.easyexcel.util.domain.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 编码申请标准化审批人对应表
 *
 * @author lijian01
 * @date 2024/02/23
 */
@Data
public class GenericNumberStandardize {

    @ExcelProperty("USB分类")
    public String usbClassification;

    @ExcelProperty("SAP物料组")
    public String sapMaterialGroup;

    @ExcelProperty("PLM中分类")
    public String plmClassification;

    @ExcelProperty("PLM小分类")
    public String plmSubClassification;

    @ExcelProperty("小类内部值")
    public String subClassificationValue;

    @ExcelProperty("标准化审核人")
    public String standardize;

    @ExcelProperty("标准化审核人工号")
    public String standardizeNumber;

}
