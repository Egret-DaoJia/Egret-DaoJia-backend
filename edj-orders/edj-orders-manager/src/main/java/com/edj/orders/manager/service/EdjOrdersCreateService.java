package com.edj.orders.manager.service;

import com.edj.orders.base.domain.entity.EdjOrders;
import com.edj.orders.manager.domain.dto.OrdersPayDTO;
import com.edj.orders.manager.domain.dto.PlaceOrderDTO;
import com.edj.orders.manager.domain.vo.OrdersPayVO;
import com.edj.orders.manager.domain.vo.PlaceOrderVo;
import com.github.yulichang.base.MPJBaseService;

/**
 * 针对表【edj_orders(订单表)】的数据库操作Service
 *
 * @author A.E.
 * @date 2024/12/23
 */
public interface EdjOrdersCreateService extends MPJBaseService<EdjOrders> {

    /**
     * 下单
     */
    PlaceOrderVo placeOrder(PlaceOrderDTO placeOrderDTO);

    /**
     * 订单支付
     */
    OrdersPayVO pay(OrdersPayDTO ordersPayDTO);
}
