package bwie.com.suquanwei_yuekao.home.presenter;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import bwie.com.suquanwei_yuekao.bean.BannerBean;
import bwie.com.suquanwei_yuekao.bean.Message;
import bwie.com.suquanwei_yuekao.bean.Product;
import bwie.com.suquanwei_yuekao.bean.Shopper;
import bwie.com.suquanwei_yuekao.home.model.HomeModel;
import bwie.com.suquanwei_yuekao.home.view.HomeView;
import bwie.com.suquanwei_yuekao.net.ICallBack;

/**
 * Created by 小哥 on 2018/11/23.
 */

public class HomePresenter {
    private HomeView hv;
    private HomeModel model;

    public void attach(HomeView hv){
        this.hv = hv;
        model = new HomeModel();
    }
    public void getBanner(){
        String url= "http://www.zhaoapi.cn/ad/getAd";
        Type type = new TypeToken<Message<List<BannerBean>>>() {
        }.getType();
        model.getData(url, new ICallBack() {
            @Override
            public void onsuccess(Object obj) {
                Message<List<BannerBean>> list = (Message<List<BannerBean>>) obj;
                hv.getBanner(list);
            }

            @Override
            public void onfailed(Exception e) {
                hv.onfailed(e);
            }
        },type);
    }
    public void getProduct(){
        String url = "http://www.zhaoapi.cn/product/getCarts?uid=71";
        Type type = new TypeToken<Message<List<Shopper>>>() {
        }.getType();
        model.getData(url, new ICallBack() {
            @Override
            public void onsuccess(Object obj) {
                Message<List<Shopper>> data = (Message<List<Shopper>>) obj;
                hv.getProduct(data);
            }

            @Override
            public void onfailed(Exception e) {
                hv.onfailed(e);
            }
        },type);
    }
    public void onDestroy(){
        if (hv != null){
            hv = null;
        }
    }
}
