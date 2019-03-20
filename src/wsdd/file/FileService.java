package wsdd.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//�ļ��ϴ�������
public class FileService {

	Log log = LogFactory.getLog(FileService.class);
	// �ļ����ڰ�
	public static String Repository = "./files";

	// �ļ��ϴ�����
	public String uploadFile(DataHandler dh, String name) {

//		// �ļ��ϴ�ʱ���ļ���
//		if (name == null) {
//			name = "tmp.tmp";
//		}
//		log.info("�ļ���:" + name);
//
//		try {
//			// �ϴ����ļ�·���Ƿ����
//			File dir = new File(Repository);
//			if (!dir.exists()) {
//				dir.mkdir();
//				System.out.println("������");
//			}
//
//			if (dir.exists()) {
//				// ��ȡ�ļ���
//				// InputStream input = dh.getInputStream();
//				// �����ļ������
//				// FileOutputStream fos = new FileOutputStream(new File(dir, name));
//				// ����������
//				byte[] buffer = new byte[1024];
//				// ��ȡ�ļ�����
//				int n = 0;
//				// while ((n = input.read(buffer)) != -1) {
//				// fos.write(buffer, 0, n);
//				// fos.flush();
//				// }
//				// fos.close();
//				// input.close();
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			log.fatal(e.getMessage());
//		}

		return "�ϴ��ļ�:" + name;
	}

	// �ļ�����
	public DataHandler[] downLoadFiles(String name) {

		// log.info("�����ļ���:" + name);

		File dir = new File(Repository);// �����ļ������ļ���
		DataHandler[] handlers;
		if (null != name) {
			// �����ļ�
			File file = new File(dir, name);
			handlers = new DataHandler[1];// ÿ��ʹ��һ��������
			handlers[0] = new DataHandler(new FileDataSource(file));// ���ļ���װ�����ݶ���
		} else {
			// �����ļ�
			File[] listFiles = dir.listFiles();
			handlers = new DataHandler[listFiles.length];// ʹ�ö���ļ�������
			for (int i = 0; i < listFiles.length; i++) {
				handlers[i] = new DataHandler(new FileDataSource(listFiles[i]));
			}
		}

		return handlers;
	}
}
