package bwie.com.suquanwei_yuekao.cart.presenter;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import bwie.com.suquanwei_yuekao.bean.Cart;
import bwie.com.suquanwei_yuekao.cart.model.CartModel;
import bwie.com.suquanwei_yuekao.cart.view.CartView;
import bwie.com.suquanwei_yuekao.net.ICallBack;

/**
 * Created by 小哥 on 2018/11/23.
 */

public class CartPresenter {
    private CartView cv;
    private CartModel model;

    public void attach(CartView cv){
        this.cv = cv;
        model = new CartModel();
    }

    public void getCart(){
        String url = "http://www.zhaoapi.cn/product/getCarts?uid=71";
        Type type = new TypeToken<Cart>() {
        }.getType();
        model.getData(url, new ICallBack() {
            @Override
            public void onsuccess(Object obj) {
                Cart cartBean = (Cart) obj;
                if (cartBean != null){
                    cv.getCart(cartBean.getData());
                }
            }

            @Override
            public void onfailed(Exception e) {
                cv.failed(e);
            }
        },type);
    }
    public void detach(){
        if (cv != null){
            cv = null;
        }
    }
}
