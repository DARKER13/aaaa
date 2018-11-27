package bwie.com.suquanwei_yuekao.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bwie.com.suquanwei_yuekao.activity.R;
import bwie.com.suquanwei_yuekao.adapter.BannerAdapter;
import bwie.com.suquanwei_yuekao.adapter.ProuductAdapter;
import bwie.com.suquanwei_yuekao.bean.BannerBean;
import bwie.com.suquanwei_yuekao.bean.Message;
import bwie.com.suquanwei_yuekao.bean.Product;
import bwie.com.suquanwei_yuekao.bean.Shopper;
import bwie.com.suquanwei_yuekao.home.presenter.HomePresenter;
import bwie.com.suquanwei_yuekao.home.view.HomeView;

/**
 * Created by 小哥 on 2018/11/23.
 */

public class HomeFragment extends Fragment implements HomeView{

    private HomePresenter presenter;
    private List<BannerBean> bannerBeanList;
    private List<Product> productList;
    private ViewPager view_page;
    private RecyclerView recy_view;
    private BannerAdapter bannerAdapter;
    private ProuductAdapter productAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.home_fragment, container, false);
        view_page = inflate.findViewById(R.id.view_page);
        recy_view = inflate.findViewById(R.id.recy_view);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //调用P层
        presenter = new HomePresenter();
        presenter.attach(this);
        presenter.getBanner();
        presenter.getProduct();

        bannerBeanList = new ArrayList<>();
        productList = new ArrayList<>();

        bannerAdapter = new BannerAdapter(getActivity(), bannerBeanList);
        productAdapter = new ProuductAdapter(getActivity(), productList);

        RecyclerView.LayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recy_view.setLayoutManager(manager);

        view_page.setAdapter(bannerAdapter);
        recy_view.setAdapter(productAdapter);

    }
    @Override
    public void getBanner(Message<List<BannerBean>> banner) {
        if (banner != null){
            List<BannerBean> data = banner.getData();
            if (data != null){
                bannerBeanList.clear();
                bannerBeanList.addAll(data);
                bannerAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void getProduct(Message<List<Shopper>> product) {
        List<Shopper> list = product.getData();
        if (list != null){
            productList.clear();
            for (Shopper shopper : list){
                List<Product> products = shopper.getList();
                if (shopper != null){
                    productList.addAll(products);
                }
            }
            productAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onfailed(Exception e) {
        Toast.makeText(getActivity(), "网络异常", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null){
            presenter.onDestroy();
        }
    }
}
