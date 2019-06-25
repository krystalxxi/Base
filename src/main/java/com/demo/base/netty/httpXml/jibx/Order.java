package com.demo.base.netty.httpXml.jibx;

/**
 * Created by Krystal on 2019/5/9.
 */
public class Order {
    private long orderNumber;
    private String JiBX_bindingList;


    /**
     * Shipping address information. If missing, the billing address is also
     * used as the shipping address.
     */


    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderId) {
        this.orderNumber = orderId;
    }

    public String getJiBX_bindingList() {
        return JiBX_bindingList;
    }

    public void setJiBX_bindingList(String jiBX_bindingList) {
        JiBX_bindingList = jiBX_bindingList;
    }
}
