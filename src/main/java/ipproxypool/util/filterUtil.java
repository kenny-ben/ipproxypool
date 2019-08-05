package ipproxypool.util;

import java.util.LinkedList;
import java.util.List;

import ipproxypool.bean.ipProxyPoolBean;

public class filterUtil {
	public static List<ipProxyPoolBean> ipSpeedFilter(List<ipProxyPoolBean> ipmessage) {
		List<ipProxyPoolBean> newipmessage = new LinkedList<ipProxyPoolBean>();
		for(ipProxyPoolBean ipmess:ipmessage) {
			String type = ipmess.getIpType();
			String speed = ipmess.getIpSpeed();
			Double b = Double.parseDouble(speed.substring(0,speed.indexOf("秒")));
			if("HTTPS".equals(type)&&b<3.0) {
				newipmessage.add(ipmess);
			}
		}
		return newipmessage;
	}
}
