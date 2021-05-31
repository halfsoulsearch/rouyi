package com.ruoyi.report.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.report.domain.*;
import com.ruoyi.report.domain.dto.*;
import com.ruoyi.report.mapper.*;
import com.ruoyi.report.service.IAssembleDataService;
import net.sf.jsqlparser.schema.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wzh
 * @date 2021年05月03日 11:38
 */
@Service
public class AssembleDataServiceImpl implements IAssembleDataService {
    public static final long INVALID_ID = -1L;

    @Autowired
    private DataBaseMapper dataBaseMapper;

    @Autowired
    private DataValueMapper dataValueMapper;

    @Autowired
    private ConfigMainTableMapper configMainTableMapper;

    @Autowired
    private ConfigSubTableMapper configSubTableMapper;

    @Autowired
    private ConfigSubTableColMapper configSubTableColMapper;

    @Autowired
    private ConfigSubTableRowMapper configSubTableRowMapper;

    @Autowired
    private ConfigShiftMapper configShiftMapper;

    @Autowired
    private ConfigIgnoreShiftMapper configIgnoreShiftMapper;

    @Override
    public DailyTableData preCreateTable(long mainTableId, String dateStr, long shiftId, long userId) {
        Date date;
        if (StringUtils.isEmpty(dateStr)) {
            date = getDate();
        } else {
            date = getDate(dateStr);
        }
        DailyTableData tableData = new DailyTableData();
        ConfigMainTable configMainTable = configMainTableMapper.selectConfigMainTableById(mainTableId);
        tableData.setTableId(configMainTable.getId());
        tableData.setTableName(configMainTable.getName());

        if (shiftId <= 0) {
            ConfigShift shift = new ConfigShift();
            shift.setMainTableId(mainTableId);
            List<ConfigShift> configShifts = configShiftMapper.selectConfigShiftList(shift);
            if (configShifts.size() > 0) {
                shiftId = configShifts.get(0).getId();
            }
        }

        ConfigIgnoreShift shiftIgnore = new ConfigIgnoreShift();
        shiftIgnore.setMaintableid(mainTableId);
        List<ConfigIgnoreShift> configIgnoreShifts = configIgnoreShiftMapper.selectConfigIgnoreShiftList(shiftIgnore);

        DataValue dataValue = new DataValue();
        dataValue.setMainTableId(mainTableId);
        dataValue.setDate(date);
        dataValue.setShiftId(shiftId);
        List<DataValue> dataValues = dataValueMapper.selectDataValueList(dataValue);

        CommonData commonData = new CommonData();

        DataBase temp = new DataBase();
        temp.setMainTableId(mainTableId);
        temp.setDate(date);
        List<DataBase> dataBases = dataBaseMapper.selectDataBaseList(temp);
        if (!dataBases.isEmpty()) {
            commonData.setId(dataBases.get(0).getId());
        }

        commonData.setDate(date);
        commonData.setStatus(CommonData.STATUS_CREATE);
        commonData.setShiftId(shiftId);
        commonData.setUserId(userId);
        commonData.setMainTableId(mainTableId);
        tableData.setCommonData(commonData);
        ConfigSubTable configSubTable = new ConfigSubTable();
        configSubTable.setMainTableId(mainTableId);
        List<BaseSubTableData> subTableDataList = new ArrayList<>();
        List<ConfigSubTable> configSubTables = configSubTableMapper.selectConfigSubTableList(configSubTable);
        for (ConfigSubTable subTable : configSubTables) {
            long subTableId = subTable.getId();
            ConfigSubTableCol configSubTableCol = new ConfigSubTableCol();
            configSubTableCol.setMainTableId(mainTableId);
            configSubTableCol.setSubTableId(subTableId);
            List<ConfigSubTableCol> configSubTableCols = configSubTableColMapper.selectConfigSubTableColList(configSubTableCol);
            ConfigSubTableRow configSubTableRow = new ConfigSubTableRow();
            configSubTableRow.setMainTableId(mainTableId);
            configSubTableRow.setSubTableId(subTableId);
            List<ConfigSubTableRow> configSubTableRows = configSubTableRowMapper.selectConfigSubTableRowList(configSubTableRow);
            if (configSubTableCols.size() > 0 && configSubTableRows.size() > 0) {
                SurfaceSubTableData subTableData = getHasDataSurfaceSubTableData(dataValues, subTable, shiftId, date, configSubTableCols, configSubTableRows, configIgnoreShifts);
                subTableDataList.add(subTableData);
            } else if (configSubTableCols.size() > 0) {
                LineSubTableData subTableData = getHasValueLineSubTableData(dataValues, subTable, shiftId, date, configSubTableCols, configIgnoreShifts);
                subTableDataList.add(subTableData);
            } else {
                PointSubTableData subTableData = getHasValuePontSubTableData(dataValues, subTable, shiftId, date, configIgnoreShifts);
                subTableDataList.add(subTableData);
            }
        }
        tableData.setSubTableDataList(subTableDataList);
        return tableData;
    }

