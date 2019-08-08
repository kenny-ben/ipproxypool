package database;

import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import ipproxypool.bean.ipProxyPoolBean;
import ipproxypool.util.SerializeUtil;
import redis.clients.jedis.Jedis;

public class myRedis {
	//获得redis的连接
	private static Jedis jedis = redisDB.getConnection();
	//创建线程锁
	private static ReadWriteLock readwritelock = new ReentrantReadWriteLock();
	//将某个信息保存在redis中
	public void saveIpmessageRedis(ipProxyPoolBean ipmessage) {
		//将ipmessage进行序列化
		byte[] ip = SerializeUtil.getSerialize(ipmessage);
		readwritelock.writeLock();
		jedis.rpush("ip-proxy-pool".getBytes(), ip);
		readwritelock.writeLock().unlock();
	}
	//将List中的ipProxyPoolBean进行序列化操作
	public void saceListIpmessageRedis(List<ipProxyPoolBean> ipmessages) {
		
		for(ipProxyPoolBean ipmessage:ipmessages) {
			//序列化处理
			byte[] bytes = SerializeUtil.getSerialize(ipmessage);
			readwritelock.writeLock();
			jedis.rpush("ip-proxy-pool".getBytes(), bytes);
			readwritelock.writeLock().unlock();
		}
		
	}
	//在redis中得到ipProxyPoolBean对象并进行反序列化操作
	public static ipProxyPoolBean getRedisipProxyPoolBean() {
		readwritelock.writeLock();
		ipProxyPoolBean ipmessage = (ipProxyPoolBean)SerializeUtil.getipmessage(jedis.lpop("ip-proxy-pool".getBytes()));
		readwritelock.writeLock().unlock();
		return ipmessage;
	}
	//判断redis中的ip池是否为空
	public static boolean isEntry() {
		readwritelock.readLock();
		long flag = jedis.llen("ip-proxy-pool".getBytes());
		return flag <= 0;
	}
	
	//释放redis资源
	public void closeRedis() {
		redisDB.cloceRDB(jedis);
	}
	
}
