package com.javateam.pet_project.entity;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class WalkingrouteDto {
	private int routeNumber;              //산책 번호
	private String routeName;             //산첵 주제
	private String routeDistance;         //산책 거리
	private String routeStart;            //산책 시작점
	private String routeEnd;              //산책 끝점
	private String routeDescription;      //산책 설명
	private String writer;                //작성자
	private Date writeDate;               //작성일자
	private MultipartFile routeImage;     //산책이미지
}
