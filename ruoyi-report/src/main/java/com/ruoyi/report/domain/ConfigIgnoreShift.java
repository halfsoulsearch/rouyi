package com.ruoyi.report.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;


/**
 * @author wzh
 * @date 2021年05月08日 11:09
 */

public class ConfigIgnoreShift extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long maintableid;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long subtableid;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long colid;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long rowid;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setMaintableid(Long maintableid) {
        this.maintableid = maintableid;
    }

    public Long getMaintableid() {
        return maintableid;
    }

    public void setSubtableid(Long subtableid) {
        this.subtableid = subtableid;
    }

    public Long getSubtableid() {
        return subtableid;
    }

    public void setColid(Long colid) {
        this.colid = colid;
    }

    public Long getColid() {
        return colid;
    }

    public void setRowid(Long rowid) {
        this.rowid = rowid;
    }

    public Long getRowid() {
        return rowid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("maintableid", getMaintableid())
                .append("subtableid", getSubtableid())
                .append("colid", getColid())
                .append("rowid", getRowid())
                .toString();
    }
}
