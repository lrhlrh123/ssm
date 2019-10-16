package com.gyf.vo;

import com.gyf.model.Order;
import com.gyf.model.User;

import java.util.List;

public class UserQueryVO {
    private User user;
    private List<Integer>ids;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
