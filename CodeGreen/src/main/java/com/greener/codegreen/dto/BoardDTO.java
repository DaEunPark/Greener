package com.greener.codegreen.dto;



import java.sql.Timestamp;


import org.springframework.stereotype.Component;


//---------------------------------------------
//Manager_board  관리자 게시판 Manager_board DB데이터 운반
//---------------------------------------------
@Component("boardDTO")
public class BoardDTO {
	
	//Board_category
		int 	bc_code;  		 //사용할 카테고리 분류
		String 	bc_name; 		 //카테고리 이름
		int 	bc_code_ref; 	 //카테고리 하위
		int 	bc_level;		 //카테고리 상위
	//FAQ
		 int 	f_no;			//FAQ 게시글번호 
		 int 	f_bc_code;		//FAQ 하위 카테고리 분류용 
		 String f_m_id;			//FAQ에 글 등록할 관리자id
		 String f_title;		//FAQ 제목 
		 String f_content;		//FAQ 내용
		 Timestamp f_regdate;		//FAQ 생성일자
		 int	f_readcount;    //FAQ 조회수
	//Notice
		 int n_no;			//Notice 게시글번호 
		 int 	n_bc_code;		//Notice 하위 카테고리 분류용
		 String n_m_id;			//Notice에 글 등록할 관리자id
		 String n_title;		//Notice 제목
		 String n_content;		//Notice 내용
		 Timestamp  n_regdate;		//Notice 생성일자
		 int 	n_readcount;	//Notice 조회수
	//Inquiry	
		 int 	i_no;			//Inquiry 게시글 번호	
		 int 	i_bc_code;		//Inquiry 하위 카테고리 분류용
		 String	i_title;		//Inquiry 폼 소비자문의 제목 	
		 String	i_b_id;			//Inquiry 폼 소비자 id
		 String i_content;		//Inquiry 폼 소비자 문의내용
		 Timestamp	i_regdate;		//Inquiry 폼 소비자 문의생성일자 
		 String i_m_id;			//Inquiry 폼 관리자 id
		 int  	i_answer;		//Inquiry 폼 관리자 답변여부 1 or 0
		 String	i_an_content;	//Inquiry 폼 관리자 답변내용
		 //yyyy-MM-dd hh:mm:ss 형태로 받아야해서 inquiryUpdate에서 리턴되어 돌아올때 패턴값 바꿈
		 Timestamp i_an_date;		//Inquiry 폼 관리자 답변일자
		
		 
		 
		 
		 public int getBc_code() {
			return bc_code;
		}
		public void setBc_code(int bc_code) {
			this.bc_code = bc_code;
		}
		public String getBc_name() {
			return bc_name;
		}
		public void setBc_name(String bc_name) {
			this.bc_name = bc_name;
		}
		public int getBc_code_ref() {
			return bc_code_ref;
		}
		public void setBc_code_ref(int bc_code_ref) {
			this.bc_code_ref = bc_code_ref;
		}
		public int getBc_level() {
			return bc_level;
		}
		public void setBc_level(int bc_level) {
			this.bc_level = bc_level;
		}
		public int getF_no() {
			return f_no;
		}
		public void setF_no(int f_no) {
			this.f_no = f_no;
		}
		public int getF_bc_code() {
			return f_bc_code;
		}
		public void setF_bc_code(int f_bc_code) {
			this.f_bc_code = f_bc_code;
		}
		public String getF_m_id() {
			return f_m_id;
		}
		public void setF_m_id(String f_m_id) {
			this.f_m_id = f_m_id;
		}
		public String getF_title() {
			return f_title;
		}
		public void setF_title(String f_title) {
			this.f_title = f_title;
		}
		public String getF_content() {
			return f_content;
		}
		public void setF_content(String f_content) {
			this.f_content = f_content;
		}
		public Timestamp getF_regdate() {
			return f_regdate;
		}
		public void setF_regdate(Timestamp f_regdate) {
			this.f_regdate = f_regdate;
		}
		public int getF_readcount() {
			return f_readcount;
		}
		public void setF_readcount(int f_readcount) {
			this.f_readcount = f_readcount;
		}
		public int getN_no() {
			return n_no;
		}
		public void setN_no(int n_no) {
			this.n_no = n_no;
		}
		public int getN_bc_code() {
			return n_bc_code;
		}
		public void setN_bc_code(int n_bc_code) {
			this.n_bc_code = n_bc_code;
		}
		public String getN_m_id() {
			return n_m_id;
		}
		public void setN_m_id(String n_m_id) {
			this.n_m_id = n_m_id;
		}
		public String getN_title() {
			return n_title;
		}
		public void setN_title(String n_title) {
			this.n_title = n_title;
		}
		public String getN_content() {
			return n_content;
		}
		public void setN_content(String n_content) {
			this.n_content = n_content;
		}
		public Timestamp getN_regdate() {
			return n_regdate;
		}
		public void setN_regdate(Timestamp n_regdate) {
			this.n_regdate = n_regdate;
		}
		public int getN_readcount() {
			return n_readcount;
		}
		public void setN_readcount(int n_readcount) {
			this.n_readcount = n_readcount;
		}
		public int getI_no() {
			return i_no;
		}
		public void setI_no(int i_no) {
			this.i_no = i_no;
		}
		public int getI_bc_code() {
			return i_bc_code;
		}
		public void setI_bc_code(int i_bc_code) {
			this.i_bc_code = i_bc_code;
		}
		public String getI_title() {
			return i_title;
		}
		public void setI_title(String i_title) {
			this.i_title = i_title;
		}
		public String getI_b_id() {
			return i_b_id;
		}
		public void setI_b_id(String i_b_id) {
			this.i_b_id = i_b_id;
		}
		public String getI_content() {
			return i_content;
		}
		public void setI_content(String i_content) {
			this.i_content = i_content;
		}
		public Timestamp getI_regdate() {
			return i_regdate;
		}
		public void setI_regdate(Timestamp i_regdate) {
			this.i_regdate = i_regdate;
		}
		public String getI_m_id() {
			return i_m_id;
		}
		public void setI_m_id(String i_m_id) {
			this.i_m_id = i_m_id;
		}
		public int getI_answer() {
			return i_answer;
		}
		public void setI_answer(int i_answer) {
			this.i_answer = i_answer;
		}
		public String getI_an_content() {
			return i_an_content;
		}
		public void setI_an_content(String i_an_content) {
			this.i_an_content = i_an_content;
		}
		public Timestamp getI_an_date() {
			return i_an_date;
		}
		public void setI_an_date(Timestamp i_an_date) {
			this.i_an_date = i_an_date;
		}
		 
		 
		 
	
	

}// public class BoardDTO {
