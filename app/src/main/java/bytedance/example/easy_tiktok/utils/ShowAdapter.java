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
import bytedance.example.easy_tiktok.bean.ShowItem;

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewHolder> {

    private List<ShowItem> lists;
    private ShowAdapter.OnItemClickListener mOnItemClickListener;

    public ShowAdapter(List<ShowItem> lists) {
        this.lists = lists;
    }

    public interface OnItemClickListener{
        void onItemClick(View v, int position);
    }

    public void setOnItemClickListener(ShowAdapter.OnItemClickListener listener){
        this.mOnItemClickListener = listener;
    }

    @Override
    public ShowAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.tvshowitemlayout,parent,false);
        return new ShowAdapter.ViewHolder(viewDataBinding,mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(ShowAdapter.ViewHolder holder, int position) {
        ShowItem showItem = lists.get(position);
        holder.viewDataBinding.setVariable(BR.showItems,lists.get(position));
        holder.viewDataBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ViewDataBinding viewDataBinding;
        ShowAdapter.OnItemClickListener listener;

        public ViewHolder(ViewDataBinding viewDataBinding, ShowAdapter.OnItemClickListener listener) {
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
