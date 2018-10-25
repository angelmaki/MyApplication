package com.example.zyz.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.zyz.myapplication.R;
import com.example.zyz.myapplication.activity.PicActivity;
import com.example.zyz.myapplication.activity.PicReleaseActivity;

public class ShowpicFragment extends Fragment {

    private Button ListButton;
    private Button ReleaseButton;
    private FrameLayout trainAll,trainC,trainR,trainJ;
    public ShowpicFragment() {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListButton = view.findViewById(R.id.Button_showpiclist);
        ReleaseButton = view.findViewById(R.id.Button_showpicrelease);
        trainAll = view.findViewById(R.id.trainAll);
        trainC = view.findViewById(R.id.trainC);
        initEvents();
    }

    private void initEvents(){
        trainAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),PicActivity.class);
                startActivity(intent);
            }
        });
        trainC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),PicReleaseActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_showpic, null);
    }

}
