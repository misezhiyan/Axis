package wsdd.handler;

import java.util.StringTokenizer;

import org.apache.axis.AxisFault;
import org.apache.axis.Handler;
import org.apache.axis.MessageContext;
import org.apache.axis.handlers.BasicHandler;
import org.apache.axis.handlers.soap.SOAPService;
import org.apache.axis.security.AuthenticatedUser;
import org.apache.axis.security.SecurityProvider;
import org.apache.axis.security.simple.SimpleSecurityProvider;
import org.apache.axis.utils.Messages;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//��Ȩ
public class AuthorizationHandler extends BasicHandler {

	Log log = LogFactory.getLog(AuthorizationHandler.class);

	@Override
	public void invoke(MessageContext context) throws AxisFault {
		log.info("AuthentiocationHandler : invoke : start");

		// ����һ����Ȩ�û�
		AuthenticatedUser authenticatedUser = (AuthenticatedUser) context.getProperty("authenticatedUser");
		if (null == authenticatedUser) {
			throw new AxisFault("Server. not User", Messages.getMessage("needUser00"), null, null);
		}
		// ����֤�û���, ��ȡ�û���
		String username = authenticatedUser.getName();
		System.out.println("username:" + username);

		Handler handler = context.getService();
		if (null == handler)// �жϵ�ǰws�����Ƿ����
			throw new AxisFault(Messages.getMessage("needService00"));
		// ��ȡ������
		String servicename = handler.getName();
		// ���ɷ��ʽ�ɫ��Ϣ
		String allowedRoles = (String) handler.getOption("allowedRoles");
		if (null == allowedRoles || "".equals(allowedRoles)) {
			log.info("����Ҫ��֤");
			return;
		}
		// ��ʼ��Ȩ��֤
		SecurityProvider provider = (SecurityProvider) context.getProperty("securityProvider");
		if (provider == null)
			throw new AxisFault(Messages.getMessage("noSecurityProvider00"));

		// ����allowedRoles�ַ���, ������֤
		for (StringTokenizer st = new StringTokenizer(allowedRoles, ","); st.hasMoreTokens();) {
			// ȡ��roles��Ϣ
			String token = st.nextToken();
			System.out.println("token:" + token);
			// �ȶ�
			if (provider.userMatches(authenticatedUser, token)) {
				log.info("ͨ����֤:" + token);
				return;
			}
		}
		// ��֤ʧ��
		throw new AxisFault("��֤ʧ��");

	}

}
