package org.zerock.oscatest.domain;


import lombok.*;

import java.time.LocalDate;


@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Contract {

    private Integer conNo;
    private String conName;
    private String conCategory;
    private String conLocation;
    private String conSpace;
    private String conContent;
    private String conRequest;
    private String conCondition;
    private String conStartDay;
    private String conEndDay;
    private String conPrice;
    private String conDocument;
    private String conImg;
    private String requester;
    private String worker;
    private String conState;

    private LocalDate regDate;
    private LocalDate updateDate;
    private int delFlag;

}
