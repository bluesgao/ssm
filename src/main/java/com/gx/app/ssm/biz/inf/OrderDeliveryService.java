package com.gx.app.ssm.biz.inf;

import com.gx.app.ssm.basic.BaseResult;
import com.gx.app.ssm.biz.dto.OrderDelivery;

import java.util.List;

public interface OrderDeliveryService {
    BaseResult upsertBatch(List<OrderDelivery> records);
}
