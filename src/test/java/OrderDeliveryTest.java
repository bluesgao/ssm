import com.alibaba.fastjson.JSON;
import com.gx.app.ssm.basic.BaseResult;
import com.gx.app.ssm.biz.dto.OrderDelivery;
import com.gx.app.ssm.biz.inf.OrderDeliveryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class OrderDeliveryTest {

    @Autowired
    private OrderDeliveryService orderDeliveryService;

    @Test
    public void upsertTest() {
        List<OrderDelivery> records = new ArrayList<>();
        OrderDelivery o1 = new OrderDelivery();
        o1.setCarrierId("1111111");
        o1.setCarrierName("test");
        o1.setOrderId("9000");
        o1.setVenderId("test111");
        o1.setDeliveryId("sf1111111111");
        records.add(o1);
        BaseResult baseResult = orderDeliveryService.upsertBatch(records);
        log.info("baseResult:{}", baseResult.toString());
    }
}
