package com.ruoyi.report.domain.dto;

/**
 * @author wzh
 * @date 2021年05月11日 10:10
 */
public class NumberAnalysisMetaData extends AnalysisMetaData{
    private double dailyValue;
    private double totalValue;

    public double getDailyValue() {
        return dailyValue;
    }

    public void setDailyValue(double dailyValue) {
        this.dailyValue = dailyValue;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    @Override
    public String toString() {
        return "AnalysisMetaData{" +
                "dailyValue=" + dailyValue +
                ", totalValue=" + totalValue +
                '}';
    }
}
