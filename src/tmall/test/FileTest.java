package tmall.test;

import java.io.File;

public class FileTest {
	static long minSize = Integer.MAX_VALUE;
	static long maxSize = 0;
	static File minFile = null;
	static File maxFile = null;

	private static void search(File f) {
		File[] fs = f.listFiles();
		if (null == fs) {
			return;
		}
		for (File file : fs) {
			if(file.isDirectory()) {
				search(file);
			}
			if(maxSize<file.length()) {
				maxFile=file;
				maxSize=file.length();
			}
			if(minSize>file.length()&&0!=file.length()) {
				minSize=file.length();
				minFile=file;	
			}
		}
	}

	public static void main(String[] args) {
		File f = new File("C:\\WINDOWS");
		search(f);
		System.out.println("最大文件是：" + maxFile.getAbsolutePath() + "其中大小是" + maxFile.length() + "字节");
		System.out.println("最小文件是：" + minFile.getAbsolutePath() + "其中大小是" + minFile.length() + "字节");

	}

}
