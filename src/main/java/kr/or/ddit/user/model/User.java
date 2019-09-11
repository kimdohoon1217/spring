package kr.or.ddit.user.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;

public class User implements HttpSessionBindingListener{
	private static final Logger logger = LoggerFactory.getLogger(User.class);
	
	private String userId;		//사용자 아이디
	private String pass;		//사용자 비밀번호
	private String userNm;	//사용자 이름
	private String alias;	//별명
	private Date reg_dt;		// 등록일
	private String addr1;	//주소1
	private String addr2; 	//주소2
	private String zipcode;	  //우편번호
	private String filename;	//파일명(사용자 업로드 파일명)
	private String realFilename;	//물리 파일명
	private String realfilename2;
	
	public String getRealfilename2() {
		return realfilename2;
	}
	
	public void setRealfilename2(String realfilename2) {
		this.realfilename2 = realfilename2;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getRealFilename() {
		return realFilename;
	}

	public void setRealFilename(String realFilename) {
		this.realFilename = realFilename;
	}

	public String getAlias() {
		return alias;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Date getReg_dt() {
		return reg_dt;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getReg_dt_fmt() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(reg_dt);
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public User() {
		
	}

	public User(String userNm) {
		super();
		this.userNm = userNm;
	}
	
	public User(String userId, String userNm, String alias, Date reg_dt, String addr1, String addr2,
			String zipcode, String pass, String filename, String realFilename) {
		this.userId = userId;
		this.userNm = userNm;
		this.alias = alias;
		this.reg_dt = reg_dt;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.zipcode = zipcode;
		this.pass = pass;
		this.filename = filename;
		this.realFilename = realFilename;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", pass=" + pass + ", userNm=" + userNm + ", alias=" + alias + ", reg_dt="
				+ reg_dt + ", addr1=" + addr1 + ", addr2=" + addr2 + ", zipcode=" + zipcode + ", filename=" + filename
				+ ", realFilename=" + realFilename + "]";
	}

	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}

	//이름 바꿀때 alt + shift + r
	public boolean checkLoginValidate(String userId, String pass) {
		
		//암호화 문장끼리 비교
		if(userId.equals(this.userId) && KISA_SHA256.encrypt(pass).equals(this.pass))
			return true;
		
		return false;
	}

	//value가 들어갈떄
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		logger.debug("value bound");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		logger.debug("value unbound");
		
	}
	
}