    @Transactional
    @Override
    public void createOrUpdateTable(JSONObject data) {
        DataBase dataBase = getDataBase(data);
        if (dataBase.getId() == null || dataBase.getId() <= 0) {
            dataBaseMapper.insertDataBase(dataBase);
        } else {
            dataBase.setMainTableId(null);
            dataBase.setDate(null);
            dataBaseMapper.updateDataBase(dataBase);
        }
        List<DataValue> dataValues = getDataValueList(data);
        for (DataValue dataValue : dataValues) {
            if (dataValue.getId() == null) {
                dataValueMapper.insertDataValue(dataValue);
            } else {
                dataValueMapper.updateDataValue(dataValue);
            }
        }
    }

    @Override
    public DailyTableData getTableData(long baseTableId, long shiftId) {
        DataBase dataBase = dataBaseMapper.selectDataBaseById(baseTableId);
        if (dataBase == null) {
            return null;
        }

        Date date = dataBase.getDate();
        long mainTableId = dataBase.getMainTableId();
        DailyTableData tableData = new DailyTableData();
        ConfigMainTable configMainTable = configMainTableMapper.selectConfigMainTableById(mainTableId);
        tableData.setTableId(configMainTable.getId());
        tableData.setTableName(configMainTable.getName());
        CommonData commonData = new CommonData();
        commonData.setDate(date);
        commonData.setId(dataBase.getId());
        commonData.setStatus(dataBase.getStatus());
        commonData.setShiftId(shiftId);
        commonData.setUserId(dataBase.getRecordUserId());
        commonData.setMainTableId(mainTableId);
        tableData.setCommonData(commonData);

        if (shiftId <= 0) {
            ConfigShift shift = new ConfigShift();
            shift.setMainTableId(mainTableId);
            List<ConfigShift> configShifts = configShiftMapper.selectConfigShiftList(shift);
            if (configShifts.size() > 0) {
                shiftId = configShifts.get(0).getId();
            }
        }

        ConfigIgnoreShift shiftIgnore = new ConfigIgnoreShift();
        shiftIgnore.setMaintableid(mainTableId);
        List<ConfigIgnoreShift> configIgnoreShifts = configIgnoreShiftMapper.selectConfigIgnoreShiftList(shiftIgnore);

        DataValue dataValue = new DataValue();
        dataValue.setMainTableId(mainTableId);
        dataValue.setDate(date);
        dataValue.setShiftId(shiftId);
        List<DataValue> dataValues = dataValueMapper.selectDataValueList(dataValue);
        ConfigSubTable configSubTable = new ConfigSubTable();
        configSubTable.setMainTableId(mainTableId);
        List<BaseSubTableData> subTableDataList = new ArrayList<>();
        List<ConfigSubTable> configSubTables = configSubTableMapper.selectConfigSubTableList(configSubTable);
        for (ConfigSubTable subTable : configSubTables) {
            long subTableId = subTable.getId();
            ConfigSubTableCol configSubTableCol = new ConfigSubTableCol();
            configSubTableCol.setMainTableId(mainTableId);
            configSubTableCol.setSubTableId(subTableId);
            List<ConfigSubTableCol> configSubTableCols = configSubTableColMapper.selectConfigSubTableColList(configSubTableCol);
            ConfigSubTableRow configSubTableRow = new ConfigSubTableRow();
            configSubTableRow.setMainTableId(mainTableId);
            configSubTableRow.setSubTableId(subTableId);
            List<ConfigSubTableRow> configSubTableRows = configSubTableRowMapper.selectConfigSubTableRowList(configSubTableRow);
            if (configSubTableCols.size() > 0 && configSubTableRows.size() > 0) {
                SurfaceSubTableData subTableData = getHasDataSurfaceSubTableData(dataValues, subTable, shiftId, date, configSubTableCols, configSubTableRows, configIgnoreShifts);
                subTableDataList.add(subTableData);
            } else if (configSubTableCols.size() > 0) {
                LineSubTableData subTableData = getHasValueLineSubTableData(dataValues, subTable, shiftId, date, configSubTableCols, configIgnoreShifts);
                subTableDataList.add(subTableData);
            } else {
                PointSubTableData subTableData = getHasValuePontSubTableData(dataValues, subTable, shiftId, date, configIgnoreShifts);
                subTableDataList.add(subTableData);
            }
        }
        tableData.setSubTableDataList(subTableDataList);
        return tableData;
    }

