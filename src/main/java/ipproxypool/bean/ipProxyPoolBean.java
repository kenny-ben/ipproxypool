package ipproxypool.bean;

import java.io.Serializable;

public class ipProxyPoolBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ipAddress;
	private String ipProt;
	private String ipType;
	private String ipSpeed;
	//计数器，同一ip连续三次不能使用则在代理池中删除该ip
	private int useCount;  	
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getIpProt() {
		return ipProt;
	}
	public void setIpProt(String ipProt) {
		this.ipProt = ipProt;
	}
	public String getIpType() {
		return ipType;
	}
	public void setIpType(String ipType) {
		this.ipType = ipType;
	}
	public String getIpSpeed() {
		return ipSpeed;
	}
	public void setIpSpeed(String ipSpeed) {
		this.ipSpeed = ipSpeed;
	}
	public int getUseCount() {
		return useCount;
	}
	public void setUseCount(int useCount) {
		this.useCount = useCount;
	}

	
}
