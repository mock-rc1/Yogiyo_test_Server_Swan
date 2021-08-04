package com.server.yogiyo.menu.dto;

import com.server.yogiyo.configure.entity.Status;
import com.server.yogiyo.menu.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.server.yogiyo.configure.entity.Status.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DetailMenuRes {

    private Long menuId;

    private Status status;

    private String title;

    private String thumbnail;

    private String name;

    private String subName;

    private Integer price;

    private String grade;

    private Long reviewCount;

    private List<OptionsDto> optionsList = new ArrayList<>();

    public DetailMenuRes(Menu menu) {
        this.menuId = menu.getMenuId();
        this.status = menu.getStatus();
        this.title = menu.getTitle();
        this.thumbnail = menu.getThumbnail();
        this.name = menu.getName();
        this.subName = menu.getSubName();
        this.price = menu.getPrice();
        this.grade = menu.getGrade();
        this.reviewCount = menu.getReviewCount();
        this.optionsList = menu.getOptionsList()
                .stream().filter(o -> o.getStatus() != Deleted).map(OptionsDto::new).collect(Collectors.toList());

    }


}
