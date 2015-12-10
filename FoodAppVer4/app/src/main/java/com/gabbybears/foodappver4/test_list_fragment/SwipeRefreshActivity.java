package com.gabbybears.foodappver4.test_list_fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.gabbybears.foodappver4.R;

import java.util.ArrayList;
import java.util.List;

public class SwipeRefreshActivity extends AppCompatActivity implements Controller.FlowerCallbackListener {

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private List<Flower> mFlowerList = new ArrayList<>();
    private FlowersAdapter mFlowersAdapter;
    private Controller mController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_list_fragment);
        mController = new Controller(SwipeRefreshActivity.this);
        //configViews();
        mController.startFetching();
    }

    /*private void configViews() {
        mRecyclerView = (RecyclerView) this.findViewById(R.id.list);
        mSwipeRefreshLayout = (SwipeRefreshLayout) this.findViewById(R.id.swipe);

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(SwipeRefreshActivity.this));
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());

        mFlowersAdapter = new FlowersAdapter(mFlowerList);
        mRecyclerView.setAdapter(mFlowersAdapter);

        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorPrimaryDark));

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mController.startFetching();
            }
        });

        //addFlowers();
    }
*/
    private void addFlowers() {
        for(int i = 0; i  < 1000; i++) {

            Flower flower = new Flower.Builder()
                    .setName("Filippo")
                    .setPhoto("AJHAJKS")
                    .build();

            mFlowersAdapter.addFlower(flower);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onFetchStart() {

    }

    @Override
    public void onFetchProgress(Flower flower) {
        mFlowersAdapter.addFlower(flower);
    }

    @Override
    public void onFetchProgress(List<Flower> flowerList) {

    }

    @Override
    public void onFetchComplete() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onFetchFailed() {

    }
}

