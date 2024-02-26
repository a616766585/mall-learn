package cn.muzaijian.mall.easyexcel.util.util;

import cn.muzaijian.mall.easyexcel.util.domain.entity.GenericNumberNewWf;
import cn.muzaijian.mall.easyexcel.util.domain.entity.GenericNumberStandardize;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;

import java.util.Comparator;
import java.util.List;

/**
 * 编码申请配置表工具
 *
 * @author lijian01
 * @date 2024/02/23
 */
public class GenericNumberNewWfConfigUtil {

    public static void main(String[] args) {
        var fileName = "Generic_Number_New_WF.xlsx";
        EasyExcel.read(fileName, GenericNumberNewWf.class, new PageReadListener<GenericNumberNewWf>(dataList -> {
            mergeGenericNumberNewWf(dataList);
            CommonUtil.sort(dataList, Comparator.nullsLast(Comparator.comparing(GenericNumberNewWf::getStandardize, Comparator.nullsLast(String::compareTo))));
            EasyExcel.write(fileName, GenericNumberNewWf.class).registerWriteHandler(CommonUtil.lastRowStyle(dataList.size())).sheet("DEFAULT").doWrite(dataList);
        }, 5000)).sheet().doRead();
    }

    /**
     * 合并编码申请配置表
     *
     * @param genericNumberNewWfs 需合并编码申请配置表
     */
    public static void mergeGenericNumberNewWf(List<GenericNumberNewWf> genericNumberNewWfs) {
        var fileName = "编码申请分类处理人对应表.xlsx";
        EasyExcel.read(fileName, GenericNumberStandardize.class, new PageReadListener<GenericNumberStandardize>(dataList -> {
            outer:
            for (var genericNumberStandardize : dataList) {
                for (var genericNumberNewWf : genericNumberNewWfs) {
                    if (!"部件".equals(genericNumberNewWf.componentType)) {
                        continue;
                    }
                    // --- 更新 ---
                    if (genericNumberNewWf.iba.contains(genericNumberStandardize.subClassificationValue)) {
                        genericNumberNewWf.standardize = "Y U:" + genericNumberStandardize.standardizeNumber;
                        continue outer;
                    }
                }
                // --- 插入 ---
                var genericNumberNewWf = GenericNumberNewWf.builder()
                        .componentType("部件")
                        .iba("Classification=" + genericNumberStandardize.subClassificationValue)
                        .dataGroupReview("Y R:DesignDataEngineer")
                        .standardize("Y U:" + genericNumberStandardize.standardizeNumber)
                        .proofread("Y R:SeniorEngineer")
                        .check("Y R:ImmediateSupervisor,R:DepartmentManager")
                        .build();
                genericNumberNewWfs.add(genericNumberNewWf);
            }
        }, 5000)).sheet("分类对应标准化审核").doRead();
    }


}
