package bytedance.example.easy_tiktok.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import bytedance.example.easy_tiktok.BR;
import bytedance.example.easy_tiktok.R;
import bytedance.example.easy_tiktok.bean.MovieItem;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private List<MovieItem> lists;
    private OnItemClickListener mOnItemClickListener;

    public MovieAdapter(List<MovieItem> lists) {
        this.lists = lists;
    }

    public interface OnItemClickListener{
        void onItemClick(View v,int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.movielistitem,parent,false);
        return new ViewHolder(viewDataBinding,mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(MovieAdapter.ViewHolder holder, int position) {
        MovieItem movieItem = lists.get(position);
        holder.viewDataBinding.setVariable(BR.movieItems,movieItem);
        holder.viewDataBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ViewDataBinding viewDataBinding;
        OnItemClickListener listener;

        public ViewHolder(ViewDataBinding viewDataBinding, OnItemClickListener listener) {
            super(viewDataBinding.getRoot());
            this.viewDataBinding = viewDataBinding;
            this.listener = listener;
            viewDataBinding.getRoot().setOnClickListener(this);
        }

        public ViewDataBinding getBinding(){
            return viewDataBinding;
        }

        @Override
        public void onClick(View v) {
            if (listener!=null){
                listener.onItemClick(v,getPosition());
            }
        }
    }
}
