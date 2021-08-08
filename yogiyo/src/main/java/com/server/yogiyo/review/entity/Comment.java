package com.server.yogiyo.review.entity;

import com.server.yogiyo.account.entity.Account;
import com.server.yogiyo.configure.entity.BaseTimeEntity;
import com.server.yogiyo.configure.entity.Status;
import com.server.yogiyo.review.dto.PostCommentReq;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static com.server.yogiyo.configure.entity.Status.*;
import static javax.persistence.CascadeType.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long commentId;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    @JoinColumn(name = "accountId")
    private Account account;

    @OneToOne
    @JoinColumn(name = "reviewId")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "parentCommentId")
    private Comment parentComment;

    @OneToMany(mappedBy = "parentComment", cascade = ALL)
    private List<Comment> nestedComments = new ArrayList<>();

    private Boolean isNested;

    private String contents;

    private Integer reportCount;

    public void addNestedComment(Comment comment) {
        this.nestedComments.add(comment);
    }

    public Comment(Account account, Review review, Comment comment, PostCommentReq req) {
        this.status = Valid;
        this.account = account;
        this.review = review;
        this.parentComment = null;
        isNested = false;
        contents = req.getContents();
        this.reportCount = 0;

        if (comment != null) {
            isNested = true;
            this.parentComment = comment;
            comment.addNestedComment(this);
        }

    }

}
