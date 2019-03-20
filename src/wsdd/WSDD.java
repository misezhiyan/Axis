package wsdd;

public class WSDD {

	// 定制web服务(属性, 方法)

	private int requestCount = 0;

	public String test(String name) {
		
		requestCount++;
		System.out.println("调用次数:" + requestCount);
		return "欢迎你: " + name;
	}

	public Float add(Float a, Float b) {

		return a + b;
	}
}
