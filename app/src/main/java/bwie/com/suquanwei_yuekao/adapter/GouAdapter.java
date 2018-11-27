package bwie.com.suquanwei_yuekao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import bwie.com.suquanwei_yuekao.activity.R;
import bwie.com.suquanwei_yuekao.adapter.holder.GouHolder;
import bwie.com.suquanwei_yuekao.bean.Cart;
import bwie.com.suquanwei_yuekao.net.Messages;

/**
 * Created by 小哥 on 2018/11/23.
 */

public class GouAdapter extends RecyclerView.Adapter<GouHolder> {
    private Context context;
    private List<Cart.DataBean> data;

    public GouAdapter(Context context, List<Cart.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public GouHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shop_cart_item, parent, false);
        GouHolder holder = new GouHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull GouHolder holder, final int position) {
        holder.mTvItemShopcartShopname.setText(data.get(position).getSellerName());
        holder.mIvItemShopcartShopselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        List<Cart.DataBean.ListBean> list = data.get(position).getList();
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        WuAdapter wuAdapter = new WuAdapter(context, list);
        holder.recyclerView.setAdapter(wuAdapter);
        if (data.get(position).isSelect()){
            holder.mIvItemShopcartShopselect.setImageResource(R.drawable.shopcart_selected);
            for (int i = 0; i < data.get(position).getList().size(); i++) {
                data.get(position).getList().get(i).setSelected(1);
            }
            EventBus.getDefault().post(new Messages("2"));
        }else{
            holder.mIvItemShopcartShopselect.setImageResource(R.drawable.shopcart_unselected);
            for (int i = 0; i < data.get(position).getList().size(); i++) {
                data.get(position).getList().get(i).setSelected(0);
            }
            EventBus.getDefault().post(new Messages("2"));
        }

        holder.mIvItemShopcartShopselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.get(position).setSelect(!data.get(position).isSelect());
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
