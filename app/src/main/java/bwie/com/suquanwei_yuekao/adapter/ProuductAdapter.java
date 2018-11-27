package bwie.com.suquanwei_yuekao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import bwie.com.suquanwei_yuekao.activity.R;
import bwie.com.suquanwei_yuekao.bean.Product;
import bwie.com.suquanwei_yuekao.net.StringUtils;

/**
 * Created by 小哥 on 2018/11/23.
 */

public class ProuductAdapter extends RecyclerView.Adapter<ProuductAdapter.ViewHolder>{

    private Context context;
    private List<Product> list;

    public ProuductAdapter(Context context, List<Product> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.home_item_layout, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = list.get(position);
        String[] split = product.getImages().split("\\|");
        Glide.with(context).load(StringUtils.http2Http(split[0])).into(holder.imageView);
        holder.textView.setText(product.getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textView = itemView.findViewById(R.id.text_view);
        }
    }
}
