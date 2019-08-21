package com.gx.app.ssm.biz.impl;

import com.alibaba.fastjson.JSON;
import com.gx.app.ssm.basic.BaseResult;
import com.gx.app.ssm.biz.dto.OrderDelivery;
import com.gx.app.ssm.biz.inf.OrderDeliveryService;
import com.gx.app.ssm.dao.OrderDeliveryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service(value = "orderDeliveryService")
@Slf4j
public class OrderDeliveryServiceImpl implements OrderDeliveryService {
    @Autowired
    private OrderDeliveryMapper orderDeliveryMapper;

    @Override
    public BaseResult upsertBatch(List<OrderDelivery> records) {
        log.info("upsertBatch input:records:{}", JSON.toJSONString(records));
        if (CollectionUtils.isEmpty(records)) {
            return BaseResult.errorWithCause("入参错误");
        }
        int ret = 0;
        try {
            ret = orderDeliveryMapper.upsertBatch(records);
        } catch (Exception e) {
            log.error("upsertBatch error:{}", e);
        }
        log.info("upsertBatch ret:{}", ret);

        if (ret > 0) {
            return BaseResult.success();
        } else {
            return BaseResult.errorWithCause("批量插入失败");
        }
    }
}
