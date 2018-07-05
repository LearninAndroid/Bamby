package dev.brian.com.bamby.ui.Cats;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.brian.com.bamby.R;

public class CategoryFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View mRootView = inflater.inflate(R.layout.fragment_categories,container,false);
        return mRootView;

    }
}
