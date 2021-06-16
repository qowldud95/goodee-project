package com.javateam.pet_project.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private int id;                      //회원 고유아이디
	private String memberId;             //회원 아이디
	private String memberPw;             //회원 비밀번호
	private String memberName;           //회원 이름
	private String memberNickname;       //회원 닉네임
	private int memberPhone;             //회원 폰번호
	private String memberAddress;        //회원 주소
	private Date regDate;                //가입일자
}
