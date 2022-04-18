package cn.lnfvc.MyApp;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class MyApp {
    public static void main(String[] args) {
        //相当于浏览器并new一个对象,client初始值为null
        OkHttpClient client = new OkHttpClient();
        //请求对象交给client对象使用,Request作为特殊对象需要用Request下的Builder对象，Builder建造了Request
        Request.Builder builder = new Request.Builder();
        Request request = builder.url("http://www.163.com/").build();
        //向浏览器发送请求
        //返回Call对象，
        Call call = client.newCall(request);
        //承诺实例，发送请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                System.out.println("访问失败");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                System.out.println("访问成功");
                String Info = response.body().string();
                System.out.println(Info);
            }
        });
        //在请求发送等待返回时，程序继续执行
        System.out.println("请求发送，等待处理。。。");
    }
}
