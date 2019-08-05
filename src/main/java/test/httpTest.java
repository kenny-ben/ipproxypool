package test;

import java.util.List;

import ipproxypool.bean.ipProxyPoolBean;
import ipproxypool.grabutils.MyHttpResponse;
import ipproxypool.util.conversionUtil;

public class httpTest {
	public static void main(String[] args) {
		String url = "http://www.xicidaili.com/nn/1";
		MyHttpResponse myhttpresponse = new MyHttpResponse();
		System.out.println(myhttpresponse.getHttpText(url,"175.155.141.190","808"));
		
		 List<ipProxyPoolBean> ipProxyPool =
		 conversionUtil.ipProxyPoolShow(myhttpresponse.getHttpText(url));
		 for(ipProxyPoolBean i:ipProxyPool) {
		 System.out.println("-------------------");
		 System.out.println(i.getIpAddress()); System.out.println(i.getIpProt());
		 System.out.println(i.getIpSpeed()); System.out.println(i.getIpType());
		 System.out.println("------------------------"); 
		 }
		 
		 
	}
}	
