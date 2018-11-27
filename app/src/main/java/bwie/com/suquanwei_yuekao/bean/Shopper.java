package bwie.com.suquanwei_yuekao.bean;

import java.util.List;

/**
 * Created by 小哥 on 2018/11/23.
 */

public class Shopper {
    private String sellerid;
    private String sellerName;
    private List<Product> list;

    public String getSellerid() {
        return sellerid;
    }

    public void setSellerid(String sellerid) {
        this.sellerid = sellerid;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }
}
