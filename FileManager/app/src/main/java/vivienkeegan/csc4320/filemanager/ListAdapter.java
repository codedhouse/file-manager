package vivienkeegan.csc4320.filemanager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ItemViewHolder> {
    private List<FileListItem> mFileList;

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView;
        public RelativeLayout mRelativeLayout;

        public ItemViewHolder(View v) {
            super(v);
            mImageView = (ImageView) v.findViewById(R.id.item_icon);
            mTextView = (TextView) v.findViewById(R.id.item_name);
            mRelativeLayout = (RelativeLayout) v.findViewById(R.id.item_layout);
        }
    }

    public ListAdapter(List<FileListItem> fileList) {
        this.mFileList = fileList;
    }

    @Override
    public int getItemCount() { return mFileList.size(); }

    @Override
    public void onBindViewHolder(ItemViewHolder fileItemViewHolder, int i) {
        FileListItem li = mFileList.get(i);
        fileItemViewHolder.mTextView.setText(li.name);

        if (li.isFolder) {
            fileItemViewHolder.mImageView.setImageResource(R.drawable.ic_folder_black_48dp);
        } else {
            fileItemViewHolder.mImageView.setImageResource(R.drawable.ic_description_black_48dp);
        }
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup vg, int i) {
        View itemView = LayoutInflater.from(vg.getContext()).
                inflate(R.layout.list_item_layout, vg, false);

        return new ItemViewHolder(itemView);
    }
}
