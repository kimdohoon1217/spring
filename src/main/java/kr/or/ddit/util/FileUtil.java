package kr.or.ddit.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import kr.or.ddit.util.model.FileInfo;

public class FileUtil {

	public static FileInfo getFileInfo(String originalFileName) {
		
		String path = getPath();
		
		String uuidFileName = UUID.randomUUID().toString();
		String extName = getExtenSion(originalFileName);
		//d:\\2019\\09\\james.png
		
		File file = new File(path + "\\" + uuidFileName + extName);
		FileInfo fileInfo = new FileInfo(file, extName, originalFileName);
		
		return fileInfo;
	}


	private static String getPath() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String yyyyMM = sdf.format(new Date());
		String yyyy = yyyyMM.substring(0, 4);
		String mm = yyyyMM.substring(4, 6);
		
		//d:\\2019\\09
		String path = "d:\\springUpload\\" + yyyy + "\\" + mm;
		File pathFile = new File(path);
		if(!pathFile.exists())
			pathFile.mkdirs();
		return path;
	}

	
	public static String getExtenSion(String originalFileName) {
		//확장자가 없을경우 공백리턴
		//파일명에 .이 여러개 등장할경우 가장 마지막에있는 녀석이 확장자 구분자로 판단
		String ext = "";
		if(originalFileName.lastIndexOf(".") > 0) {
			ext = originalFileName.substring(originalFileName.lastIndexOf("."));
			return ext;
		}else {
			//음수면 없는거
			return ext;
		}
		
		
		
	}
	
}
