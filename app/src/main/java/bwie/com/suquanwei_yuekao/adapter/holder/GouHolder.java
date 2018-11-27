package bwie.com.suquanwei_yuekao.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import bwie.com.suquanwei_yuekao.activity.R;

/**
 * Created by 小哥 on 2018/11/23.
 */

public class GouHolder extends RecyclerView.ViewHolder {
    public ImageView mIvItemShopcartShopselect;
    public TextView mTvItemShopcartShopname;
    public RecyclerView recyclerView;
    public GouHolder(View itemView) {
        super(itemView);
        recyclerView = itemView.findViewById(R.id.recycler_view);
        mTvItemShopcartShopname = itemView.findViewById(R.id.tv_item_shopcart_shopname);
        mIvItemShopcartShopselect = itemView.findViewById(R.id.iv_item_shopcart_shopselect);
    }
}
