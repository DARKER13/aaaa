package bwie.com.suquanwei_yuekao.cart.model;

import java.lang.reflect.Type;

import bwie.com.suquanwei_yuekao.net.HttpUtils;
import bwie.com.suquanwei_yuekao.net.ICallBack;

/**
 * Created by 小哥 on 2018/11/23.
 */

public class CartModel {

    public void getData(String url, ICallBack callBack, Type type){
        HttpUtils.getInstance().get(url, callBack, type);
    }
}
