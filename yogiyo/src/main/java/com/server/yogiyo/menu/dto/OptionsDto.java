package com.server.yogiyo.menu.dto;

import com.server.yogiyo.configure.entity.Status;
import com.server.yogiyo.menu.entity.Options;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OptionsDto {

    private Long optionId;

    private Status status;

    private String title;

    private Boolean isNecessary;

    private String name;

    private Integer addCost;

    public OptionsDto(Options options) {
        this.optionId = options.getOptionsId();
        this.status = options.getStatus();
        this.title = options.getTitle();
        this.isNecessary = options.getIsNecessary();
        this.name = options.getName();
        this.addCost = options.getAddCost();
    }

}
