package bwie.com.suquanwei_yuekao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import bwie.com.suquanwei_yuekao.bean.BannerBean;
import bwie.com.suquanwei_yuekao.net.StringUtils;

/**
 * Created by 小哥 on 2018/11/23.
 */

public class BannerAdapter extends PagerAdapter{
    private Context context;
    private List<BannerBean> list;

    public BannerAdapter(Context context, List<BannerBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        ImageView img = new ImageView(context);
        Glide.with(context).load(StringUtils.http2Http(list.get(position).getIcon())).into(img);
        container.addView(img);
        return img;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
