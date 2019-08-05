package ipproxypool.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import ipproxypool.bean.ipProxyPoolBean;


public class conversionUtil {
	public static String getResource(String url) {
		
		return "";
	}
	public static List<ipProxyPoolBean> ipProxyPoolShow(String resource){
		//获取该链接下的html
		//Queue<ipProxyPoolBean> ipProxyPoolList = new LinkedList<ipProxyPoolBean>();
		List<ipProxyPoolBean> ipProxyPoolList = new ArrayList<ipProxyPoolBean>();
		if(resource!=null) {
			// 将html解析成DOM结构
			Document document = Jsoup.parse(resource);
			
			// 提取所需要的数据
			// trs = document.select("table[id=ip_list]").select("tbody").select("tr");
			Elements trs = document.select("table[id=ip_list]").select("tr");
			System.out.println(trs.size());
			System.out.println(trs.get(1).select("td").get(1).text());
			for(int i = 1;i<trs.size();i++) {
				ipProxyPoolBean ipPoolBean = new ipProxyPoolBean();
				String ipAddress = trs.get(i).select("td").get(1).text();
		        String ipPort = trs.get(i).select("td").get(2).text();
		        String ipType = trs.get(i).select("td").get(5).text();
		        String ipSpeed = trs.get(i).select("td").get(6).select("div[class=bar]").
		                    attr("title");
		        ipPoolBean.setIpAddress(ipAddress);
		        ipPoolBean.setIpProt(ipPort);
		        ipPoolBean.setIpType(ipType);
		        ipPoolBean.setIpSpeed(ipSpeed);
		        ipProxyPoolList.add(ipPoolBean);
			}
			 
		}
        
		return ipProxyPoolList;
	}
}
