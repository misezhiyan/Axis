package wsdd.handler;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;

import org.apache.axis.AxisFault;
import org.apache.axis.MessageContext;
import org.apache.axis.handlers.BasicHandler;
import org.apache.axis.handlers.soap.SOAPService;

public class LogHandler extends BasicHandler {

	// invoke是每个Handler必须实现的
	@Override
	public void invoke(MessageContext arg0) throws AxisFault {
		// 每当web服务被调用的时候, 记录log中
		try {
			// 通过 MessageContext 获取服务
			SOAPService service = arg0.getService();
			// 生成log文件名
			String logFile = (String) this.getOption("logFileName");// 获取当前web上的log日志文件
			if (null == logFile || "".equals(logFile)) {
				throw new AxisFault("server no logFile", "no log file configuration for the logHandler", null, null);
			}
			// 创建基础文件
			FileOutputStream fos = new FileOutputStream(logFile, true);
			// 包装基础文件输出流--格式化
			PrintWriter writer = new PrintWriter(fos);
			// 统计web服务,被调用次数
			Integer count = (Integer) service.getOption("access");
			if (null == count)
				count = 0;
			count++;
			// 在控制台上显示
			arg0.getMessage().writeTo(System.out);
			// 创建日志信息
			String log = "在 " + new Date() + " web服务:" + arg0.getTargetService() + " 被调用。至此共调用次数:" + count;
			
			service.setOption("access", count);
			writer.println(log);
			writer.flush();
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
