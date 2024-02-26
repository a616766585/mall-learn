package cn.muzaijian.mall.easyexcel.util.domain.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 编码申请配置表
 *
 * @author lijian01
 * @date 2024/02/23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenericNumberNewWf {

    @ExcelProperty("零部件类型")
    public String componentType;

    @ExcelProperty("分类")
    public String classification;

    @ExcelProperty("系统属性+IBA属性")
    public String iba;

    @ExcelProperty("Data Group Review(数据组审查)")
    public String dataGroupReview;

    @ExcelProperty("Standardize(标准化)")
    public String standardize;

    @ExcelProperty("Proofread(校对)")
    public String proofread;

    @ExcelProperty("Check(审核)")
    public String check;

    @ExcelProperty("会签")
    public String counterSignature;

    @ExcelProperty("Notice(通知)")
    public String notice;
}
