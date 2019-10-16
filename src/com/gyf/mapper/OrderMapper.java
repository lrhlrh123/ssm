package com.gyf.mapper;

import com.gyf.model.Order;
import com.gyf.model.OrderDetail;
import com.gyf.model.OrderExt;
import com.gyf.model.User;

import java.util.List;

public interface OrderMapper {
    public OrderExt findOrderById(int id);
    public Order findOrderById2(int id);
    public Order findOrderById3(int id);
}
