package wsdd.chain;

import org.apache.axis.SimpleChain;

public class Chain extends SimpleChain {

	// �Զ���Handler��
	public Chain() {
		// ����Handler
		ChainHandler1 hanler1 = new ChainHandler1();
		ChainHandler2 hanler2 = new ChainHandler2();
		// ��ʹ�õ�handler����chain
		this.addHandler(hanler1);
		this.addHandler(hanler2);

	}

}
