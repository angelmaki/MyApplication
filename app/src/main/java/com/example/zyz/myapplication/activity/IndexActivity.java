package com.example.zyz.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.example.zyz.myapplication.R;
import com.example.zyz.myapplication.fragment.ClubFragment;
import com.example.zyz.myapplication.fragment.HomeFragment;
import com.example.zyz.myapplication.fragment.MineFragment;
import com.example.zyz.myapplication.fragment.ShowpicFragment;
import com.example.zyz.myapplication.fragment.TrainFragment;

public class IndexActivity extends AppCompatActivity implements View.OnClickListener{

    private Fragment mTrainFragment,mClubFragment,mHomeFragment,mShowFragment,mMineFragment;
    private LinearLayout mTrainBtn,mClubBtn,mHomeBtn,mShowBtn,mMineBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        initView();
        initEvent();
        setSelect(0);
    }

    private void initView() {
        mTrainBtn = findViewById(R.id.train_layout);
        mClubBtn = findViewById(R.id.club_layout);
        mHomeBtn = findViewById(R.id.index_layout);
        mShowBtn = findViewById(R.id.pic_layout);
        mMineBtn = findViewById(R.id.me_layout);
        mTrainBtn.setOnClickListener(this);
        mClubBtn.setOnClickListener(this);
        mHomeBtn.setOnClickListener(this);
        mShowBtn.setOnClickListener(this);
        mMineBtn.setOnClickListener(this);
    }

    private void initEvent() {
        // 加载哪个就loadFragment()哪个 [0:TrainFragment,1:ClubFragment,2:HomeFragment,3:ShowFragment,4:MineFragment]
        loadFragment(2);
    }

    private void setSelect(int i){

    }

    // 加载Fragment
    public void loadFragment(int i) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        //隐藏所有Fragment
        hideFragment(transaction);

        switch (i) {
            case 0:
                if (null == mTrainFragment) {
                    mTrainFragment = new TrainFragment();
                    transaction.add(R.id.content, mTrainFragment);
                } else
                    transaction.replace(R.id.content, mTrainFragment);
                transaction.show(mTrainFragment);
                break;
            case 1:
                if (null == mClubFragment) {
                    mClubFragment = new ClubFragment();
                    transaction.add(R.id.content, mClubFragment);
                } else
                    transaction.replace(R.id.content, mClubFragment);
                transaction.show(mClubFragment);
                break;
            case 2:
                if (null == mHomeFragment) {
                    mHomeFragment = new HomeFragment();
                    transaction.add(R.id.content, mHomeFragment);
                } else
                    transaction.replace(R.id.content, mHomeFragment);
                transaction.show(mHomeFragment);
                break;
            case 3:
                if (null == mShowFragment) {
                    mShowFragment = new ShowpicFragment();
                    transaction.add(R.id.content, mShowFragment);
                } else
                    transaction.replace(R.id.content, mShowFragment);
                transaction.show(mShowFragment);
                break;
            case 4:
                if (null == mMineFragment) {
                    mMineFragment = new MineFragment();
                    transaction.add(R.id.content, mMineFragment);
                } else
                    transaction.replace(R.id.content, mMineFragment);
                transaction.show(mMineFragment);
                break;
        }
        transaction.commit();
    }

    // 隐藏所有Fragment (在加载fragment时先隐藏所有Fragment,不然会出现Fragment重叠绘制的情况)
    public void hideFragment(FragmentTransaction transaction) {
        if (mTrainFragment != null) {
            transaction.hide(mTrainFragment);
        }
        if (mClubFragment != null) {
            transaction.hide(mClubFragment);
        }
        if (mHomeFragment != null) {
            transaction.hide(mHomeFragment);
        }
        if (mShowFragment != null) {
            transaction.hide(mShowFragment);
        }
        if (mMineFragment != null) {
            transaction.hide(mMineFragment);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.train_layout:
                loadFragment(0);
                break;
            case R.id.club_layout:
                loadFragment(1);
                break;
            case R.id.index_layout:
                loadFragment(2);
                break;
            case R.id.pic_layout:
                loadFragment(3);
                break;
            case R.id.me_layout:
                loadFragment(4);
                break;
        }
    }
}