    @Override
    public void deleteTable(long mainTableId) {

    }

    private DataValue getDataValue(List<DataValue> dataValues, long mainTableId, Date date, long subTableId, long shiftId, long colId, long rowId, List<ConfigIgnoreShift> configIgnoreShifts) {
        shiftId = getShiftId(shiftId, subTableId, colId, rowId, configIgnoreShifts);

        for (DataValue dataValue : dataValues) {
            if (dataValue.getSubTableId() == subTableId
                    && dataValue.getShiftId() == shiftId
                    && dataValue.getColId() == colId
                    && dataValue.getRowId() == rowId) {
                return dataValue;
            }
        }
        DataValue dataValue = new DataValue();
        dataValue.setMainTableId(mainTableId);
        dataValue.setSubTableId(subTableId);
        dataValue.setColId(colId);
        dataValue.setRowId(rowId);
        dataValue.setShiftId(shiftId);
        dataValue.setDate(date);
        return dataValue;
    }

    private SurfaceSubTableData getHasDataSurfaceSubTableData(List<DataValue> dataValues, ConfigSubTable subTable, long shiftId, Date date, List<ConfigSubTableCol> configSubTableCols, List<ConfigSubTableRow> configSubTableRows, List<ConfigIgnoreShift> configIgnoreShifts) {
        SurfaceSubTableData subTableData = new SurfaceSubTableData();
        subTableData.setTableId(subTable.getId());
        subTableData.setTableName(subTable.getName());
        List<String> cols = configSubTableCols.stream().map(ConfigSubTableCol::getName).collect(Collectors.toList());
        List<String> rows = configSubTableRows.stream().map(ConfigSubTableRow::getName).collect(Collectors.toList());
        subTableData.setColNameList(cols);
        subTableData.setRowNameList(rows);
        List<List<DataValue>> allValues = new ArrayList<>();
        for (ConfigSubTableRow configSubTableRow : configSubTableRows) {
            List<DataValue> colValues = new ArrayList<>();
            for (ConfigSubTableCol configSubTableCol : configSubTableCols) {
                DataValue value =getDataValue(dataValues, subTable.getMainTableId(), date, subTable.getId(), shiftId, configSubTableCol.getId(), configSubTableRow.getId(), configIgnoreShifts);
                colValues.add(value);
            }
            allValues.add(colValues);
        }
        subTableData.setData(allValues);
        return subTableData;
    }

    private LineSubTableData getHasValueLineSubTableData(List<DataValue> dataValues, ConfigSubTable subTable, long shiftId, Date date, List<ConfigSubTableCol> configSubTableCols, List<ConfigIgnoreShift> configIgnoreShifts) {
        LineSubTableData lineSubTableData = new LineSubTableData();
        lineSubTableData.setTableId(subTable.getId());
        lineSubTableData.setTableName(subTable.getName());
        List<String> cols = configSubTableCols.stream().map(ConfigSubTableCol::getName).collect(Collectors.toList());
        lineSubTableData.setTableId(subTable.getId());
        lineSubTableData.setTableName(subTable.getName());
        lineSubTableData.setColNameList(cols);
        List<DataValue> dataValueList = new ArrayList<>();
        for (ConfigSubTableCol configSubTableCol : configSubTableCols) {
            DataValue value =getDataValue(dataValues, subTable.getMainTableId(), date, subTable.getId(), shiftId, configSubTableCol.getId(), -1, configIgnoreShifts);
            dataValueList.add(value);
        }
        lineSubTableData.setData(dataValueList);
        return lineSubTableData;
    }


    private PointSubTableData getHasValuePontSubTableData(List<DataValue> dataValues, ConfigSubTable subTable, long shiftId, Date date, List<ConfigIgnoreShift> configIgnoreShifts) {
        PointSubTableData pointSubTableData = new PointSubTableData();
        pointSubTableData.setTableId(subTable.getId());
        pointSubTableData.setTableName(subTable.getName());
        pointSubTableData.setData(getDataValue(dataValues, subTable.getMainTableId(), date, subTable.getId(), shiftId, -1, -1, configIgnoreShifts));
        return pointSubTableData;
    }



