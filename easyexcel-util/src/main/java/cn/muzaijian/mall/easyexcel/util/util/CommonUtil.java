package cn.muzaijian.mall.easyexcel.util.util;

import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 通用工具
 *
 * @author lijian01
 * @date 2024/02/23
 */
public class CommonUtil {
    /**
     * 最后一行样式
     *
     * @param size 除去标题行的数据行数
     * @return {@link HorizontalCellStyleStrategy} 横向单元格样式策略
     */
    public static HorizontalCellStyleStrategy lastRowStyle(int size) {
        // --- 表格的内容样式 ---
        var contentWriteCellStyle = new WriteCellStyle();

        // --- 表格最后一行样式 ---
        var lastRowStyle = new WriteCellStyle();
        // 这里需要指定 FillPatternType 为FillPatternType.SOLID_FOREGROUND 不然无法显示背景颜色.头默认了 FillPatternType所以可以不指定
        lastRowStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
        // 背景红色
        lastRowStyle.setFillForegroundColor(IndexedColors.RED.getIndex());

        // --- 设置内容样式 ---
        var contentWriteCellStyles = new ArrayList<WriteCellStyle>();
        for (int i = 0; i < size - 1; i++) {
            contentWriteCellStyles.add(contentWriteCellStyle);
        }

        // --- 设置最后一行样式 ---
        contentWriteCellStyles.add(lastRowStyle);

        return new HorizontalCellStyleStrategy(new WriteCellStyle(), contentWriteCellStyles);
    }

    /**
     * 通用排序方法
     *
     * @param list       待排序列表
     * @param comparator 比较器
     */
    public static <T> void sort(List<T> list, Comparator<? super T> comparator) {
        // --- 提取前三个元素 ---
        List<T> firstThreeElements = new ArrayList<>(list.subList(0, Math.min(3, list.size())));

        // --- 对剩下的元素进行排序 ---
        List<T> remainingElements = new ArrayList<>(list.subList(3, list.size()));
        remainingElements.sort(comparator);

        // --- 将排序完成的剩余元素插入到原来位置 ---
        list.clear();
        list.addAll(firstThreeElements);
        list.addAll(remainingElements);
    }

}
