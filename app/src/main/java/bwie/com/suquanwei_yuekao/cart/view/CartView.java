package bwie.com.suquanwei_yuekao.cart.view;

import java.util.List;

import bwie.com.suquanwei_yuekao.bean.Cart;

/**
 * Created by 小哥 on 2018/11/23.
 */

public interface CartView {

    void getCart(List<Cart.DataBean> list);

    void failed(Exception e);
}
