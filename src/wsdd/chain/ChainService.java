package wsdd.chain;

public class ChainService {

	private int requestCount = 0;

	public String hello(String name) {

		requestCount++;
		System.out.println("RequestCount:" + requestCount);
		System.out.println("name:" + name);
		
		return "hello " + name;
	}
}
