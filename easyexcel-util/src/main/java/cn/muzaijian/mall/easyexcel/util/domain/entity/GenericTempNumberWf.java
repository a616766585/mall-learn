package cn.muzaijian.mall.easyexcel.util.domain.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 一次性编码配置表
 *
 * @author lijian01
 * @date 2024/02/23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenericTempNumberWf {

    @ExcelProperty("零部件类型")
    public String componentType;

    @ExcelProperty("分类")
    public String classification;

    @ExcelProperty("系统属性+IBA属性")
    public String iba;

    @ExcelProperty("Data Group Review(数据组审查)")
    public String dataGroupReview;

    @ExcelProperty("Check(经理审核)")
    public String managerReview;

    @ExcelProperty("Standardize(数据组)")
    public String dataGroup;

    @ExcelProperty("Proofread(校对)")
    public String proofread;

    @ExcelProperty("Standardize(标准化)")
    public String standardize;

    @ExcelProperty("Check(审核)")
    public String check;

    @ExcelProperty("CounterSignature(会签)")
    public String counterSignature;

}
