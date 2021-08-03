package com.server.yogiyo.restaurant.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.server.yogiyo.restaurant.entity.Hours;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HoursRes implements Comparable<HoursRes>{

    private String day;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer dayNum;

    private String startMeridiem;

    private Integer startHour;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer startMinute;

    private String endMeridiem;

    private Integer endHour;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer endMinute;

    private Boolean isTommorw;

    private Boolean isSales;

    public HoursRes(Hours hours) {
        String[] arr = {"매일", "평일", "월",  "화",  "수",  "목" , "금" ,  "주말",  "토",  "일"};
        this.day = arr[hours.getDay() + 1];
        this.dayNum = hours.getDay();
        this.startMeridiem = hours.getStartMeridiem();
        this.startHour = hours.getStartHour();
        this.startMinute = hours.getStartMinute();
        this.endMeridiem = hours.getEndMeridiem();
        this.endHour = hours.getEndHour();
        this.endMinute = hours.getEndMinute();
        this.isTommorw = hours.getIsTommorw();
        this.isSales = hours.getIsSales();
    }

    @Override
    public int compareTo(HoursRes other) {
        return Integer.compare(this.dayNum, other.dayNum);
    }

}
