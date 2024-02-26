package cn.muzaijian.mall.easyexcel.util.util;

import cn.muzaijian.mall.easyexcel.util.domain.entity.GenericNumberStandardize;
import cn.muzaijian.mall.easyexcel.util.domain.entity.GenericTempNumberWf;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;

import java.util.Comparator;
import java.util.List;

/**
 * 一次性编码配置表工具
 *
 * @author lijian01
 * @date 2024/02/23
 */
public class GenericTempNumberWfConfigUtil {

    public static void main(String[] args) {
        var fileName = "Generic_Temp_Number_WF.xlsx";
        EasyExcel.read(fileName, GenericTempNumberWf.class, new PageReadListener<GenericTempNumberWf>(dataList -> {
            mergeGenericTempNumberWf(dataList);
            CommonUtil.sort(dataList, Comparator.nullsLast(Comparator.comparing(GenericTempNumberWf::getStandardize, Comparator.nullsLast(String::compareTo))));
            EasyExcel.write(fileName, GenericTempNumberWf.class).registerWriteHandler(CommonUtil.lastRowStyle(dataList.size())).sheet("DEFAULT").doWrite(dataList);
        }, 5000)).sheet().doRead();
    }

    /**
     * 合并一次性编码配置表
     *
     * @param genericTempNumberWfs 需合并一次性编码配置表
     */
    public static void mergeGenericTempNumberWf(List<GenericTempNumberWf> genericTempNumberWfs) {
        var fileName = "编码申请分类处理人对应表.xlsx";
        EasyExcel.read(fileName, GenericNumberStandardize.class, new PageReadListener<GenericNumberStandardize>(dataList -> {
            outer:
            for (var genericNumberStandardize : dataList) {
                for (var genericTempNumberWf : genericTempNumberWfs) {
                    if (!"部件".equals(genericTempNumberWf.componentType)) {
                        continue;
                    }
                    // --- 更新 ---
                    if (genericTempNumberWf.iba.contains(genericNumberStandardize.subClassificationValue)) {
                        genericTempNumberWf.standardize = "Y U:" + genericNumberStandardize.standardizeNumber;
                        continue outer;
                    }
                }
                // --- 插入 ---
                var genericTempNumberWf = GenericTempNumberWf.builder()
                        .componentType("部件")
                        .iba("Classification=" + genericNumberStandardize.subClassificationValue)
                        .dataGroupReview("Y R:DesignDataEngineer")
                        .proofread("Y R:SeniorEngineer")
                        .standardize("Y U:" + genericNumberStandardize.standardizeNumber)
                        .check("Y R:ImmediateSupervisor,R:DepartmentManager")
                        .build();
                genericTempNumberWfs.add(genericTempNumberWf);
            }
        }, 5000)).sheet("分类对应标准化审核").doRead();
    }
}
