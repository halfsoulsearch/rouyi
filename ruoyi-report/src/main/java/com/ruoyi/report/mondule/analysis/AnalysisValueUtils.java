package com.ruoyi.report.mondule.analysis;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wzh
 * @date 2021年05月12日 9:13
 */
public class AnalysisValueUtils {
    public static String getTodayValueText(List<Map> list, long shiftId, long colId, long rowId) {
        for (Map map : list) {
            if (map == null) {
                continue;
            }
            long sId = ((Integer) map.get("shift_id")).longValue();
            long cId = ((Integer) map.get("col_id")).longValue();
            long rId = ((Integer) map.get("row_id")).longValue();

            if (map.containsKey("value_text")) {
                if (sId == shiftId
                        && cId == colId
                        && rId == rowId) {
                    return (String) map.get("value_text");
                }
            } else {
                return "";
            }

        }
        return "";
    }

    public static double getTodayValue(List<Map> list, long shiftId, long colId, long rowId) {
        for (Map map : list) {
            if (map == null) {
                continue;
            }
            long sId = ((Integer) map.get("shift_id")).longValue();
            long cId = ((Integer) map.get("col_id")).longValue();
            long rId = ((Integer) map.get("row_id")).longValue();

            if (map.containsKey("today_value_number")) {
                if (sId == shiftId
                        && cId == colId
                        && rId == rowId) {
                    return ((BigDecimal) map.get("today_value_number")).doubleValue();
                }
            } else {
                return 0;
            }

        }
        return 0;
    }

    public static double getTotalValue(List<Map> list, long shiftId, long colId, long rowId) {
        for (Map map : list) {
            if (map == null) {
                continue;
            }
            long sId = ((Integer) map.get("shift_id")).longValue();
            long cId = ((Integer) map.get("col_id")).longValue();
            long rId = ((Integer) map.get("row_id")).longValue();

            if (map.containsKey("month_value_number")) {
                if (sId == shiftId
                        && cId == colId
                        && rId == rowId) {
                    return getDouble((String) map.get("month_value_number"));
                }
            } else {
                return 0;
            }
        }
        return 0;
    }


    private static double getDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            return 0;
        }
    }

}
