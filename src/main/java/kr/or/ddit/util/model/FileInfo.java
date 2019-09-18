package kr.or.ddit.util.model;

import java.io.File;

public class FileInfo {
	
	private File file;				//업로드 경로를 포함한 파일 객체
	private String originalFileName; //업로드한 실제 파일명
	private String extName; 		//파일확장자(.포함)
	
	
	
	public FileInfo() {
		
	}
	
	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public FileInfo(File file, String extName, String originalFileName) {
		this.file = file;
		this.originalFileName = originalFileName;
		this.extName = extName;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}

	public String getExtName() {
		return extName;
	}
	public void setExtName(String extName) {
		this.extName = extName;
	}
	
	
	
}