    private long getShiftId(long shiftId, long subTableId, long colId, long rowId, List<ConfigIgnoreShift> ignoreShifts) {
        if (ignoreShift(subTableId, colId, rowId, ignoreShifts)) {
            return INVALID_ID;
        } else {
            return shiftId;
        }
    }

    private boolean ignoreShift(long subTableId, long colId, long rowId, List<ConfigIgnoreShift> ignoreShifts) {
        for (ConfigIgnoreShift shift : ignoreShifts) {
            if (shift.getSubtableid() == subTableId &&  shift.getColid() == colId && shift.getRowid() == rowId) {
                return true;
            }
        }
        return false;
    }

    private DataBase getDataBase(JSONObject object) {
        LinkedHashMap<String, Object> dataMap = (LinkedHashMap<String, Object>) object.get("commonData");
        DataBase database = new DataBase();
        database.setMainTableId(((Integer) dataMap.get("mainTableId")).longValue());
        database.setStatus(CommonData.STATUS_CREATE);
        database.setDate(getDate((String) dataMap.get("date")));
        database.setRecordUserId(((Integer) dataMap.get("userId")).longValue());
        database.setCreateTime(new Date());
        if (dataMap.get("id") != null) {
            database.setId(((Integer) dataMap.get("id")).longValue());
        }
        return database;
    }

    private List<DataValue> getDataValueList(JSONObject object) {
        List<DataValue> dataValues = new ArrayList<>();
        ArrayList<LinkedHashMap<String, Object>> list = (ArrayList<LinkedHashMap<String, Object>>) object.get("subTableDataList");
        for (LinkedHashMap<String, Object> subTable : list) {
            int type = (int) subTable.get("type");
            if (type == BaseSubTableData.TABLE_TYPE_POINT) {
                LinkedHashMap<String, Object> data = (LinkedHashMap<String, Object>) subTable.get("data");
                dataValues.add(getDataValue(data));
            } else if (type == BaseSubTableData.TABLE_TYPE_LINE) {
                ArrayList<LinkedHashMap<String, Object>> data = (ArrayList<LinkedHashMap<String, Object>>) subTable.get("data");
                for (LinkedHashMap<String, Object> item : data) {
                    dataValues.add(getDataValue(item));
                }
            } else {
                ArrayList<ArrayList<LinkedHashMap<String, Object>>> data = (ArrayList<ArrayList<LinkedHashMap<String, Object>>>) subTable.get("data");
                for (ArrayList<LinkedHashMap<String, Object>> datum : data) {
                    for (LinkedHashMap<String, Object> item : datum) {
                        dataValues.add(getDataValue(item));
                    }
                }
            }
        }
        return dataValues;
    }

    private DataValue getDataValue(LinkedHashMap map) {
        System.out.println(map);
        DataValue value = new DataValue();
        if (map.get("id") != null) {
            value.setId(((Integer) map.get("id")).longValue());
        }
        value.setRowId(((Integer) map.get("rowId")).longValue());
        value.setColId(((Integer) map.get("colId")).longValue());
        value.setMainTableId(((Integer) map.get("mainTableId")).longValue());
        value.setSubTableId(((Integer) map.get("subTableId")).longValue());
        value.setShiftId(((Integer) map.get("shiftId")).longValue());
        value.setDate(getDate((String) map.get("date")));
        String text = (String) map.get("valueText");
        if (StringUtils.isEmpty(text)) {
            value.setValueType(DataValue.VALUE_TYPE_NUMBER);
            if (map.get("valueNumber") != null) {
                value.setValueNumber(getDecimal(map.get("valueNumber").toString()));
            }
        } else {
            value.setValueType(DataValue.VALUE_TYPE_TEXT);
            value.setValueText(text);
        }
        return value;
    }

    private BigDecimal getDecimal(String number) {
        if (StringUtils.isEmpty(number)) {
            return BigDecimal.ZERO;
        }
        try {
            BigDecimal bigDecimal = BigDecimal.valueOf(Double.parseDouble(number));
            return bigDecimal;
        } catch (Exception e) {
            return BigDecimal.ZERO;
        }
    }

    private Date getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateFormat.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    private Date getDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }
}
