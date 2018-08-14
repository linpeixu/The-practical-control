package com.cax.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.lpx.mytestgithub.R;


public class MainActivity extends AppCompatActivity {
    private final String TAG="MainActivity";
    private  final String BASE_URL = "https://api.douban.com/v2/movie/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void test() {
//哈哈
    }
}
