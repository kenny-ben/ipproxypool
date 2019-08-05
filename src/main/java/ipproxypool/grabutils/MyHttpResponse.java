package ipproxypool.grabutils;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import org.apache.http.HttpHost;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import ipproxypool.Myexception.checkStringNull;
import ipproxypool.Myexception.responseException;
import ipproxypool.bean.ipProxyPoolBean;
import ipproxypool.util.conversionUtil;
/*
 * 第一次获取页面代理ip
 */
public class MyHttpResponse {
	public static String getHttpText(String url) {
		//Queue<ipProxyPoolBean> ipProxyPoolList = new LinkedList<ipProxyPoolBean>();
		CloseableHttpResponse response = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		int httpStatus;
		String resource = "";
		RequestConfig config = RequestConfig.custom().setConnectTimeout(3000).setSocketTimeout(3000).build();
		HttpGet http = new HttpGet(url);
		http.setConfig(config);
		http.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;" +
                "q=0.9,image/webp,*/*;q=0.8");
		http.setHeader("Accept-Encoding", "gzip, deflate, sdch");
		http.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
		http.setHeader("Cache-Control", "no-cache");
		http.setHeader("Connection", "keep-alive");
		http.setHeader("Host", "www.xicidaili.com");
		http.setHeader("Pragma", "no-cache");
	    http.setHeader("Upgrade-Insecure-Requests", "1");
	    http.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 " +
	                "(KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
	    try {
			response = httpclient.execute(http);
			httpStatus = response.getStatusLine().getStatusCode();
			if(httpStatus==200) {
				resource = EntityUtils.toString(response.getEntity(),"utf-8");
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(response!=null) {
					response.close();
				}
				httpclient.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
	    try {
	    	checkStringNull.check(resource);
	    }catch(responseException e){
	    	
	    }
	    
	    
		return resource;
	}

	//对上一个方法的重载，使用代理进行网站爬取
	public static String getHttpText(String url,String ip,String port ) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resource = null;
		int staff;
		//设置代理访问及超时时限
		//System.out.println(ip+Integer.getInteger(port));
		HttpHost httpHost = new HttpHost(ip,Integer.parseInt(port));
		RequestConfig config = RequestConfig.custom().setProxy(httpHost).setConnectTimeout(2000).setSocketTimeout(1000).build();
		HttpGet httpGet = new HttpGet(url);
		httpGet.setConfig(config);
		httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;" +
                "q=0.9,image/webp,*/*;q=0.8");
        httpGet.setHeader("Accept-Encoding", "gzip, deflate, sdch");
        httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
        httpGet.setHeader("Cache-Control", "no-cache");
        httpGet.setHeader("Connection", "keep-alive");
        httpGet.setHeader("Host", "www.xicidaili.com");
        httpGet.setHeader("Pragma", "no-cache");
        httpGet.setHeader("Upgrade-Insecure-Requests", "1");
        httpGet.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 " +
                "(KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");
        try {
        	//获得http请求的html
        	System.out.println(httpGet.getAllHeaders());
			response = httpClient.execute(httpGet);
			//得到服务器的响应码
			staff = response.getStatusLine().getStatusCode();
			if("200".equals(staff)) {
				resource = EntityUtils.toString(response.getEntity(),"utf-8");
				System.out.println("当前线程："+Thread.currentThread().getName()+
						",当前ip"+ip+",ip端口"+port+",成功抓取代理网站的"+url);
			}else {
				System.out.println("筛选状态码"+",当前线程："+Thread.currentThread().getName()+
						",当前ip"+ip+",ip端口"+port+"成功抓取代理网站的"+url+",状态码"+staff);
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(response!=null) {
					response.close();
				}
				httpClient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resource;
	}
}
