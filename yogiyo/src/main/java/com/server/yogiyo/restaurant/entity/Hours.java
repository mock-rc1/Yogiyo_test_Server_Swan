package com.server.yogiyo.restaurant.entity;

import com.server.yogiyo.configure.entity.BaseTimeEntity;
import com.server.yogiyo.configure.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Hours extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hoursId;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;

    private Integer day;

    private String startMeridiem;

    private Integer startHour;

    private Integer startMinute;

    private String endMeridiem;

    private Integer endHour;

    private Integer endMinute;

    private Boolean isTommorw;

    private Boolean isSales;

}
