package com.gx.app.ssm.web.vo;

import com.opencsv.bean.CsvBindByName;


public class OrderDeliveryVo {
    @CsvBindByName(column = "商户")
    private String venderId;
    @CsvBindByName(column = "订单号")
    private String orderId;
    @CsvBindByName(column = "快递公司")
    private String carrierName;
    @CsvBindByName(column = "运单号")
    private String deliveryId;

    public String getVenderId() {
        return venderId;
    }

    public void setVenderId(String venderId) {
        this.venderId = venderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }
}
