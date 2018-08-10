package com.cax.net;

import io.reactivex.subjects.PublishSubject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



/**
 * 说明[最后修改于2018年08月07日14:48]
 *
 * @author lpx
 */

public interface MovieService {
    //获取豆瓣Top250 榜单
    @GET("top250")
    Call<PublishSubject> getTop250(@Query("start") int start, @Query("count")int count);
}
