package com.gx.app.ssm.dao;

import com.gx.app.ssm.biz.dto.OrderDelivery;

import java.util.List;

public interface OrderDeliveryMapper {
    int insertSelective(OrderDelivery record);

    int updateByPrimaryKeySelective(OrderDelivery record);

    int updateByUniqueKeySelective(OrderDelivery record);

    OrderDelivery selectByPrimaryKey(Long id);

    OrderDelivery selectByUniqueKey(String orderId);

    List<OrderDelivery> selectList(OrderDelivery record);

    int upsertBatch(List<OrderDelivery> recordList);

    int updateBatch(List<OrderDelivery> recordList);
}
