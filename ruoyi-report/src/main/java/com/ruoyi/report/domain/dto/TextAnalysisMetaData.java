package com.ruoyi.report.domain.dto;

/**
 * @author wzh
 * @date 2021年05月11日 10:10
 */
public class TextAnalysisMetaData extends AnalysisMetaData{
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TextAnalysisMetaData{" +
                "text='" + text + '\'' +
                '}';
    }
}
