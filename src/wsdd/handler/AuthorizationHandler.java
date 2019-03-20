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

//授权
public class AuthorizationHandler extends BasicHandler {

	Log log = LogFactory.getLog(AuthorizationHandler.class);

	@Override
	public void invoke(MessageContext context) throws AxisFault {
		log.info("AuthentiocationHandler : invoke : start");

		// 创建一个授权用户
		AuthenticatedUser authenticatedUser = (AuthenticatedUser) context.getProperty("authenticatedUser");
		if (null == authenticatedUser) {
			throw new AxisFault("Server. not User", Messages.getMessage("needUser00"), null, null);
		}
		// 从认证用户中, 获取用户名
		String username = authenticatedUser.getName();
		System.out.println("username:" + username);

		Handler handler = context.getService();
		if (null == handler)// 判断当前ws服务是否存在
			throw new AxisFault(Messages.getMessage("needService00"));
		// 获取服务名
		String servicename = handler.getName();
		// 生成访问角色信息
		String allowedRoles = (String) handler.getOption("allowedRoles");
		if (null == allowedRoles || "".equals(allowedRoles)) {
			log.info("不需要验证");
			return;
		}
		// 开始授权认证
		SecurityProvider provider = (SecurityProvider) context.getProperty("securityProvider");
		if (provider == null)
			throw new AxisFault(Messages.getMessage("noSecurityProvider00"));

		// 根据allowedRoles字符串, 进行验证
		for (StringTokenizer st = new StringTokenizer(allowedRoles, ","); st.hasMoreTokens();) {
			// 取出roles信息
			String token = st.nextToken();
			System.out.println("token:" + token);
			// 比对
			if (provider.userMatches(authenticatedUser, token)) {
				log.info("通过验证:" + token);
				return;
			}
		}
		// 验证失败
		throw new AxisFault("验证失败");

	}

}
