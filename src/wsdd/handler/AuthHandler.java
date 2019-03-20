package wsdd.handler;

import org.apache.axis.AxisFault;
import org.apache.axis.MessageContext;
import org.apache.axis.handlers.BasicHandler;
import org.apache.axis.security.AuthenticatedUser;
import org.apache.axis.security.SecurityProvider;
import org.apache.axis.security.simple.SimpleSecurityProvider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//账号验证
public class AuthHandler extends BasicHandler {

	Log log = LogFactory.getLog(AuthHandler.class);
	// 认证参数
	String securityProvider = "securityProvider";//安全级别
	String unauthenticated = "unauthenticated";//认证失败
	String authenticatedUser = "authenticatedUser";//认证用户
	String canAuth = "canAuth";

	@Override
	public void invoke(MessageContext context) throws AxisFault {
		log.info("AuthentiocationHandler : invoke : start");

		// 获取当前安全服务
		SecurityProvider provider = (SecurityProvider) context.getProperty(securityProvider);
		// 判断当前安全机制的状态
		if (provider == null) {
			// 创建安全级别
			provider = new SimpleSecurityProvider();
			context.setProperty(securityProvider, provider);
		}

		// 获取ws服务的认证信息
		String username = context.getUsername();
		String password = context.getPassword();

		log.info("登录名:" + username + " 登录密码:" + password);
		
		//对访问的用户进行认证
		AuthenticatedUser authUser = provider.authenticate(context);//获取预设的用户信息
		if(authUser == null){
			throw new AxisFault(unauthenticated, "账户验证失败", null, null);
		}
		//用户通过认证,将用户设置为认证用户
		context.setProperty(authenticatedUser, authUser);

		log.info("AuthentiocationHandler : invoke : end");
	}

}
