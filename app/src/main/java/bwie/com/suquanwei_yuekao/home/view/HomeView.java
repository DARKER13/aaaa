package bwie.com.suquanwei_yuekao.home.view;

import java.util.List;

import bwie.com.suquanwei_yuekao.bean.BannerBean;
import bwie.com.suquanwei_yuekao.bean.Message;
import bwie.com.suquanwei_yuekao.bean.Product;
import bwie.com.suquanwei_yuekao.bean.Shopper;

/**
 * Created by 小哥 on 2018/11/23.
 */

public interface HomeView {

    void getBanner(Message<List<BannerBean>> banner);

    void getProduct(Message<List<Shopper>> product);

    void onfailed(Exception e);
}
