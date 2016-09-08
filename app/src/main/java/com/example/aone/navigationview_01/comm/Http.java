package com.example.aone.navigationview_01.comm;

import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by aone on 2016/8/2.
 */
public class Http {
    public void Http() {

    }

    /**
     * 使用post方法进行请求，获取返回结果集
     *
     * @param url    请求地址
     * @param params 请求的参数，使用params.add(new BasicNameValuePair("amount", "10000"))方法进行添加参数
     * @return 异常返回null
     */
    public static String getPoststr(String url, List<NameValuePair> params) {
        String resultstr = "";
        HttpPost httppost = new HttpPost(url);
        try {
            httppost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            HttpResponse httpResponse = new DefaultHttpClient().execute(httppost);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                resultstr = EntityUtils.toString(httpResponse.getEntity());
            }
        } catch (UnsupportedEncodingException e) {
            resultstr = "null";
        } catch (ClientProtocolException e) {
            resultstr = "null";
        } catch (IOException e) {
            resultstr = "null";
        }
        return resultstr;
    }

    /**
     * 使用get方法进行请求，获取返回结果集
     *
     * @param url 请求地址 http://xx.ashx?a=aaa&b=bbb
     * @return
     */
    public static String getGetstr(String url) {
        String reString = "";
        HttpResponse httpResponse = null;
        HttpGet httpGet = new HttpGet(url);

        try {
            httpResponse = new DefaultHttpClient().execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                reString = EntityUtils.toString(httpResponse.getEntity());
            }
        } catch (ClientProtocolException e) {
            reString = "null1";
        } catch (IOException e) {
            reString = "null2";
        }
        return reString;
    }
}
