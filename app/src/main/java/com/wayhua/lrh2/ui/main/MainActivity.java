package com.wayhua.lrh2.ui.main;

import android.Manifest;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.tbruyelle.rxpermissions2.RxPermissions;
import com.wayhua.lrh2.R;
import com.wayhua.lrh2.databinding.ActivityMainBinding;
import com.wayhua.lrh2.ui.detail.BookDetailActivity;
import com.wayhua.lrh2.xzxing.activity.XCaptureActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;


public class MainActivity extends AppCompatActivity implements HasSupportFragmentInjector {
    private static final int SCANREQUESTCODE = 1034;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentAndroidInjector;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.fab.setOnClickListener(view -> doscan());
    }

    private void doscan() {
        RxPermissions.getInstance(this)
                .request(Manifest.permission.CAMERA)
        .subscribe(aBoolean -> {
            if (aBoolean) {
                //扫描事件
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, XCaptureActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(intent, SCANREQUESTCODE);
            }
        });
//                .subscribe(new Consumer<Boolean>() {
//                    @Override
//                    public void accept(Boolean aBoolean) throws Exception {
//                        if (aBoolean) {
//                            //扫描事件
//                            Intent intent = new Intent();
//                            intent.setClass(MainActivity.this, XCaptureActivity.class);
//                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                            startActivityForResult(intent, SCANREQUESTCODE);
//                        }
//                    }
//                })
        ;


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 处理扫描结果（在界面上显示）
        if (requestCode == SCANREQUESTCODE) {
            if (resultCode == this.RESULT_OK) {
                Bundle bundle = data.getExtras();
                String scanResult = bundle.getString("result");
                Log.e("scan", scanResult);
                BookDetailActivity.start(MainActivity.this,scanResult);
            }
        }
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentAndroidInjector;
    }
}
