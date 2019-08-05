package ipproxypool.util;

import java.util.ArrayList;
import java.util.List;

import ipproxypool.bean.ipProxyPoolBean;
import ipproxypool.grabutils.MyHttpResponse;

public class urlutil {
	/*
	 * 整合代理访问获取list的ipbean对象
	 */
	public static boolean urlStill(String url,String ip,String port,List<ipProxyPoolBean> ipmessages) {
		String html = MyHttpResponse.getHttpText(url, ip, port);
		List<ipProxyPoolBean> ipmessage = new ArrayList<ipProxyPoolBean>();
		if(html!=null) {
			ipmessage = conversionUtil.ipProxyPoolShow(html);
			//ipmessages.add(ipmessage);
			for(ipProxyPoolBean ipmess:ipmessage) {
				ipmessages.add(ipmess);
			}
			return true;
		}
		     
		return false;
	}
	
}
