package wsdd;

public class WSDD {

	// ����web����(����, ����)

	private int requestCount = 0;

	public String test(String name) {
		
		requestCount++;
		System.out.println("���ô���:" + requestCount);
		return "��ӭ��: " + name;
	}

	public Float add(Float a, Float b) {

		return a + b;
	}
}
