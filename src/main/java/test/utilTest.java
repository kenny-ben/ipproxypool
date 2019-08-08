package test;

import database.redisDB;
import redis.clients.jedis.Jedis;

public class utilTest {
	public static void showStr(String s) {
		s = s+"1";
				}
	public static void main(String[] args) {
		redisDB redisdb = new redisDB();
		 Jedis jedis = redisDB.getConnection();
		 System.out.println(jedis.get("name"));
		 redisDB.cloceRDB(jedis);
	}
}
