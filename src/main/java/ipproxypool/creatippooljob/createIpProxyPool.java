package ipproxypool.creatippooljob;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import ipproxypool.bean.ipProxyPoolBean;
import ipproxypool.util.filterUtil;
import ipproxypool.util.urlutil;
/*
 * 获取ip代理池，将代理信息存入ipmessages的list中
 */
public class createIpProxyPool {
	private List<ipProxyPoolBean> ipmessages;
	private ReadWriteLock readwritelock = new ReentrantReadWriteLock();
	
	public createIpProxyPool(List<ipProxyPoolBean> ipmessage) {
		this.ipmessages = ipmessage;
	}
	public void saveip(Queue<String> urls,Object task) {
		//ReadWriteLock readwritelock = new ReadWriteLock();
		
		int rand=0;
		readwritelock.writeLock();
		String ipAddress = ipmessages.get(rand).getIpAddress();
		String port = ipmessages.get(rand).getIpProt();
		readwritelock.writeLock().unlock();
		while(true) {
			//List<ipProxyPoolBean> ipmessage = new ArrayList<ipProxyPoolBean>();
			List<ipProxyPoolBean> ipmessage1 = new ArrayList<ipProxyPoolBean>();
			String url;
			synchronized (task) {
				if(urls.isEmpty()) {
					System.out.println("当前线程"+Thread.currentThread().getName()+"url已空");
					break;
				}
				url = urls.poll();
			}
			boolean b = urlutil.urlStill(url, ipAddress, port, ipmessage1);
			if(!b) {
				readwritelock.writeLock();
				rand =(int)Math.random()*ipmessages.size();
				ipAddress = ipmessages.get(rand).getIpAddress();
				port = ipmessages.get(rand).getIpProt();
				readwritelock.writeLock().unlock();
				continue;
			}
			ipmessage1 = filterUtil.ipSpeedFilter(ipmessage1);
			readwritelock.writeLock();
			System.out.println("当前线程"+Thread.currentThread().getName()+"已准备并合并ipmessages大小为："+ipmessage1.size());
			ipmessages.addAll(ipmessage1);
			System.out.println("当前线程"+Thread.currentThread().getName()+"已合并ipmessages,合并后的大小为："+ipmessages.size());
			readwritelock.writeLock().unlock();
		}
		
	}
	
	
	
}
