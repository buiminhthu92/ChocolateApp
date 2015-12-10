package com.gabbybears.foodappver4.test_list_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.gabbybears.foodappver4.R;
import com.gabbybears.foodappver4.TestActtivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android on 11/22/2015.
 */
public class SwipeRefreshFragment extends Fragment implements Controller.FlowerCallbackListener {

    private ListView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private List<Flower> mFlowerList = new ArrayList<>();
    private FlowersAdapter mFlowersAdapter;
    private Controller mController;

    private View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.test_list_fragment, container, false);

        //mController = new Controller((Controller.FlowerCallbackListener) getContext());
        configViews();
        mController.startFetching();

        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*mController = new Controller((Controller.FlowerCallbackListener) getActivity());
        configViews();
        mController.startFetching();*/
    }

    private void configViews() {
        mRecyclerView = (ListView) v.findViewById(R.id.swipeList);
        mSwipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swiperefresh);

        /*mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());*/

        mFlowersAdapter = new FlowersAdapter(mFlowerList);
        mRecyclerView.setAdapter((ListAdapter) mFlowersAdapter);

        mSwipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorPrimaryDark));

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mController.startFetching();
            }
        });
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
