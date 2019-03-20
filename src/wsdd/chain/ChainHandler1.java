package wsdd.chain;

import org.apache.axis.AxisFault;
import org.apache.axis.MessageContext;
import org.apache.axis.handlers.BasicHandler;

public class ChainHandler1 extends BasicHandler {

	@Override
	public void invoke(MessageContext msgContext) throws AxisFault {

		String state = (String) this.getOption("state");

		System.out.println("��ʱ���õ���:ChainHandler1");
		System.out.println("��ʼ������:" + state);
	}
}
