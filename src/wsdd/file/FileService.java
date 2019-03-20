package wsdd.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

//文件上传与下载
public class FileService {

	Log log = LogFactory.getLog(FileService.class);
	// 文件所在包
	public static String Repository = "./files";

	// 文件上传到此
	public String uploadFile(DataHandler dh, String name) {

//		// 文件上传时的文件名
//		if (name == null) {
//			name = "tmp.tmp";
//		}
//		log.info("文件名:" + name);
//
//		try {
//			// 上传的文件路径是否存在
//			File dir = new File(Repository);
//			if (!dir.exists()) {
//				dir.mkdir();
//				System.out.println("不存在");
//			}
//
//			if (dir.exists()) {
//				// 获取文件流
//				// InputStream input = dh.getInputStream();
//				// 创建文件输出流
//				// FileOutputStream fos = new FileOutputStream(new File(dir, name));
//				// 创建缓冲区
//				byte[] buffer = new byte[1024];
//				// 读取文件内容
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

		return "上传文件:" + name;
	}

	// 文件下载
	public DataHandler[] downLoadFiles(String name) {

		// log.info("下载文件名:" + name);

		File dir = new File(Repository);// 下载文件所在文件夹
		DataHandler[] handlers;
		if (null != name) {
			// 单个文件
			File file = new File(dir, name);
			handlers = new DataHandler[1];// 每次使用一个传输器
			handlers[0] = new DataHandler(new FileDataSource(file));// 将文件包装成数据对象
		} else {
			// 所有文件
			File[] listFiles = dir.listFiles();
			handlers = new DataHandler[listFiles.length];// 使用多个文件传输器
			for (int i = 0; i < listFiles.length; i++) {
				handlers[i] = new DataHandler(new FileDataSource(listFiles[i]));
			}
		}

		return handlers;
	}
}
