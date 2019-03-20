package wsdd.handler;

import org.apache.axis.AxisFault;
import org.apache.axis.MessageContext;
import org.apache.axis.handlers.BasicHandler;
import org.apache.axis.security.AuthenticatedUser;
import org.apache.axis.security.SecurityProvider;
import org.apache.axis.security.simple.SimpleSecurityProvider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//�˺���֤
public class AuthHandler extends BasicHandler {

	Log log = LogFactory.getLog(AuthHandler.class);
	// ��֤����
	String securityProvider = "securityProvider";//��ȫ����
	String unauthenticated = "unauthenticated";//��֤ʧ��
	String authenticatedUser = "authenticatedUser";//��֤�û�
	String canAuth = "canAuth";

	@Override
	public void invoke(MessageContext context) throws AxisFault {
		log.info("AuthentiocationHandler : invoke : start");

		// ��ȡ��ǰ��ȫ����
		SecurityProvider provider = (SecurityProvider) context.getProperty(securityProvider);
		// �жϵ�ǰ��ȫ���Ƶ�״̬
		if (provider == null) {
			// ������ȫ����
			provider = new SimpleSecurityProvider();
			context.setProperty(securityProvider, provider);
		}

		// ��ȡws�������֤��Ϣ
		String username = context.getUsername();
		String password = context.getPassword();

		log.info("��¼��:" + username + " ��¼����:" + password);
		
		//�Է��ʵ��û�������֤
		AuthenticatedUser authUser = provider.authenticate(context);//��ȡԤ����û���Ϣ
		if(authUser == null){
			throw new AxisFault(unauthenticated, "�˻���֤ʧ��", null, null);
		}
		//�û�ͨ����֤,���û�����Ϊ��֤�û�
		context.setProperty(authenticatedUser, authUser);

		log.info("AuthentiocationHandler : invoke : end");
	}

}
