package com.cax.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.cax.net.MovieService;

import io.reactivex.subjects.PublishSubject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private final String TAG="MainActivity";
    private TextView mTest;
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
        //额
        mTest = (TextView) findViewById(R.id.tv_test);
        mTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
//获取接口实例.
                MovieService  movieService = retrofit.create(MovieService.class);
//调用方法得到一个Call
                Call<PublishSubject> call = movieService.getTop250(0,20);
                //进行网络请求
                call.enqueue(new Callback<PublishSubject>() {
                    @Override
                    public void onResponse(Call<PublishSubject> call, Response<PublishSubject> response) {
                        //mMovieAdapter.setMovies(response.body().subjects);
                        Log.e(TAG,"==="+response.headers());
                    }
                    @Override
                    public void onFailure(Call<PublishSubject> call, Throwable t) {
                        t.printStackTrace();
                        Log.e(TAG,"fail==="+t.toString());
                    }
                });



            }
        });
    }
}
