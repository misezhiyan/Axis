package wsdd.chain;

import org.apache.axis.SimpleChain;

public class Chain extends SimpleChain {

	// 自定义Handler串
	public Chain() {
		// 调用Handler
		ChainHandler1 hanler1 = new ChainHandler1();
		ChainHandler2 hanler2 = new ChainHandler2();
		// 将使用的handler放入chain
		this.addHandler(hanler1);
		this.addHandler(hanler2);

	}

}
