package com.server.yogiyo.review.entity;

import com.server.yogiyo.configure.entity.BaseTimeEntity;
import com.server.yogiyo.configure.entity.Status;
import com.server.yogiyo.orders.entity.CompleteOrders;
import com.server.yogiyo.review.dto.PostReviewReq;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static com.server.yogiyo.configure.entity.Status.*;
import static javax.persistence.FetchType.LAZY;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Review extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "completeOrdersId")
    private CompleteOrders completeOrders;

    private Integer taste;

    private Integer portions;

    private Integer delivery;

    private String image1;
    private String image2;
    private String image3;
    private String image4;

    private String contents;

    private Long likeCount;

    private Long reportCount;

    public Review(PostReviewReq req, CompleteOrders completeOrders) {
        this.status = Valid;
        this.completeOrders = completeOrders;
        this.taste = req.getTaste();
        this.portions = req.getPortions();
        this.delivery = req.getDelivery();
        this.image1 = req.getImage1();
        this.image2 = req.getImage2();
        this.image3 = req.getImage3();
        this.image4 = req.getImage4();
        this.contents = req.getContents();
        this.likeCount = 0L;
        this.reportCount = 0L;
    }
}
