package bwie.com.suquanwei_yuekao.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import bwie.com.suquanwei_yuekao.activity.R;

/**
 * Created by 小哥 on 2018/11/23.
 */

public class WuHolder extends RecyclerView.ViewHolder {
    public TextView mTvItemShopcartClothname;
    public ImageView mTvItemShopcartClothselect;
    public SimpleDraweeView mIvItemShopcartClothPic;
    public TextView mTvItemShopcartClothPrice;
    public TextView mTvItemShopcartClothColor;
    public ImageView mIvItemShopcartClothMinus;
    public TextView mEtItemShopcartClothNum;
    public ImageView mIvItemShopcartClothAdd;
    public ImageView mIvItemShopcartClothDelete;
    public WuHolder(View itemView) {
        super(itemView);
        this.mTvItemShopcartClothname = (TextView) itemView.findViewById(R.id.tv_item_shopcart_clothname);
        this.mTvItemShopcartClothselect = (ImageView) itemView.findViewById(R.id.tv_item_shopcart_clothselect);
        this.mIvItemShopcartClothPic = (SimpleDraweeView) itemView.findViewById(R.id.iv_item_shopcart_cloth_pic);
        this.mTvItemShopcartClothPrice = (TextView) itemView.findViewById(R.id.tv_item_shopcart_cloth_price);
        this.mTvItemShopcartClothColor = (TextView) itemView.findViewById(R.id.tv_item_shopcart_cloth_color);
        this.mIvItemShopcartClothMinus = (ImageView) itemView.findViewById(R.id.iv_item_shopcart_cloth_minus);
        this.mEtItemShopcartClothNum = (TextView) itemView.findViewById(R.id.et_item_shopcart_cloth_num);
        this.mIvItemShopcartClothAdd = (ImageView) itemView.findViewById(R.id.iv_item_shopcart_cloth_add);
        this.mIvItemShopcartClothDelete = (ImageView) itemView.findViewById(R.id.iv_item_shopcart_cloth_delete);
    }
}
