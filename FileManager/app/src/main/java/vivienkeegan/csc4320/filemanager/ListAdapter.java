package vivienkeegan.csc4320.filemanager;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ItemViewHolder> {
    private List<File> mFileList;

    public ListAdapter(List<File> fileList) {
        mFileList = fileList;
    }

    public boolean createDirectory(File newDir) {
        return (newDir.mkdir());
    }

    public boolean deleteFile(int position, Context context) {
        try {
            File f = mFileList.get(position);
            if (f.delete()) {
                mFileList.remove(position);
            } else {
                return false;
            }
        } catch (SecurityException se) {
            Toast.makeText(context, "Permission denied", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    @Override
    public int getItemCount() {
        return mFileList.size();
    }

    @Override
    public void onBindViewHolder(ItemViewHolder fileItemViewHolder, int position) {
        File li = mFileList.get(position);
        fileItemViewHolder.mTextView.setText(li.getName());

        if (li.isDirectory()) {
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

    public static class ItemViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        public ImageView mImageView;
        public TextView mTextView;
        public RelativeLayout mRelativeLayout;

        public ItemViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mImageView = (ImageView) itemView.findViewById(R.id.item_icon);
            mTextView = (TextView) itemView.findViewById(R.id.item_name);
            mRelativeLayout = (RelativeLayout) itemView.findViewById(R.id.item_layout);
        }

        @Override
        public void onClick(View itemView) {
            int position = getAdapterPosition();

            MainActivity context = (MainActivity) itemView.getContext();
            if (context.deleteFile(position)) {
                Toast.makeText(context, "File deleted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Unable to delete", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
