package vivienkeegan.csc4320.filemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.file_recycler_view);

        // Use this to improve performance if changes in content do not change
        // the layout size of the RecyclerView
        // mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Stub
        List<FileListItem> dummyList = new ArrayList<FileListItem>();
        dummyList.add(new FileListItem("Folder_1", true));
        dummyList.add(new FileListItem("File_1", false));

        mAdapter = new ListAdapter(dummyList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
