
/**
 * 即时发布
 * 
 */
public class Immediate {
	// 定制一个服务--方法
	public String test(String a, String b){
		
		String result = "a=" + a + " b=" + b;
		return "server response ok, you send" + result;
	}
}
