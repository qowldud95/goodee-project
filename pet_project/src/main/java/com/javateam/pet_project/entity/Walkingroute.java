package com.javateam.pet_project.entity;

import java.util.Date;

public class Walkingroute {
	private int routeNumber;              //산책 번호
	private String routeName;             //산책 주제
	private String routeDistance;         //산책 거리
	private String routeStart;            //산책 시작점
	private String routeEnd;              //산책 끝점
	private String routeDescription;      //산책 설명
	private String writer;                //작성자
	private Date writeDate;               //작성일자
	private String routeImage;            //산책이미지
	
	public Walkingroute(int routeNumber, String routeName, String routeDistance, String routeStart, String routeEnd,
			String routeDescription, String writer, Date writeDate, String routeImage) {
		super();
		this.routeNumber = routeNumber;
		this.routeName = routeName;
		this.routeDistance = routeDistance;
		this.routeStart = routeStart;
		this.routeEnd = routeEnd;
		this.routeDescription = routeDescription;
		this.writer = writer;
		this.writeDate = writeDate;
		this.routeImage = routeImage;
	}

	public int getRouteNumber() {
		return routeNumber;
	}

	public void setRouteNumber(int routeNumber) {
		this.routeNumber = routeNumber;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public String getRouteDistance() {
		return routeDistance;
	}

	public void setRouteDistance(String routeDistance) {
		this.routeDistance = routeDistance;
	}

	public String getRouteStart() {
		return routeStart;
	}

	public void setRouteStart(String routeStart) {
		this.routeStart = routeStart;
	}

	public String getRouteEnd() {
		return routeEnd;
	}

	public void setRouteEnd(String routeEnd) {
		this.routeEnd = routeEnd;
	}

	public String getRouteDescription() {
		return routeDescription;
	}

	public void setRouteDescription(String routeDescription) {
		this.routeDescription = routeDescription;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public String getRouteImage() {
		return routeImage;
	}

	public void setRouteImage(String routeImage) {
		this.routeImage = routeImage;
	}

	@Override
	public String toString() {
		return "walkingroute [routeNumber=" + routeNumber + ", routeName=" + routeName + ", routeDistance="
				+ routeDistance + ", routeStart=" + routeStart + ", routeEnd=" + routeEnd + ", routeDescription="
				+ routeDescription + ", writer=" + writer + ", writeDate=" + writeDate + ", routeImage=" + routeImage
				+ "]";
	}
	
	
	

}
