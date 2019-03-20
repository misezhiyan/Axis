package wsdd.handler;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;

import org.apache.axis.AxisFault;
import org.apache.axis.MessageContext;
import org.apache.axis.handlers.BasicHandler;
import org.apache.axis.handlers.soap.SOAPService;

public class LogHandler extends BasicHandler {

	// invoke��ÿ��Handler����ʵ�ֵ�
	@Override
	public void invoke(MessageContext arg0) throws AxisFault {
		// ÿ��web���񱻵��õ�ʱ��, ��¼log��
		try {
			// ͨ�� MessageContext ��ȡ����
			SOAPService service = arg0.getService();
			// ����log�ļ���
			String logFile = (String) this.getOption("logFileName");// ��ȡ��ǰweb�ϵ�log��־�ļ�
			if (null == logFile || "".equals(logFile)) {
				throw new AxisFault("server no logFile", "no log file configuration for the logHandler", null, null);
			}
			// ���������ļ�
			FileOutputStream fos = new FileOutputStream(logFile, true);
			// ��װ�����ļ������--��ʽ��
			PrintWriter writer = new PrintWriter(fos);
			// ͳ��web����,�����ô���
			Integer count = (Integer) service.getOption("access");
			if (null == count)
				count = 0;
			count++;
			// �ڿ���̨����ʾ
			arg0.getMessage().writeTo(System.out);
			// ������־��Ϣ
			String log = "�� " + new Date() + " web����:" + arg0.getTargetService() + " �����á����˹����ô���:" + count;
			
			service.setOption("access", count);
			writer.println(log);
			writer.flush();
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
