package com.maybach7.gweather.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ConditionDto {

    @JsonProperty("text")
    private String text;

    private String icon;

    @JsonProperty("icon")
    public void setIcon(String icon) {
        String[] temp = icon.split("/");
        this.icon = "/img/" + temp[temp.length - 1].substring(0, temp[temp.length - 1].length() - 3) + "svg";
    }
}