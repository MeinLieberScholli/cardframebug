package com.example.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.FragmentGridPagerAdapter;
import android.support.wearable.view.GridViewPager;
import android.support.wearable.view.WatchViewStub;

/**
 * Created by joseforcemanager on 11/02/15.
 */
public class TestActivity extends WearableActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_grid);
        WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub watchViewStub) {
                ((GridViewPager) findViewById(R.id.pager)).setAdapter(new FragmentGridPagerAdapter(getFragmentManager()) {
                    @Override
                    public Fragment getFragment(int i, int i1) {
                        if (i1 == 0)
                            return new TestCompanyFragment();
                        return null;
                    }

                    @Override
                    public int getRowCount() {
                        return 5;
                    }

                    @Override
                    public int getColumnCount(int i) {
                        return 1;
                    }
                });
            }
        });
    }

}
