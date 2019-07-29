package ipproxypool.Myexception;

public class checkStringNull {
	public static void check(String response) throws responseException {
		if(response==null) {
			throw new responseException("返回为空，该ip不可用");
		}else {
			System.out.println("该ip正常使用");
		}
	}
}
