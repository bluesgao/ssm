package com.gx.app.ssm.biz.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class OrderDelivery {
    private Long id;
    private String venderId;
    private String orderId;
    private String carrierId;
    private String carrierName;
    private String deliveryId;
    private Integer syncStatus;
    private String syncDesc;
    private String operator;
    private Integer yn;
    private Date createdDate;
    private Date modifiedDate;
}
