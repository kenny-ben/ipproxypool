package ipproxypool.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ipproxypool.bean.ipProxyPoolBean;

public class SerializeUtil {
	//ipProxyPoolBeab的序列化方法
	public static byte[] getSerialize(Object object) {
		ByteArrayOutputStream bos;
		ObjectOutputStream oos;
		bos = new ByteArrayOutputStream();
		try {
			oos = new ObjectOutputStream(bos);
			oos.writeObject(object);
			byte[] ipm = bos.toByteArray();
			return ipm;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	//ipProxyPoolBean的反序列化方法
	public static Object getipmessage(byte[] b) {
		ByteArrayInputStream bis;
		ObjectInputStream ois;
		bis = new ByteArrayInputStream(b);
		try {
			ois = new ObjectInputStream(bis);
			//ois.readObject();
			return ois.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
