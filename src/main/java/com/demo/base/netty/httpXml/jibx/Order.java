package com.demo.base.netty.http_xml.jibx;

/**
 * Created by Krystal on 2019/5/9.
 */
public class Order {
    private long orderNumber;


    /**
     * Shipping address information. If missing, the billing address is also
     * used as the shipping address.
     */

    private Float total;

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderId) {
        this.orderNumber = orderId;
    }



    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }


}
